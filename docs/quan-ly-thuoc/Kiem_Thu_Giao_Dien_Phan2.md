# HƯỚNG DẪN TRIỂN KHAI KIỂM THỬ GIAO DIỆN (UI TESTING) - PHẦN 2
## CHỨC NĂNG QUẢN LÝ THUỐC

## 5. KIỂM THỬ GIAO DIỆN CHI TIẾT THUỐC

### 5.1 Tạo test case cho giao diện chi tiết thuốc

Tạo file `cypress/e2e/quan-ly-thuoc/chi-tiet-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện chi tiết thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
    
    // Giả lập API lấy danh sách thuốc
    cy.intercept('POST', '**/thuoc/search', { fixture: 'thuoc.json' }).as('searchThuoc');
    cy.wait('@searchThuoc');
    
    // Giả lập API lấy chi tiết thuốc
    cy.intercept('GET', '**/thuoc/get?id=1', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          id: 1,
          tenThuoc: "Paracetamol 500mg",
          maThuoc: "PARA500",
          loaiThuoc: {
            id: 1,
            tenLoai: "Giảm đau không steroid"
          },
          nhaSanXuat: {
            id: 1,
            tenNhaSanXuat: "Công ty Dược phẩm ABC"
          },
          donVi: "Viên",
          giaNhap: 5000,
          giaBan: 7000,
          soLuongTon: 100,
          nguongCanhBao: 20,
          congDung: "Giảm đau, hạ sốt",
          chiDinh: "Đau đầu, sốt, đau nhẹ",
          chongChiDinh: "Mẫn cảm với paracetamol",
          huongDanSuDung: "Uống 1-2 viên mỗi 4-6 giờ khi cần",
          moTaNgan: "Thuốc giảm đau, hạ sốt thông dụng",
          avatar: "https://example.com/paracetamol.jpg",
          trangThai: true,
          thanhPhanThuocs: [
            {
              id: 1,
              tenThanhPhan: "Paracetamol",
              hamLuong: "500",
              donVi: "mg"
            }
          ]
        }
      }
    }).as('getThuocDetail');
  });
  
  it('Hiển thị đúng giao diện chi tiết thuốc', () => {
    // Nhấn nút xem chi tiết thuốc đầu tiên
    cy.get('table tbody tr').eq(0).find('button[title="Xem chi tiết"]').click();
    cy.wait('@getThuocDetail');
    
    // Kiểm tra tiêu đề dialog
    cy.get('.p-dialog-title').should('contain', 'Chi tiết thuốc');
    
    // Kiểm tra thông tin cơ bản
    cy.get('.thuoc-detail').within(() => {
      cy.contains('Tên thuốc:').next().should('contain', 'Paracetamol 500mg');
      cy.contains('Mã thuốc:').next().should('contain', 'PARA500');
      cy.contains('Loại thuốc:').next().should('contain', 'Giảm đau không steroid');
      cy.contains('Nhà sản xuất:').next().should('contain', 'Công ty Dược phẩm ABC');
      cy.contains('Đơn vị:').next().should('contain', 'Viên');
      cy.contains('Giá nhập:').next().should('contain', '5,000');
      cy.contains('Giá bán:').next().should('contain', '7,000');
      cy.contains('Số lượng tồn:').next().should('contain', '100');
      cy.contains('Ngưỡng cảnh báo:').next().should('contain', '20');
    });
    
    // Kiểm tra thông tin chi tiết
    cy.get('.thuoc-detail-tabs').within(() => {
      // Tab Công dụng
      cy.contains('Công dụng').click();
      cy.get('.tab-content').should('contain', 'Giảm đau, hạ sốt');
      
      // Tab Chỉ định
      cy.contains('Chỉ định').click();
      cy.get('.tab-content').should('contain', 'Đau đầu, sốt, đau nhẹ');
      
      // Tab Chống chỉ định
      cy.contains('Chống chỉ định').click();
      cy.get('.tab-content').should('contain', 'Mẫn cảm với paracetamol');
      
      // Tab Hướng dẫn sử dụng
      cy.contains('Hướng dẫn sử dụng').click();
      cy.get('.tab-content').should('contain', 'Uống 1-2 viên mỗi 4-6 giờ khi cần');
      
      // Tab Thành phần
      cy.contains('Thành phần').click();
      cy.get('.tab-content').should('contain', 'Paracetamol');
      cy.get('.tab-content').should('contain', '500 mg');
    });
    
    // Kiểm tra hình ảnh
    cy.get('.thuoc-image img').should('have.attr', 'src', 'https://example.com/paracetamol.jpg');
    
    // Kiểm tra nút đóng
    cy.get('button').contains('Đóng').should('be.visible');
  });
  
  it('Đóng dialog chi tiết thuốc', () => {
    // Nhấn nút xem chi tiết thuốc đầu tiên
    cy.get('table tbody tr').eq(0).find('button[title="Xem chi tiết"]').click();
    cy.wait('@getThuocDetail');
    
    // Nhấn nút đóng
    cy.get('button').contains('Đóng').click();
    
    // Kiểm tra dialog đã đóng
    cy.get('.p-dialog').should('not.exist');
  });
  
  it('Hiển thị thông báo khi không tìm thấy thuốc', () => {
    // Giả lập API trả về lỗi không tìm thấy thuốc
    cy.intercept('GET', '**/thuoc/get?id=999', {
      status: 200,
      body: {
        status: 404,
        msg: "Không tìm thấy thuốc",
        data: null
      }
    }).as('getThuocNotFound');
    
    // Truy cập trực tiếp URL chi tiết thuốc không tồn tại
    cy.visit('/admin/thuoc/detail/999');
    cy.wait('@getThuocNotFound');
    
    // Kiểm tra thông báo lỗi
    cy.get('.p-toast-message').should('be.visible');
    cy.get('.p-toast-message').should('contain', 'Không tìm thấy thuốc');
    
    // Kiểm tra chuyển hướng về trang danh sách
    cy.url().should('include', '/admin/thuoc');
  });
});
```

### 5.2 Chạy kiểm thử giao diện chi tiết thuốc

```bash
# Chạy test case cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/chi-tiet-thuoc.cy.js"

# Hoặc mở Cypress Test Runner để chạy và xem kết quả trực quan
npx cypress open
```

## 6. KIỂM THỬ GIAO DIỆN TÌM KIẾM THUỐC

### 6.1 Tạo test case cho giao diện tìm kiếm thuốc

Tạo file `cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc.cy.js`:

```javascript
describe('Kiểm thử giao diện tìm kiếm thuốc', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
    
    // Giả lập API lấy danh sách thuốc
    cy.intercept('POST', '**/thuoc/search', { fixture: 'thuoc.json' }).as('searchThuoc');
    cy.wait('@searchThuoc');
    
    // Giả lập API lấy danh sách loại thuốc
    cy.intercept('GET', '**/loaithuoc/list', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: [
          { id: 1, tenLoai: "Giảm đau không steroid" },
          { id: 2, tenLoai: "Kháng sinh" },
          { id: 3, tenLoai: "Vitamin và khoáng chất" }
        ]
      }
    }).as('getLoaiThuoc');
    
    // Giả lập API lấy danh sách nhà sản xuất
    cy.intercept('GET', '**/nhasanxuat/list', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: [
          { id: 1, tenNhaSanXuat: "Công ty Dược phẩm ABC" },
          { id: 2, tenNhaSanXuat: "Công ty Dược phẩm XYZ" }
        ]
      }
    }).as('getNhaSanXuat');
  });
  
  it('Tìm kiếm thuốc theo tên', () => {
    // Giả lập API tìm kiếm theo tên
    cy.intercept('POST', '**/thuoc/search', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          data: [
            {
              id: 1,
              tenThuoc: "Paracetamol 500mg",
              maThuoc: "PARA500",
              loaiThuoc: {
                id: 1,
                tenLoai: "Giảm đau không steroid"
              },
              nhaSanXuat: {
                id: 1,
                tenNhaSanXuat: "Công ty Dược phẩm ABC"
              },
              donVi: "Viên",
              giaBan: 7000,
              soLuongTon: 100
            }
          ],
          totalElements: 1,
          totalPages: 1,
          currentPage: 0
        }
      }
    }).as('searchByName');
    
    // Nhập từ khóa tìm kiếm
    cy.get('input[placeholder*="Tìm kiếm"]').clear().type('Paracetamol');
    
    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();
    cy.wait('@searchByName');
    
    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length', 1);
    cy.get('table tbody tr').eq(0).should('contain', 'Paracetamol 500mg');
  });
  
  it('Tìm kiếm thuốc theo loại thuốc', () => {
    // Giả lập API tìm kiếm theo loại thuốc
    cy.intercept('POST', '**/thuoc/search', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          data: [
            {
              id: 2,
              tenThuoc: "Amoxicillin 500mg",
              maThuoc: "AMOX500",
              loaiThuoc: {
                id: 2,
                tenLoai: "Kháng sinh"
              },
              nhaSanXuat: {
                id: 2,
                tenNhaSanXuat: "Công ty Dược phẩm XYZ"
              },
              donVi: "Viên",
              giaBan: 12000,
              soLuongTon: 50
            }
          ],
          totalElements: 1,
          totalPages: 1,
          currentPage: 0
        }
      }
    }).as('searchByCategory');
    
    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Kháng sinh');
    
    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();
    cy.wait('@searchByCategory');
    
    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length', 1);
    cy.get('table tbody tr').eq(0).should('contain', 'Amoxicillin 500mg');
    cy.get('table tbody tr').eq(0).should('contain', 'Kháng sinh');
  });
  
  it('Tìm kiếm thuốc theo nhà sản xuất', () => {
    // Giả lập API tìm kiếm theo nhà sản xuất
    cy.intercept('POST', '**/thuoc/search', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          data: [
            {
              id: 1,
              tenThuoc: "Paracetamol 500mg",
              maThuoc: "PARA500",
              loaiThuoc: {
                id: 1,
                tenLoai: "Giảm đau không steroid"
              },
              nhaSanXuat: {
                id: 1,
                tenNhaSanXuat: "Công ty Dược phẩm ABC"
              },
              donVi: "Viên",
              giaBan: 7000,
              soLuongTon: 100
            }
          ],
          totalElements: 1,
          totalPages: 1,
          currentPage: 0
        }
      }
    }).as('searchByManufacturer');
    
    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').select('Công ty Dược phẩm ABC');
    
    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();
    cy.wait('@searchByManufacturer');
    
    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length', 1);
    cy.get('table tbody tr').eq(0).should('contain', 'Paracetamol 500mg');
    cy.get('table tbody tr').eq(0).should('contain', 'Công ty Dược phẩm ABC');
  });
  
  it('Tìm kiếm thuốc với nhiều tiêu chí', () => {
    // Giả lập API tìm kiếm với nhiều tiêu chí
    cy.intercept('POST', '**/thuoc/search', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          data: [
            {
              id: 1,
              tenThuoc: "Paracetamol 500mg",
              maThuoc: "PARA500",
              loaiThuoc: {
                id: 1,
                tenLoai: "Giảm đau không steroid"
              },
              nhaSanXuat: {
                id: 1,
                tenNhaSanXuat: "Công ty Dược phẩm ABC"
              },
              donVi: "Viên",
              giaBan: 7000,
              soLuongTon: 100
            }
          ],
          totalElements: 1,
          totalPages: 1,
          currentPage: 0
        }
      }
    }).as('searchMultiCriteria');
    
    // Nhập từ khóa tìm kiếm
    cy.get('input[placeholder*="Tìm kiếm"]').clear().type('Paracetamol');
    
    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Giảm đau không steroid');
    
    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').select('Công ty Dược phẩm ABC');
    
    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();
    cy.wait('@searchMultiCriteria');
    
    // Kiểm tra kết quả tìm kiếm
    cy.get('table tbody tr').should('have.length', 1);
    cy.get('table tbody tr').eq(0).should('contain', 'Paracetamol 500mg');
    cy.get('table tbody tr').eq(0).should('contain', 'Giảm đau không steroid');
    cy.get('table tbody tr').eq(0).should('contain', 'Công ty Dược phẩm ABC');
  });
  
  it('Tìm kiếm thuốc không tìm thấy kết quả', () => {
    // Giả lập API tìm kiếm không có kết quả
    cy.intercept('POST', '**/thuoc/search', {
      status: 200,
      body: {
        status: 200,
        msg: "Thành công",
        data: {
          data: [],
          totalElements: 0,
          totalPages: 0,
          currentPage: 0
        }
      }
    }).as('searchNoResult');
    
    // Nhập từ khóa tìm kiếm không tồn tại
    cy.get('input[placeholder*="Tìm kiếm"]').clear().type('XYZ123');
    
    // Nhấn nút tìm kiếm
    cy.get('button').contains('Tìm kiếm').click();
    cy.wait('@searchNoResult');
    
    // Kiểm tra thông báo không tìm thấy kết quả
    cy.get('table tbody').should('contain', 'Không có dữ liệu');
  });
  
  it('Reset bộ lọc tìm kiếm', () => {
    // Nhập từ khóa tìm kiếm
    cy.get('input[placeholder*="Tìm kiếm"]').clear().type('Paracetamol');
    
    // Chọn loại thuốc
    cy.get('select[name="loaiThuoc"]').select('Giảm đau không steroid');
    
    // Chọn nhà sản xuất
    cy.get('select[name="nhaSanXuat"]').select('Công ty Dược phẩm ABC');
    
    // Nhấn nút reset
    cy.get('button').contains('Reset').click();
    
    // Kiểm tra các trường đã được reset
    cy.get('input[placeholder*="Tìm kiếm"]').should('have.value', '');
    cy.get('select[name="loaiThuoc"]').should('have.value', '');
    cy.get('select[name="nhaSanXuat"]').should('have.value', '');
  });
});
```

### 6.2 Chạy kiểm thử giao diện tìm kiếm thuốc

```bash
# Chạy test case cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc.cy.js"

# Hoặc mở Cypress Test Runner để chạy và xem kết quả trực quan
npx cypress open
```

## 7. KIỂM THỬ TÍNH RESPONSIVE CỦA GIAO DIỆN

### 7.1 Tạo test case cho tính responsive của giao diện

Tạo file `cypress/e2e/quan-ly-thuoc/responsive.cy.js`:

```javascript
describe('Kiểm thử tính responsive của giao diện', () => {
  beforeEach(() => {
    // Đăng nhập và chuyển đến trang quản lý thuốc
    cy.login('admin', 'admin123');
    cy.navigateToThuocPage();
    
    // Giả lập API lấy danh sách thuốc
    cy.intercept('POST', '**/thuoc/search', { fixture: 'thuoc.json' }).as('searchThuoc');
    cy.wait('@searchThuoc');
  });
  
  it('Hiển thị đúng trên màn hình desktop', () => {
    // Thiết lập kích thước màn hình desktop
    cy.viewport(1280, 800);
    
    // Kiểm tra hiển thị của các thành phần
    cy.get('.search-container').should('be.visible');
    cy.get('table').should('be.visible');
    cy.get('.p-paginator').should('be.visible');
    
    // Kiểm tra bố cục
    cy.get('.search-container').should('have.css', 'display', 'flex');
    cy.get('.search-container > div').should('have.length.at.least', 3);
  });
  
  it('Hiển thị đúng trên màn hình tablet', () => {
    // Thiết lập kích thước màn hình tablet
    cy.viewport(768, 1024);
    
    // Kiểm tra hiển thị của các thành phần
    cy.get('.search-container').should('be.visible');
    cy.get('table').should('be.visible');
    cy.get('.p-paginator').should('be.visible');
    
    // Kiểm tra bố cục
    cy.get('.search-container').should('have.css', 'display', 'flex');
    cy.get('.search-container').should('have.css', 'flex-direction', 'column');
  });
  
  it('Hiển thị đúng trên màn hình mobile', () => {
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);
    
    // Kiểm tra hiển thị của các thành phần
    cy.get('.search-container').should('be.visible');
    cy.get('table').should('be.visible');
    cy.get('.p-paginator').should('be.visible');
    
    // Kiểm tra bố cục
    cy.get('.search-container').should('have.css', 'display', 'flex');
    cy.get('.search-container').should('have.css', 'flex-direction', 'column');
    
    // Kiểm tra hiển thị bảng
    cy.get('table').should('have.css', 'overflow-x', 'auto');
  });
  
  it('Hiển thị đúng form thêm thuốc trên màn hình mobile', () => {
    // Thiết lập kích thước màn hình mobile
    cy.viewport(375, 667);
    
    // Nhấn nút thêm mới
    cy.get('button').contains('Thêm mới').click();
    
    // Kiểm tra hiển thị form
    cy.get('.p-dialog').should('be.visible');
    cy.get('.p-dialog').should('have.css', 'width').and('match', /90%|95%|100%/);
    
    // Kiểm tra bố cục form
    cy.get('.form-group').should('have.css', 'display', 'flex');
    cy.get('.form-group').should('have.css', 'flex-direction', 'column');
  });
});
```

### 7.2 Chạy kiểm thử tính responsive của giao diện

```bash
# Chạy test case cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/responsive.cy.js"

# Hoặc mở Cypress Test Runner để chạy và xem kết quả trực quan
npx cypress open
```

## 8. THỰC HÀNH KIỂM THỬ GIAO DIỆN

### 8.1 Bài tập thực hành
1. Viết test case kiểm thử giao diện quản lý loại thuốc
2. Viết test case kiểm thử giao diện quản lý danh mục thuốc
3. Viết test case kiểm thử validation form thêm/sửa thuốc
4. Viết test case kiểm thử hiển thị thông báo lỗi/thành công

### 8.2 Checklist kiểm thử giao diện
- [ ] Đã kiểm thử giao diện danh sách thuốc
- [ ] Đã kiểm thử giao diện thêm/sửa thuốc
- [ ] Đã kiểm thử giao diện chi tiết thuốc
- [ ] Đã kiểm thử giao diện tìm kiếm thuốc
- [ ] Đã kiểm thử tính responsive của giao diện
- [ ] Đã kiểm thử validation form
- [ ] Đã kiểm thử hiển thị thông báo
- [ ] Đã kiểm thử trên các trình duyệt khác nhau
- [ ] Đã kiểm thử trên các kích thước màn hình khác nhau

## 9. KẾT LUẬN

Kiểm thử giao diện người dùng là một phần quan trọng trong quy trình đảm bảo chất lượng phần mềm. Việc triển khai kiểm thử giao diện cho chức năng Quản lý thuốc giúp đảm bảo rằng giao diện người dùng hoạt động đúng, hiển thị chính xác và đáp ứng các yêu cầu về trải nghiệm người dùng.

Tài liệu này đã cung cấp hướng dẫn chi tiết về cách triển khai kiểm thử giao diện cho chức năng Quản lý thuốc, bao gồm kiểm thử giao diện danh sách thuốc, thêm/sửa thuốc, chi tiết thuốc, tìm kiếm thuốc và tính responsive của giao diện. Bằng cách tuân theo hướng dẫn này, bạn có thể đảm bảo rằng giao diện người dùng của chức năng Quản lý thuốc hoạt động đúng và mang lại trải nghiệm tốt cho người dùng.
