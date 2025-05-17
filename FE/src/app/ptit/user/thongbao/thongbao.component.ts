import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { CommonConstant } from "src/app/_constant/common.constants";
import { NguoiDung } from "src/app/_model/auth/nguoidung";
import { ToastrService } from "ngx-toastr";
import { NguoidungService } from "src/app/_service/auth/nguoidung.service";
import { GioHangService } from "src/app/_service/giohang.service";
import { Cookie } from "ng2-cookies";
import { AuthConstant } from "src/app/_constant/auth.constant";
import { jwtDecode } from "jwt-decode";
import { lastValueFrom } from "rxjs";
import { GioHangChiTiet } from "src/app/_model/giohangchitiet";
import { DonhangService } from "src/app/_service/donhang.service";
import { DonHang } from "src/app/_model/hoadon";
import { ThongBaoService } from "src/app/_service/thongbao.service";
import { ThongBao } from "src/app/_model/thongbao";
import { SearchModel } from "src/app/_model/common/Search";
import { Quyen } from "src/app/_model/auth/quyen";

@Component({
  selector: "app-thongbao",
  templateUrl: "./thongbao.component.html",
})
export class ThongBaoComponent implements OnInit {
  constructor(
    private nguoidungService: NguoidungService,
    private gioHangService: GioHangService,
    private donHangService: DonhangService,
    private thongbaoService: ThongBaoService,
    private router: Router,
    private toastService: ToastrService
  ) {}

  user = JSON.parse(localStorage.getItem("userInfo") || "{}");
  userUpdate: NguoiDung = {};

  userInfo: NguoiDung = {};
  thongbaoId: number = 0;
  thongbaoLst: ThongBao[] = [];

  imageUrl: string | ArrayBuffer | null = null; // Biến để lưu đường dẫn hình ảnh đã chọn
  tongTien: number = 0;

  lstNoti: ThongBao[] = [];
  countTotal: number = 0;

  modelSearch: SearchModel = {
    keyWord: "",
    id: 0,
    currentPage: 0,
    size: 100,
    sortedField: "",
    loaiThuoc: "",
  };

  roleUser: Quyen[] = [];
  isAdmin: boolean | null = false;

  logout() {
    this.nguoidungService.logOut(true);
  }

  ngOnInit() {
    this.modelSearch.id = this.user.id;
    this.thongbaoService.getLst(this.modelSearch).subscribe((res) => {
      if (res.status == CommonConstant.STATUS_OK_200) {
        this.lstNoti = res.data.data;
        this.countTotal = res.data.totalElements;
      }
    });

    this.getUserInfo();
  }

  async getUserInfo(): Promise<void> {
    const _token = Cookie.get(AuthConstant.ACCESS_TOKEN_KEY);

    const userInfo = jwtDecode(_token) as NguoiDung;
    if (userInfo.id) {
      const resp = await lastValueFrom(this.nguoidungService.get(userInfo.id));
      if (resp.status == CommonConstant.STATUS_OK_200) {
        this.userUpdate = resp.data;

        this.userInfo = resp.data;
      }
    }
  }

  hasRole(roleId: string): boolean {
    return this.roleUser
      ? this.roleUser.some((role) => role.id == roleId)
      : false;
  }

  navigateToLink(link: string | undefined, event: Event) {
    event.preventDefault();
    if (!link) {
      console.error('Link không hợp lệ:', link);
      return;
    }

    // Kiểm tra xem link có phải là URL đầy đủ không
    if (link.startsWith('http://') || link.startsWith('https://')) {
      // Nếu là URL đầy đủ, mở trong cửa sổ mới
      window.open(link, '_blank');
    } else {
      // Nếu là đường dẫn tương đối, ánh xạ sang route hợp lệ
      try {
        // Loại bỏ dấu / ở đầu nếu có
        const routePath = link.startsWith('/') ? link.substring(1) : link;
        console.log('Đường dẫn gốc:', routePath);

        // Ánh xạ đường dẫn sang route hợp lệ
        let mappedRoute = this.mapLinkToValidRoute(routePath);
        console.log('Điều hướng đến:', mappedRoute);

        this.router.navigateByUrl(mappedRoute);
      } catch (error) {
        console.error('Lỗi khi điều hướng:', error);
        this.toastService.error('Không thể điều hướng đến trang yêu cầu');
      }
    }
  }

  // Ánh xạ đường dẫn từ thông báo sang route hợp lệ
  private mapLinkToValidRoute(link: string): string {
    // Bảng ánh xạ các đường dẫn
    const routeMap: { [key: string]: string } = {
      'dashboard': 'user/home',
      'notifications': 'user/thongbao',
      'orders': 'user/donmua',
      'promotions': 'user/home',
      'inventory': 'sys/tonkho',
      'profile': 'user/profile',
      'medicines': 'sys/product'
    };

    // Kiểm tra xem đường dẫn có trong bảng ánh xạ không
    if (routeMap[link]) {
      return routeMap[link];
    }

    // Nếu không tìm thấy trong bảng ánh xạ, kiểm tra một số trường hợp đặc biệt
    if (link.includes('thuoc-chitiet')) {
      return link; // Giữ nguyên đường dẫn chi tiết thuốc
    }

    // Mặc định trả về trang chủ
    return 'user/home';
  }
}
