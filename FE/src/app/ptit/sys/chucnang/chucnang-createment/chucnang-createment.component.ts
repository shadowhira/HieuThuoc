import { ChucNang } from "../../../../_model/chucnang";
import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
import { CommonConstant } from "src/app/_constant/common.constants";
import { DanhMucThuoc } from "src/app/_model/danhmucthuoc";
import { LoaiThuoc } from "src/app/_model/loaithuoc";

declare var $: any;

@Component({
  selector: "app-chucnang-createment",
  templateUrl: "./chucnang-createment.component.html",
})
export class ChucNangCreatementComponent implements OnInit {
  CommonConstant = CommonConstant;
  constructor(public translate: TranslateService) {}

  @Input()
  chucnang: ChucNang = {};

  @Output()
  save: EventEmitter<any> = new EventEmitter();

  @Output()
  cancel: EventEmitter<any> = new EventEmitter();

  displayModal: boolean = true;

  typeModal = CommonConstant.TYPE_VIEW;

  ngOnInit() {}

  onCancel() {
    this.cancel.emit(false);
  }

  check(chucnang: ChucNang) {
    let check = true;
    // if (loaithuoc.moTa == undefined || loaithuoc.moTa.trim().length == 0) {
    //   check = false;
    //   this.loaithuoc.moTa = "";
    // }
    if (
      chucnang.tenChucNang == undefined ||
      chucnang.tenChucNang.trim().length == 0
    ) {
      check = false;
      this.chucnang.tenChucNang = "";
    }
    return check;
  }

  onSave() {
    if (this.check(this.chucnang)) {
      this.displayModal = false;
      this.save.emit(this.chucnang);
    }
  }

  updateTypeModal() {
    if (this.typeModal == CommonConstant.TYPE_UPDATE) {
      this.typeModal = CommonConstant.TYPE_VIEW;
    } else if (this.typeModal == CommonConstant.TYPE_VIEW) {
      this.typeModal = CommonConstant.TYPE_UPDATE;
    }
  }
}
