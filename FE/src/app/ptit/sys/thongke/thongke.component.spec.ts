import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { ConfirmationService, MessageService } from 'primeng/api';
import { of } from 'rxjs';

import { ThongKecComponent } from './thongke.component';
import { BaoCaoService } from 'src/app/_service/baocaoservice';
import { CommonConstant } from 'src/app/_constant/common.constants';

describe('ThongKecComponent', () => {
  let component: ThongKecComponent;
  let fixture: ComponentFixture<ThongKecComponent>;
  let baoCaoService: jasmine.SpyObj<BaoCaoService>;

  beforeEach(async () => {
    const baoCaoServiceSpy = jasmine.createSpyObj('BaoCaoService', [
      'getDoanhThuTheoNgay',
      'getDoanhThuTheoThang',
      'getDoanhThuTheoNam'
    ]);

    await TestBed.configureTestingModule({
      declarations: [ThongKecComponent],
      imports: [
        HttpClientTestingModule,
        FormsModule,
        RouterTestingModule,
        ToastrModule.forRoot()
      ],
      providers: [
        { provide: BaoCaoService, useValue: baoCaoServiceSpy },
        ToastrService,
        ConfirmationService,
        MessageService
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(ThongKecComponent);
    component = fixture.componentInstance;
    baoCaoService = TestBed.inject(BaoCaoService) as jasmine.SpyObj<BaoCaoService>;
  });

  it('should create', () => {
    // Arrange
    setupMockResponses();
    
    // Act
    fixture.detectChanges();
    
    // Assert
    expect(component).toBeTruthy();
  });

  it('should initialize with current date', () => {
    // Arrange
    setupMockResponses();
    
    // Act
    fixture.detectChanges();
    
    // Assert
    const today = new Date();
    expect(component.ngaySelected).toBe(today.getDate());
    expect(component.thangSelected).toBe(today.getMonth() + 1);
    expect(component.namSelected).toBe(today.getFullYear());
  });

  it('should call getDoanhThuNgay when initialized', () => {
    // Arrange
    setupMockResponses();
    spyOn(component, 'getDoanhThuNgay');
    
    // Act
    fixture.detectChanges();
    
    // Assert
    expect(component.getDoanhThuNgay).toHaveBeenCalled();
  });

  it('should update chart when getDoanhThuNgay is called', () => {
    // Arrange
    setupMockResponses();
    fixture.detectChanges();
    spyOn(component, 'getDoThiNgay').and.callThrough();
    
    // Act
    component.getDoanhThuNgay(15, 1, 2024);
    
    // Assert
    expect(component.getDoThiNgay).toHaveBeenCalledWith(15, 1, 2024);
    expect(baoCaoService.getDoanhThuTheoNgay).toHaveBeenCalledWith('2024-01-15');
  });

  it('should update chart when getDoanhThuThang is called', () => {
    // Arrange
    setupMockResponses();
    fixture.detectChanges();
    spyOn(component, 'getDoThiThang').and.callThrough();
    
    // Act
    component.getDoanhThuThang(1, 2024);
    
    // Assert
    expect(component.getDoThiThang).toHaveBeenCalledWith(1, 2024);
    expect(baoCaoService.getDoanhThuTheoThang).toHaveBeenCalledWith({
      nam: 2024,
      thang: 1
    });
  });

  it('should update chart when getDoanhThuNam is called', () => {
    // Arrange
    setupMockResponses();
    fixture.detectChanges();
    spyOn(component, 'getDoThiNam').and.callThrough();
    
    // Act
    component.getDoanhThuNam(2024);
    
    // Assert
    expect(component.getDoThiNam).toHaveBeenCalledWith(2024);
    expect(baoCaoService.getDoanhThuTheoNam).toHaveBeenCalledWith({
      nam: 2024
    });
  });

  it('should change type when changeType is called', () => {
    // Arrange
    setupMockResponses();
    fixture.detectChanges();
    
    // Act
    component.changeType(CommonConstant.THANG);
    
    // Assert
    expect(component.typeDoanhThu).toBe(CommonConstant.THANG);
  });

  it('should update days in month when updateDaysInMonth is called', () => {
    // Arrange
    setupMockResponses();
    fixture.detectChanges();
    
    // Act
    component.thangSelected = 2;
    component.namSelected = 2024; // Leap year
    component.updateDaysInMonth();
    
    // Assert
    expect(component.daysInMonth.length).toBe(29); // February 2024 has 29 days
  });

  // Helper function to setup mock responses
  function setupMockResponses() {
    // Mock response for getDoanhThuTheoNgay
    baoCaoService.getDoanhThuTheoNgay.and.returnValue(of({
      status: CommonConstant.STATUS_OK_200,
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
    }));

    // Mock response for getDoanhThuTheoThang
    baoCaoService.getDoanhThuTheoThang.and.returnValue(of({
      status: CommonConstant.STATUS_OK_200,
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
    }));

    // Mock response for getDoanhThuTheoNam
    baoCaoService.getDoanhThuTheoNam.and.returnValue(of({
      status: CommonConstant.STATUS_OK_200,
      msg: 'Thành công.',
      data: [
        { thoiGian: 1, tongDoanhThu: 147000.0, tongDonHang: 7, tongDonHangTraLai: 0 },
        { thoiGian: 2, tongDoanhThu: 95000.0, tongDonHang: 5, tongDonHangTraLai: 1 },
        { thoiGian: 3, tongDoanhThu: 210000.0, tongDonHang: 10, tongDonHangTraLai: 0 },
        { thoiGian: 4, tongDoanhThu: 180000.0, tongDonHang: 8, tongDonHangTraLai: 2 },
        { thoiGian: 5, tongDoanhThu: 250000.0, tongDonHang: 12, tongDonHangTraLai: 1 },
        { thoiGian: 6, tongDoanhThu: 160000.0, tongDonHang: 7, tongDonHangTraLai: 0 }
      ]
    }));
  }
});
