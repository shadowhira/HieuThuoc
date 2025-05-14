import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { SysComponent } from "./sys.component";
import { RoleGuard } from "src/app/_guard/role.guard";
import { AuthConstant } from "src/app/_constant/auth.constant";
import { ThuocComponent } from "./product/thuoc.component";
import { ThuocCreatementComponent } from "./product/thuoc-createment/thuoc-createment.component";
import { NCCComponent } from "./ncc/ncc.component";
import { CustomerComponent } from "./customer/customer.component";
import { DonHangComponent } from "./donhang/donhang.component";
import { LoaiThuocComponent } from "./loaithuoc/loaithuoc.component";
import { NSXComponent } from "./nsx/nsx.component";
import { DanhmucThuocComponent } from "./danhmucthuoc/danhmucthuoc.component";
import { DoituongComponent } from "./doituong/doituong.component";
import { ChucNangComponent } from "./chucnang/chucnang.component";
import { PhieuNhapComponent } from "./phieunhap/phieunhap.component";
import { PhieuNhapCreatementComponent } from "./phieunhap/phieunhap-createment/phieunhap-createment.component";
import { ChiTietDonHangComponent } from "./donhang/chitiet-donhang/chitiet-donhang.component";
import { ThongKecComponent } from "./thongke/thongke.component";
import { DonHangCreateComponent } from "./donhang-create/donhang-create.component";
import { ThongBaoComponent } from "./thongbao/thongbao.component";
import { TonKhoComponent } from "./tonkho/tonkho.component";

const routes: Routes = [
  // { path: "", redirectTo: "menu-manage", pathMatch: "full" },
  // { path: "menu-manage", component: MenuManageComponent },
  {
    path: "",
    component: SysComponent,
    children: [
      { path: "", redirectTo: "thongke", pathMatch: "full" },
      {
        path: "product",
        component: ThuocComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "customer",
        component: CustomerComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "product-create",
        component: ThuocCreatementComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "product-create/:id",
        component: ThuocCreatementComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "ncc",
        component: NCCComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "nsx",
        component: NSXComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "donhang",
        component: DonHangComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "donhang-create",
        component: DonHangCreateComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "loaithuoc",
        component: LoaiThuocComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "danhmucThuoc",
        component: DanhmucThuocComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "doituong",
        component: DoituongComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "chucnang",
        component: ChucNangComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "phieunhap",
        component: PhieuNhapComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "phieunhap-create",
        component: PhieuNhapCreatementComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "phieunhap-create/:id",
        component: PhieuNhapCreatementComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "chitiet-donhang/:id",
        component: ChiTietDonHangComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "thongke",
        component: ThongKecComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "thongbao",
        component: ThongBaoComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
      {
        path: "tonkho",
        component: TonKhoComponent,
        canActivate: [RoleGuard],
        data: {
          guards: [AuthConstant.ROLE_ADMIN, AuthConstant.ROLE_MANAGER],
        },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SysRoutingModule {}
