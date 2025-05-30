import { GioHangService } from "../../../_service/giohang.service";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { jwtDecode } from "jwt-decode";
import { Cookie } from "ng2-cookies";
import { ToastrService } from "ngx-toastr";
import { lastValueFrom } from "rxjs";
import { AuthConstant } from "src/app/_constant/auth.constant";
import { CommonConstant } from "src/app/_constant/common.constants";
import { NguoiDung } from "src/app/_model/auth/nguoidung";
import { SearchModel } from "src/app/_model/common/Search";
import { DanhGia } from "src/app/_model/danhgia";
import { GioHang } from "src/app/_model/giohang";
import { GioHangChiTiet } from "src/app/_model/giohangchitiet";
import { LoaiThuoc } from "src/app/_model/loaithuoc";
import { Thuoc } from "src/app/_model/thuoc";
import { NguoidungService } from "src/app/_service/auth/nguoidung.service";
import { DanhgiaService } from "src/app/_service/danhgia.service";
import { LoaithuocService } from "src/app/_service/loaithuoc.service";
import { ThuocService } from "src/app/_service/thuoc.service";

@Component({
  selector: "app-thuoc-chitiet",
  templateUrl: "./thuoc-chitiet.component.html",
  styleUrls: ["./thuoc-chitiet.component.css"],
})
export class ThuocChiTietComponent implements OnInit {
  thuoc: Thuoc = {};
  loaithuocLst: LoaiThuoc[] = [];

  userInfo: NguoiDung = {};

  gioHangId: number = 0;

  isAdmin: boolean = false;

  showCopyMessage = false;

  thuocTT: Thuoc[] = [];
  id: string = "";
  tenLoaiThuoc: string = "";

  danhgiaLst: DanhGia[] = [];
  modelSearch: SearchModel = {
    keyWord: "",
    id: 0,
    currentPage: 0,
    size: 100,
    sortedField: "",
    loaiThuoc: "",
  };
  constructor(
    private thuocService: ThuocService,
    private loaithuocService: LoaithuocService,
    private router: Router,
    private route: ActivatedRoute,
    private gioHangService: GioHangService,
    private danhgiaService: DanhgiaService,
    private nguoidungService: NguoidungService,
    private toastService: ToastrService
  ) {}

  ngOnInit() {
    this.getData();
    this.getThuocByParam();

    this.getUserInfo();
  }

  getThuocByParam() {
    this.route.paramMap.subscribe(async (params) => {
      this.thuoc.id = this.route.snapshot.paramMap.get("id") || "";
      if (this.thuoc.id) {
        this.getThuocById(this.thuoc.id);
      }
    });
  }

  getThuocById(id: string) {
    this.thuocService.getProduct(id).subscribe((res) => {
      if (res.status == CommonConstant.STATUS_OK_200) {
        this.thuoc = res.data;

        this.getDanhGiaByThuocId();
      }
    });
  }

  getDanhGiaByThuocId() {
    this.modelSearch.id = Number(this.thuoc.id);
    this.danhgiaService.getLst(this.modelSearch).subscribe((res) => {
      if (res.status == CommonConstant.STATUS_OK_200) {
        this.danhgiaLst = res.data.data;
      }
    });
  }

  getData() {
    this.getLoaiThuoc();
    this.getThuocTT();
  }

  getLoaiThuoc() {
    this.loaithuocService.getLoaiThuocLst(this.modelSearch).subscribe((res) => {
      if (res.status == CommonConstant.STATUS_OK_200) {
        this.loaithuocLst = res.data;
      }
    });
  }

  getThuocTT() {
    this.route.queryParams.subscribe(async (params) => {
      this.id = this.route.snapshot.paramMap.get("id") || ""; // Lấy id loại thuốc từ tham số URL
      // console.log(this.id);
      this.thuocService.getProduct(this.id).subscribe((res) => {
        if (res.status == CommonConstant.STATUS_OK_200) {
          this.thuoc = res.data;
          const modelSearch = { loaiThuoc: this.thuoc.loaiThuoc?.tenLoai }; // Tạo đối tượng modelSearch với tên loại thuốc
          this.thuocService.getProductLst(modelSearch).subscribe((res) => {
            if (res.status == "200") {
              this.thuocTT = res.data.data.filter((thuoc: any) => thuoc.id !== this.thuoc.id);
              console.log(this.thuocTT);
            }
          });
        }
      });
    });
  }

  showDetail(thuoc: Thuoc) {
    this.router.navigate([`/thuoc-chitiet/${thuoc.id}`]);
  }


  addProductInCart(item?: Thuoc) {
    if (Cookie.check(AuthConstant.ACCESS_TOKEN_KEY)) {
      // Nếu có truyền sản phẩm cụ thể, sử dụng sản phẩm đó
      // Nếu không, sử dụng sản phẩm hiện tại (this.thuoc)
      const thuocToAdd = item || this.thuoc;
      this.createGH(thuocToAdd);
    } else {
      this.router.navigate([`/login`]);
    }
  }

  async getUserInfo(): Promise<void> {
    const _token = Cookie.get(AuthConstant.ACCESS_TOKEN_KEY);

    const userInfo = jwtDecode(_token) as NguoiDung;
    if (userInfo.id) {
      const resp = await lastValueFrom(this.nguoidungService.get(userInfo.id));
      if (resp.status == CommonConstant.STATUS_OK_200) {
        this.userInfo = resp.data;

        if (
          this.userInfo.nhomQuyens?.some(
            (quyen) => quyen.id == AuthConstant.ROLE_ADMIN.toString()
          )
        ) {
          this.isAdmin = true;
        }
        if (this.userInfo.id) {
          this.getGH();
        }
      }
    }
  }

  getGH() {
    this.gioHangService.getGH(this.userInfo.id).subscribe((res) => {
      if (res.status == CommonConstant.STATUS_OK_200) {
        if (res.data.id) {
          this.gioHangId = res.data.id;
        }
      }
    });
  }

  createGH(thuoc: Thuoc) {
    // Nếu chưa có ID giỏ hàng, thử lấy lại từ API
    if (!this.gioHangId && this.userInfo.id) {
      console.log('Đang lấy lại ID giỏ hàng...');
      // Sử dụng Promise để đảm bảo lấy giỏ hàng xong trước khi tiếp tục
      this.gioHangService.getGH(this.userInfo.id).subscribe({
        next: (res) => {
          if (res.status == CommonConstant.STATUS_OK_200 && res.data && res.data.id) {
            this.gioHangId = res.data.id;
            console.log('Đã lấy được ID giỏ hàng:', this.gioHangId);
            // Sau khi có ID giỏ hàng, tiếp tục thêm sản phẩm
            this.addToCart(thuoc);
          } else {
            console.error('Không thể lấy ID giỏ hàng:', res);
            this.toastService.error("Không thể thêm vào giỏ hàng. Vui lòng đăng nhập lại.");
          }
        },
        error: (err) => {
          console.error('Lỗi khi lấy ID giỏ hàng:', err);
          this.toastService.error("Không thể thêm vào giỏ hàng. Vui lòng đăng nhập lại.");
        }
      });
    } else if (this.gioHangId) {
      // Nếu đã có ID giỏ hàng, tiếp tục thêm sản phẩm
      this.addToCart(thuoc);
    } else {
      console.error('Không tìm thấy ID giỏ hàng và ID người dùng');
      this.toastService.error("Không thể thêm vào giỏ hàng. Vui lòng đăng nhập lại.");
    }
  }

  // Hàm thực sự thêm sản phẩm vào giỏ hàng sau khi đã có ID giỏ hàng
  private addToCart(thuoc: Thuoc) {
    console.log('Thông tin sản phẩm thêm vào giỏ hàng:', thuoc);
    console.log('ID giỏ hàng:', this.gioHangId);
    console.log('ID người dùng:', this.userInfo.id);

    let gioHang: GioHangChiTiet = {
      gioHangId: this.gioHangId,
      soLuong: 1,
      thuocId: Number(thuoc.id),
      donGia: thuoc.giaBan,
    };

    this.gioHangService.createGH(gioHang).subscribe({
      next: (resp) => {
        console.log('Response thêm giỏ hàng:', resp);
        if (resp && resp.status == CommonConstant.STATUS_OK_200) {
          this.toastService.success("Thêm vào giỏ hàng thành công");
          this.gioHangService.getGHSubject(this.userInfo.id).subscribe();
        } else {
          this.toastService.error("Thêm vào giỏ hàng thất bại: " + (resp?.msg || 'Không có phản hồi từ server'));
        }
      },
      error: (err) => {
        console.error('Lỗi khi thêm vào giỏ hàng:', err);
        this.toastService.error("Lỗi khi thêm vào giỏ hàng: " + (err.message || 'Không xác định'));
      }
    });
  }

  copyToClipboard(value?: string): void {
    if (value) {
      navigator.clipboard
        .writeText(value)
        .then(() => {
          this.showCopyMessage = true;

          // Tự động ẩn thông báo sau 2 giây
          setTimeout(() => {
            this.showCopyMessage = false;
          }, 2000);
        })
        .catch((err) => {
          console.error("Failed to copy text: ", err);
        });
    } else {
      console.error("No text to copy");
    }
  }
}
