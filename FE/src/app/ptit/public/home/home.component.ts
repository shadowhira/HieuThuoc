import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { CommonConstant } from "src/app/_constant/common.constants";
import { SearchModel } from "src/app/_model/common/Search";
import { LoaiThuoc } from "src/app/_model/loaithuoc";
import { Thuoc } from "src/app/_model/thuoc";
import { LoaithuocService } from "src/app/_service/loaithuoc.service";
import { ThuocService } from "src/app/_service/thuoc.service";
import { Cookie } from "ng2-cookies";
import { AuthConstant } from "src/app/_constant/auth.constant";
import { GioHangChiTiet } from "src/app/_model/giohangchitiet";
import { GioHang } from "src/app/_model/giohang";
import { ToastrService } from "ngx-toastr";
import { GioHangService } from "../../../_service/giohang.service";
import { NguoiDung } from "src/app/_model/auth/nguoidung";
import { jwtDecode } from "jwt-decode";
import { lastValueFrom } from "rxjs";
import { NguoidungService } from "src/app/_service/auth/nguoidung.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  productLst: Thuoc[] = [];
  loaithuocLst: LoaiThuoc[] = [];
  paginatedProductLst: Thuoc[] = [];
  productBS: Thuoc[] = [];

  gioHangId: number = 0;
  userInfo: NguoiDung = {};
  thuoc: Thuoc = {};
  currentPage = 1;
  totalPage = 1;
  pages: number[] = [];
  itemsPerPage: number = CommonConstant.ROW_OF_PAGE_12;
  maxVisiblePages: number = 3;

  modelSearch: any = {
    keyWord: "",
    id: 0,
    currentPage: 0,
    size: 1000,
    sortedField: "",
    trangThai: true,
    // Các trường bổ sung cho SearchThuocDTO
    loaiThuoc: "",
    nhaSanXuat: "",
    danhMucThuoc: "",
    minGiaBan: null,
    maxGiaBan: null,
    tenDoiTuong: ""
  };

  constructor(
    private thuocService: ThuocService,
    private loaithuocService: LoaithuocService,
    private router: Router,
    private gioHangService: GioHangService,
    private nguoidungService: NguoidungService,

    private toastService: ToastrService
  ) {}

  ngOnInit() {
    this.getData();
  }

  search() {
    console.log('Đang tìm kiếm với từ khóa:', this.modelSearch.keyWord);
    // Đảm bảo tham số trangThai luôn được gửi đi
    if (this.modelSearch.trangThai === undefined) {
      this.modelSearch.trangThai = true;
    }

    // Nếu từ khóa tìm kiếm trống, đảm bảo gửi chuỗi rỗng để lấy tất cả sản phẩm
    if (!this.modelSearch.keyWord || this.modelSearch.keyWord.trim() === '') {
      this.modelSearch.keyWord = '';
    }

    // Reset về trang đầu tiên khi tìm kiếm
    this.currentPage = 1;
    this.getThuoc();
  }
  getData() {
    // Đảm bảo tham số trangThai luôn được gửi đi
    if (this.modelSearch.trangThai === undefined) {
      this.modelSearch.trangThai = true;
    }

    // Đảm bảo keyWord là chuỗi rỗng khi khởi tạo để lấy tất cả sản phẩm
    this.modelSearch.keyWord = '';

    this.getThuoc();
    this.getUserInfo();
    this.bestSale();
  }

  async getUserInfo(): Promise<void> {
    try {
      const _token = Cookie.get(AuthConstant.ACCESS_TOKEN_KEY);

      if (!_token) {
        console.log('Không có token, người dùng chưa đăng nhập');
        return;
      }

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
            // Xử lý quyền admin nếu cần
          }

          if (this.userInfo.id) {
            this.getGH();
          }
        }
      }
    } catch (error) {
      console.error('Lỗi khi lấy thông tin người dùng:', error);
    }
  }

  bestSale(){
    // Vẫn sử dụng API get_thuoc_ban_chay để lấy sản phẩm bán chạy
    this.thuocService.getProductBestsale(this.modelSearch).subscribe({
      next: (res) => {
        if (res.status == CommonConstant.STATUS_OK_200) {
          this.productBS = res.data.data || [];
          console.log('Sản phẩm bán chạy:', this.productBS);
        }
      },
      error: (err) => {
        console.error('Lỗi khi lấy sản phẩm bán chạy:', err);
        this.productBS = [];
      }
    });
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

  getThuoc() {
    console.log('Gửi request tìm kiếm với tham số:', JSON.stringify(this.modelSearch));
    // Sử dụng getProductLst đã được sửa để sử dụng API search
    this.thuocService.getProductLst(this.modelSearch).subscribe({
      next: (res) => {
        console.log('Kết quả trả về từ API:', res);
        if (res.status == CommonConstant.STATUS_OK_200) {
          // Đảm bảo data.data là một mảng, nếu không thì gán mảng rỗng
          this.productLst = Array.isArray(res.data.data) ? res.data.data : [];
          console.log('Danh sách sản phẩm:', this.productLst);

          if (this.productLst.length === 0 && this.modelSearch.keyWord && this.modelSearch.keyWord.trim() !== '') {
            console.log('Không tìm thấy sản phẩm nào với từ khóa:', this.modelSearch.keyWord);
            this.toastService.info(`Không tìm thấy sản phẩm nào với từ khóa "${this.modelSearch.keyWord}"`);
          }

          // Calculate total pages
          this.totalPage = Math.ceil(this.productLst.length / this.itemsPerPage) || 1; // Đảm bảo ít nhất là 1 trang
          console.log('Tổng số trang:', this.totalPage);

          // Generate page numbers
          this.updatePaginatedList();
          this.updateVisiblePages();
          console.log('Danh sách sản phẩm đã phân trang:', this.paginatedProductLst);
        } else {
          console.error('API trả về lỗi:', res);
          this.toastService.error('Có lỗi xảy ra khi tìm kiếm sản phẩm');
          this.productLst = [];
          this.paginatedProductLst = [];
          this.totalPage = 0;
          this.pages = [];
        }
      },
      error: (err) => {
        console.error('Lỗi khi lấy danh sách sản phẩm:', err);
        this.toastService.error('Không thể kết nối đến máy chủ');
        this.productLst = [];
        this.paginatedProductLst = [];
        this.totalPage = 0;
        this.pages = [];
      }
    });
  }

  changePage(page: number): void {
    if (page < 1 || page > this.totalPage) {
      return; // Prevent invalid page navigation
    }
    this.currentPage = page;
    this.updatePaginatedList();
    this.updateVisiblePages();
  }

  updatePaginatedList(): void {
    if (!this.productLst || this.productLst.length === 0) {
      this.paginatedProductLst = [];
      return;
    }
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.paginatedProductLst = this.productLst.slice(startIndex, endIndex);
    console.log('Cập nhật danh sách phân trang:', this.paginatedProductLst);
  }
  updateVisiblePages(): void {
    const half = Math.floor(this.maxVisiblePages / 2);

    // Đảm bảo trang hiện tại nằm ở giữa nếu có thể
    let startPage = Math.max(this.currentPage - half, 1);
    let endPage = startPage + this.maxVisiblePages - 1;

    // Điều chỉnh nếu endPage vượt quá tổng số trang
    if (endPage > this.totalPage) {
      endPage = this.totalPage;
      startPage = Math.max(endPage - this.maxVisiblePages + 1, 1);
    }

    // Tạo danh sách các trang hiển thị
    this.pages = Array.from(
      { length: endPage - startPage + 1 },
      (_, i) => startPage + i
    );
  }

  showDetail(thuoc: Thuoc) {
    this.router.navigate([`/thuoc-chitiet/${thuoc.id}`]);
  }

  addProductInCart(item: Thuoc): void {
    if (Cookie.check(AuthConstant.ACCESS_TOKEN_KEY)) {
      this.createGH(item);
    } else {
      this.router.navigate([`/login`]);
    }
  }

  createGH(item: Thuoc): void {
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
            this.addToCart(item);
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
      this.addToCart(item);
    } else {
      console.error('Không tìm thấy ID giỏ hàng và ID người dùng');
      this.toastService.error("Không thể thêm vào giỏ hàng. Vui lòng đăng nhập lại.");
    }
  }

  // Hàm thực sự thêm sản phẩm vào giỏ hàng sau khi đã có ID giỏ hàng
  private addToCart(item: Thuoc) {
    console.log('Thông tin sản phẩm thêm vào giỏ hàng:', item);
    console.log('ID giỏ hàng:', this.gioHangId);
    console.log('ID người dùng:', this.userInfo.id);

    let gioHang: GioHangChiTiet = {
      gioHangId: this.gioHangId,
      soLuong: 1,
      thuocId: Number(item.id),
      donGia: item.giaBan,
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
}
