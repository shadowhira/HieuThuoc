// role.service.ts
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HeadersUtil } from "../_util/headers-util";
import { environment } from "src/environments/environment";
import { DangNhapModel } from "../_model/dangnhap";

@Injectable({
  providedIn: "root",
})
export class DangNhapService {
  constructor(private http: HttpClient) {}

  dangNhap(userInfo: DangNhapModel): Observable<any> {
    const apiUrl = environment.backApiUrl + `/dangnhap`;
    const headers: HttpHeaders = HeadersUtil.getHeaders();

    let params = new HttpParams()
      .set("tenDangNhap", userInfo.tenDangNhap?.toString() || "")
      .set("matKhau", userInfo.matKhau?.toString() || "");

    return this.http.post(`${apiUrl}`, userInfo, {
      headers: headers,
      params: params,
    });
  }
}
