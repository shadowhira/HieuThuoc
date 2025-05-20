import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { BaoCaoService } from './baocaoservice';
import { environment } from '../../environments/environment';
import { HeadersUtil } from '../_util/headers-util';
import { HttpHeaders } from '@angular/common/http';

describe('BaoCaoService', () => {
  let service: BaoCaoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BaoCaoService]
    });
    service = TestBed.inject(BaoCaoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('getDoanhThuTheoNgay', () => {
    it('should call the API with correct URL and parameters', () => {
      // Arrange
      const ngay = '2024-01-15';
      const mockResponse = {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 8, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 14, tongDoanhThu: 30000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 16, tongDoanhThu: 12000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 19, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 21, tongDoanhThu: 16000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 23, tongDoanhThu: 24000.0, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      };

      // Act
      service.getDoanhThuTheoNgay(ngay).subscribe(response => {
        // Assert
        expect(response).toEqual(mockResponse);
      });

      // Assert
      const req = httpMock.expectOne(request => {
        return request.url === `${environment.backApiUrl}/baocao/doanhthutheongay` &&
               request.params.get('ngay') === ngay;
      });
      expect(req.request.method).toBe('GET');
      req.flush(mockResponse);
    });
  });

  describe('getDoanhThuTheoThang', () => {
    it('should call the API with correct URL and parameters', () => {
      // Arrange
      const request = {
        nam: 2024,
        thang: 1
      };
      const mockResponse = {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 5, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 10, tongDoanhThu: 15000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 12, tongDoanhThu: 30000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 15, tongDoanhThu: 12000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 20, tongDoanhThu: 25000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 25, tongDoanhThu: 16000.0, tongDonHang: 1, tongDonHangTraLai: 0 },
          { thoiGian: 30, tongDoanhThu: 24000.0, tongDonHang: 1, tongDonHangTraLai: 0 }
        ]
      };

      // Act
      service.getDoanhThuTheoThang(request).subscribe(response => {
        // Assert
        expect(response).toEqual(mockResponse);
      });

      // Assert
      const req = httpMock.expectOne(req => {
        return req.url === `${environment.backApiUrl}/baocao/doanhthutheothang` &&
               req.params.get('nam') === request.nam.toString() &&
               req.params.get('thang') === request.thang.toString();
      });
      expect(req.request.method).toBe('GET');
      req.flush(mockResponse);
    });
  });

  describe('getDoanhThuTheoNam', () => {
    it('should call the API with correct URL and parameters', () => {
      // Arrange
      const request = {
        nam: 2024
      };
      const mockResponse = {
        status: 200,
        msg: 'Thành công.',
        data: [
          { thoiGian: 1, tongDoanhThu: 147000.0, tongDonHang: 7, tongDonHangTraLai: 0 },
          { thoiGian: 2, tongDoanhThu: 95000.0, tongDonHang: 5, tongDonHangTraLai: 1 },
          { thoiGian: 3, tongDoanhThu: 210000.0, tongDonHang: 10, tongDonHangTraLai: 0 },
          { thoiGian: 4, tongDoanhThu: 180000.0, tongDonHang: 8, tongDonHangTraLai: 2 },
          { thoiGian: 5, tongDoanhThu: 250000.0, tongDonHang: 12, tongDonHangTraLai: 1 },
          { thoiGian: 6, tongDoanhThu: 160000.0, tongDonHang: 7, tongDonHangTraLai: 0 }
        ]
      };

      // Act
      service.getDoanhThuTheoNam(request).subscribe(response => {
        // Assert
        expect(response).toEqual(mockResponse);
      });

      // Assert
      const req = httpMock.expectOne(req => {
        return req.url === `${environment.backApiUrl}/baocao/doanhthutheonam` &&
               req.params.get('nam') === request.nam.toString();
      });
      expect(req.request.method).toBe('GET');
      req.flush(mockResponse);
    });
  });
});
