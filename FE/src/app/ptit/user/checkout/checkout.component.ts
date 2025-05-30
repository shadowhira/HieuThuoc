import { PhuongThucThanhToan } from "../../../_constant/phuongthucthanhtoan.constant";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { CommonConstant } from "src/app/_constant/common.constants";
import { NguoiDung } from "src/app/_model/auth/nguoidung";
import { ToastrService } from "ngx-toastr";
import { NguoidungService } from "src/app/_service/auth/nguoidung.service";
import { GioHangService } from "src/app/_service/giohang.service";
import { GioHangChiTiet } from "src/app/_model/giohangchitiet";
import { Cookie } from "ng2-cookies";
import { AuthConstant } from "src/app/_constant/auth.constant";
import { jwtDecode } from "jwt-decode";
import { lastValueFrom } from "rxjs";
import { DonHang } from "src/app/_model/hoadon";
import { ChiTietDonHang } from "src/app/_model/chitietdonhang";
import { TrangThaiThanhToan } from "src/app/_constant/trangthaithanhtoan.constant";
import { TrangThaiGiaoHang } from "src/app/_constant/trangthaigioahang.constant";
import { DonhangService } from "src/app/_service/donhang.service";
import { ThongBaoService } from "src/app/_service/thongbao.service";
import { ThongBao } from "src/app/_model/thongbao";
import { LOAITHONGBAO } from "src/app/_constant/loaithongbao.constant";
import { VnPayService } from "src/app/_service/vnpay.service";

@Component({
  selector: "app-checkout",
  templateUrl: "./checkout.component.html",
})
export class CheckoutComponent implements OnInit {
  constructor(
    private nguoidungService: NguoidungService,
    private router: Router,
    private toastService: ToastrService,
    private donhangService: DonhangService,
    private gioHangService: GioHangService,
    private vnPayService: VnPayService,
    private thongBaoService: ThongBaoService
  ) {}
  PhuongThucThanhToan = PhuongThucThanhToan;

  userInfo: NguoiDung = {};
  gioHangId: number = 0;
  gioHangLst: GioHangChiTiet[] = [];

  disabled: boolean = false;

  tongTien: number = 0;
  donhang: DonHang = {};

  ngOnInit() {
    this.getUserInfo();

    this.donhang.phuongThucThanhToan = PhuongThucThanhToan.TIEN_MAT;
  }

  async getUserInfo(): Promise<void> {
    const _token = Cookie.get(AuthConstant.ACCESS_TOKEN_KEY);

    const userInfo = jwtDecode(_token) as NguoiDung;
    if (userInfo.id) {
      const resp = await lastValueFrom(this.nguoidungService.get(userInfo.id));
      if (resp.status == CommonConstant.STATUS_OK_200) {
        this.userInfo = resp.data;
        this.donhang.khachHang = resp.data;
        this.donhang.khachHangId = this.userInfo.id;
        this.donhang.tenKhachHang = this.userInfo.hoTen;
        this.donhang.diaChi = this.userInfo.diaChi;
        this.donhang.soDienThoai = this.userInfo.soDienThoai;
        this.donhang.email = this.userInfo.email;

        if (this.userInfo.id) {
          this.getGH();
        }
      }
    }
  }
  getGH() {
    this.gioHangService.getGH(this.userInfo.id).subscribe((res) => {
      if (res.status == CommonConstant.STATUS_OK_200) {
        if (res.data.chiTietGioHangs.length > 0) {
          this.gioHangId = res.data.id;
          this.gioHangLst = res.data.chiTietGioHangs;

          this.gioHangLst.forEach((item: GioHangChiTiet) => {
            this.tongTien += (item.soLuong || 0) * (item.thuoc?.giaBan || 0);
          });
        }
      }
    });
  }

  submit() {
    this.donhang.trangThaiThanhToan = TrangThaiThanhToan.CHUA_THANH_TOAN;
    this.donhang.trangThaiGiaoHang = TrangThaiGiaoHang.DANG_XU_LY;

    this.donhang.chiTietDonHangs = [];
    this.gioHangLst.forEach((item: GioHangChiTiet) => {
      // console.log("item", item);
      let itemNew: ChiTietDonHang = {
        donGia: item.donGia,
        soLuong: item.soLuong,
        thuocId: item.thuoc?.id,
      };
      this.donhang.chiTietDonHangs?.push(itemNew);
    });

    if (this.donhang.phuongThucThanhToan == PhuongThucThanhToan.CHUYEN_KHOAN) {
      this.disabled = true;
      this.vnPayService.create(this.tongTien).subscribe((resp) => {
        if (resp.status == CommonConstant.STATUS_OK_200) {
          const url = resp.data;
          localStorage.setItem("pendingOrder", JSON.stringify(this.donhang));

          window.location.href = url;
          // const paymentStatus = params["paymentStatus"];
          // if (url) {
          //   this.donhangService.create(this.donhang).subscribe((resp) => {
          //     if (resp.status == CommonConstant.STATUS_OK_200) {
          //       this.toastService.success("Lưu thành công");
          //       //if success, delete cart
          //       this.gioHangLst.forEach((item: GioHangChiTiet) => {
          //         this.gioHangService.deleteGH(item.id).subscribe((resp) => {
          //           if (resp.status == CommonConstant.STATUS_OK_200) {
          //             // this.toastService.success("Xóa thành công");
          //             this.getGH();
          //             this.router.navigate(["/user/donmua"]);
          //           } else {
          //             this.toastService.error("Xóa thất bại");
          //           }
          //         });
          //       });
          //     } else {
          //       this.toastService.error("Lưu thất bại");
          //     }
          //   });
          // }
        } else if (resp.status == CommonConstant.STATUS_OK_409) {
          this.toastService.error(resp.msg);
        } else {
          this.toastService.error("Lưu thất bại");
        }
      });
    } else {
      this.disabled = true;

      this.donhangService.create(this.donhang).subscribe((resp) => {
        if (resp.status == CommonConstant.STATUS_OK_200) {
          this.toastService.success("Lưu thành công");
          this.disabled = false;
          this.gioHangLst.forEach((item: GioHangChiTiet) => {
            this.gioHangService.deleteGH(item.id).subscribe((resp) => {
              if (resp.status == CommonConstant.STATUS_OK_200) {
                // this.toastService.success("Xóa thành công");
                this.getGH();
                this.router.navigate(["/user/donmua"]);
              } else {
                this.toastService.error("Xóa thất bại");
              }
            });
          });
        } else {
          this.toastService.error("Lưu thất bại");
          this.disabled = false;
        }
      });
    }
  }

  addThongBao() {
    let thongBao: ThongBao = {
      loaiThongBao: LOAITHONGBAO.CA_NHAN,
      ngayTao: new Date(),
      noiDung: "Bạn vừa tạo thành công 1 đơn hàng.",
      tieuDe: "Mua hàng",
      trangThai: false,
      nguoiDungId: this.userInfo.id ? this.userInfo.id : "",
      createAt: new Date(),
      hinhAnh: this.gioHangLst[0].thuoc?.hinhAnh,
    };

    this.thongBaoService.create(thongBao).subscribe((resp) => {
      if (resp.status == CommonConstant.STATUS_OK_200) {
        this.toastService.success("Lưu thành công");
        this.router.navigate(["/sys/product"]);
      } else if (resp.status == CommonConstant.STATUS_OK_409) {
        this.toastService.error(resp.msg);
      } else {
        this.toastService.error("Lưu thất bại");
      }
    });
  }

  deleteCart() {
    this.gioHangLst.forEach((item) => {
      this.gioHangService.deleteGH(item.id).subscribe((resp) => {
        if (resp.status == CommonConstant.STATUS_OK_200) {
          // this.toastService.success("Xóa thành công");
          this.getGH();
        } else {
          // this.toastService.error("Xóa thất bại");
        }
      });
    });
  }
  changePTTT(value: string) {
    if (value == "1")
      this.donhang.phuongThucThanhToan = PhuongThucThanhToan.TIEN_MAT;
    else if (value == "2")
      this.donhang.phuongThucThanhToan = PhuongThucThanhToan.CHUYEN_KHOAN;
    else if (value == "3")
      this.donhang.phuongThucThanhToan = PhuongThucThanhToan.THE_NGAN_HANG;
    else if (value == "4")
      this.donhang.phuongThucThanhToan = PhuongThucThanhToan.VI_DIEN_TU;
  }
}
