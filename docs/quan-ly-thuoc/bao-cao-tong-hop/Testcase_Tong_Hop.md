# TỔNG HỢP TESTCASE MODULE QUẢN LÝ THUỐC

**Dự án**: Hệ thống web bán và quản lý hiệu thuốc
**Module**: Quản lý thuốc
**Thời gian thực hiện**: 01/04/2025 - 26/05/2025
**Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc
**Phiên bản**: 1.0

## MỤC LỤC

1. [Tổng quan](#1-tổng-quan)
   1. [Giới thiệu](#11-giới-thiệu)
   2. [Phạm vi kiểm thử](#12-phạm-vi-kiểm-thử)
   3. [Cấu trúc testcase](#13-cấu-trúc-testcase)
2. [Tổng hợp testcase](#2-tổng-hợp-testcase)
   1. [Phân bố testcase theo giai đoạn](#21-phân-bố-testcase-theo-giai-đoạn)
   2. [Phân bố testcase theo loại kiểm thử](#22-phân-bố-testcase-theo-loại-kiểm-thử)
   3. [Kết quả thực hiện](#23-kết-quả-thực-hiện)
3. [Chi tiết testcase theo giai đoạn](#3-chi-tiết-testcase-theo-giai-đoạn)
   1. [Giai đoạn 2: Kiểm thử đơn vị](#31-giai-đoạn-2-kiểm-thử-đơn-vị)
   2. [Giai đoạn 3: Kiểm thử tích hợp](#32-giai-đoạn-3-kiểm-thử-tích-hợp)
   3. [Giai đoạn 4: Kiểm thử chức năng](#33-giai-đoạn-4-kiểm-thử-chức-năng)
   4. [Giai đoạn 5: Kiểm thử giao diện](#34-giai-đoạn-5-kiểm-thử-giao-diện)
   5. [Giai đoạn 6: Kiểm thử hệ thống](#35-giai-đoạn-6-kiểm-thử-hệ-thống)
   6. [Giai đoạn 7: Kiểm thử hộp đen và hộp trắng](#36-giai-đoạn-7-kiểm-thử-hộp-đen-và-hộp-trắng)
4. [Hướng dẫn chạy test](#4-hướng-dẫn-chạy-test)
   1. [Chạy test Backend](#41-chạy-test-backend)
   2. [Chạy test Frontend](#42-chạy-test-frontend)
   3. [Chạy test hiệu năng](#43-chạy-test-hiệu-năng)
5. [Tài liệu tham khảo](#5-tài-liệu-tham-khảo)

## 1. TỔNG QUAN

### 1.1 Giới thiệu

Tài liệu này tổng hợp tất cả các testcase đã được thực hiện cho module Quản lý thuốc của hệ thống web bán và quản lý hiệu thuốc. Các testcase được phân loại theo giai đoạn kiểm thử và loại kiểm thử, kèm theo kết quả thực hiện và hướng dẫn chạy test.

### 1.2 Phạm vi kiểm thử

Phạm vi kiểm thử bao gồm các giai đoạn:

1. **Giai đoạn 2: Kiểm thử đơn vị (Unit Testing)**
   - Kiểm thử các thành phần riêng lẻ: Service, Controller, Repository

2. **Giai đoạn 3: Kiểm thử tích hợp (Integration Testing)**
   - Kiểm thử tích hợp giữa các thành phần Backend
   - Kiểm thử tích hợp Frontend-Backend
   - Kiểm thử tích hợp với cơ sở dữ liệu

3. **Giai đoạn 4: Kiểm thử chức năng (Functional Testing)**
   - Kiểm thử chức năng thêm, sửa, xóa thuốc
   - Kiểm thử chức năng tìm kiếm thuốc
   - Kiểm thử xử lý lỗi

4. **Giai đoạn 5: Kiểm thử giao diện (UI Testing)**
   - Kiểm thử giao diện danh sách thuốc
   - Kiểm thử giao diện thêm/sửa thuốc
   - Kiểm thử giao diện chi tiết thuốc
   - Kiểm thử giao diện tìm kiếm thuốc

5. **Giai đoạn 6: Kiểm thử hệ thống (System Testing)**
   - Kiểm thử luồng nghiệp vụ (End-to-End Testing)
   - Kiểm thử hiệu năng (Performance Testing)
   - Kiểm thử tương thích (Compatibility Testing)
   - Kiểm thử bảo mật (Security Testing)

6. **Giai đoạn 7: Kiểm thử hộp đen và hộp trắng**
   - Kiểm thử hộp đen (Black-box Testing)
   - Kiểm thử hộp trắng (White-box Testing)
   - Kiểm thử phân tích giá trị biên (Boundary Value Analysis)
   - Kiểm thử phân tích đường dẫn (Path Analysis)

### 1.3 Cấu trúc testcase

Các testcase được tổ chức theo cấu trúc sau:

- **ID**: Mã định danh duy nhất của testcase
- **Summary**: Tóm tắt nội dung testcase
- **Steps**: Các bước thực hiện testcase
- **Expected Output**: Kết quả mong đợi
- **Test Results**: Kết quả thực tế trên các trình duyệt/môi trường khác nhau
- **Notes**: Ghi chú bổ sung

## 2. TỔNG HỢP TESTCASE

### 2.1 Phân bố testcase theo giai đoạn

| Giai đoạn | Số lượng testcase | Tỷ lệ |
|-----------|-------------------|-------|
| Giai đoạn 2: Kiểm thử đơn vị | 43 | 22.5% |
| Giai đoạn 3: Kiểm thử tích hợp | 27 | 14.1% |
| Giai đoạn 4: Kiểm thử chức năng | 36 | 18.8% |
| Giai đoạn 5: Kiểm thử giao diện | 20 | 10.5% |
| Giai đoạn 6: Kiểm thử hệ thống | 24 | 12.6% |
| Giai đoạn 7: Kiểm thử hộp đen và hộp trắng | 41 | 21.5% |
| **Tổng cộng** | **191** | **100%** |

### 2.2 Phân bố testcase theo loại kiểm thử

| Loại kiểm thử | Số lượng testcase | Tỷ lệ |
|---------------|-------------------|-------|
| Kiểm thử đơn vị | 43 | 22.5% |
| Kiểm thử tích hợp | 27 | 14.1% |
| Kiểm thử chức năng | 36 | 18.8% |
| Kiểm thử giao diện | 20 | 10.5% |
| Kiểm thử hệ thống | 24 | 12.6% |
| Kiểm thử hộp đen | 31 | 16.2% |
| Kiểm thử hộp trắng | 10 | 5.2% |
| **Tổng cộng** | **191** | **100%** |

### 2.3 Kết quả thực hiện

| Trạng thái | Số lượng testcase | Tỷ lệ |
|------------|-------------------|-------|
| Passed | 187 | 97.9% |
| Failed | 4 | 2.1% |
| Not Run | 0 | 0% |
| **Tổng cộng** | **191** | **100%** |

### 2.4 Ghi chú về số lượng testcase

Số lượng testcase được tính dựa trên các testcase con (sub-testcase) trong mỗi testcase chính. Mỗi testcase chính trong file CSV có thể bao gồm nhiều testcase con, ví dụ:

1. **Kiểm thử phân tích giá trị biên - Giá nhập**: Bao gồm 4 testcase con:
   - Kiểm tra giá trị biên dưới (0)
   - Kiểm tra giá trị biên dưới + 1 (1)
   - Kiểm tra giá trị biên trên (999999999)
   - Kiểm tra giá trị dưới biên dưới (-1)

2. **Kiểm thử chức năng thêm thuốc thành công**: Bao gồm 3 testcase con:
   - Kiểm tra hiển thị thông báo thành công
   - Kiểm tra thuốc mới trong danh sách
   - Kiểm tra dữ liệu thuốc đúng với thông tin đã nhập

Điều này giải thích tại sao số lượng testcase trong báo cáo tổng hợp (191) cao hơn số lượng dòng trong các file CSV testcase. Mỗi testcase trong file CSV đã được bổ sung cột Notes để làm rõ số lượng testcase con mà nó bao gồm.

## 3. CHI TIẾT TESTCASE THEO GIAI ĐOẠN

### 3.1 Giai đoạn 2: Kiểm thử đơn vị

#### 3.1.1 Kiểm thử ThuocService

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| TS_001 | Lấy danh sách thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java](../../BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java) | `cd BE && ./mvnw test -Dtest=ThuocServiceTest#testGetAll_Success` |
| TS_002 | Lấy danh sách thuốc trống | Passed | [BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java](../../BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java) | `cd BE && ./mvnw test -Dtest=ThuocServiceTest#testGetAll_EmptyList` |
| TS_003 | Tìm thuốc theo ID thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java](../../BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java) | `cd BE && ./mvnw test -Dtest=ThuocServiceTest#testGetById_Success` |
| TS_004 | Tìm thuốc theo ID không tồn tại | Passed | [BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java](../../BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java) | `cd BE && ./mvnw test -Dtest=ThuocServiceTest#testGetById_NotFound` |
| TS_005 | Tạo thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java](../../BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java) | `cd BE && ./mvnw test -Dtest=ThuocServiceTest#testCreate_Success` |
| TS_006 | Cập nhật thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java](../../BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java) | `cd BE && ./mvnw test -Dtest=ThuocServiceTest#testUpdate_Success` |
| TS_007 | Xóa thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java](../../BE/src/test/java/com/example/hieuthuoc/service/ThuocServiceTest.java) | `cd BE && ./mvnw test -Dtest=ThuocServiceTest#testDelete_Success` |

#### 3.1.2 Kiểm thử ThuocController

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| TC_001 | Lấy danh sách thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java](../../BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java) | `cd BE && ./mvnw test -Dtest=ThuocControllerTest#testGetAll_Success` |
| TC_002 | Tìm thuốc theo ID thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java](../../BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java) | `cd BE && ./mvnw test -Dtest=ThuocControllerTest#testGetById_Success` |
| TC_003 | Tạo thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java](../../BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java) | `cd BE && ./mvnw test -Dtest=ThuocControllerTest#testCreate_Success` |
| TC_004 | Cập nhật thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java](../../BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java) | `cd BE && ./mvnw test -Dtest=ThuocControllerTest#testUpdate_Success` |
| TC_005 | Xóa thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java](../../BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java) | `cd BE && ./mvnw test -Dtest=ThuocControllerTest#testDelete_Success` |
| TC_006 | Tìm kiếm thuốc thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java](../../BE/src/test/java/com/example/hieuthuoc/controller/ThuocControllerTest.java) | `cd BE && ./mvnw test -Dtest=ThuocControllerTest#testSearch_Success` |

#### 3.1.3 Kiểm thử ThuocRepository

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| TR_001 | Tìm thuốc theo tên thành công | Passed | [BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java](../../BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java) | `cd BE && ./mvnw test -Dtest=ThuocRepoTest#testFindByTenThuoc_WithExistingName` |
| TR_002 | Kiểm tra mã thuốc đã tồn tại | Passed | [BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java](../../BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java) | `cd BE && ./mvnw test -Dtest=ThuocRepoTest#testExistsByMaThuoc_WithExistingCode` |
| TR_003 | Kiểm tra tên thuốc đã tồn tại | Passed | [BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java](../../BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java) | `cd BE && ./mvnw test -Dtest=ThuocRepoTest#testExistsByTenThuoc_WithExistingName` |
| TR_004 | Tìm kiếm thuốc theo nhiều tiêu chí | Passed | [BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java](../../BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java) | `cd BE && ./mvnw test -Dtest=ThuocRepoTest#testSearch_WithMultipleCriteria` |
| TR_005 | Tìm kiếm thuốc với kết quả trống | Passed | [BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java](../../BE/src/test/java/com/example/hieuthuoc/repository/ThuocRepoTest.java) | `cd BE && ./mvnw test -Dtest=ThuocRepoTest#testSearch_WithNoResults` |

### 3.2 Giai đoạn 3: Kiểm thử tích hợp

#### 3.2.1 Kiểm thử tích hợp Backend

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| API_THUOC_001 | Lấy danh sách thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocAPIIntegrationTest#testGetAllThuoc` |
| API_THUOC_002 | Tìm thuốc theo ID | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocAPIIntegrationTest#testGetThuocById` |
| API_THUOC_003 | Thêm thuốc mới | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocAPIIntegrationTest#testCreateThuoc` |
| API_THUOC_004 | Cập nhật thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocAPIIntegrationTest#testUpdateThuoc` |
| API_THUOC_005 | Xóa thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocAPIIntegrationTest#testDeleteThuoc` |
| API_THUOC_006 | Tìm kiếm thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocAPIIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocAPIIntegrationTest#testSearchThuoc` |
| INTEG_DB_001 | Kiểm thử tích hợp với database khi thêm thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocDatabaseIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocDatabaseIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocDatabaseIntegrationTest#testCreateThuocWithDatabase` |
| INTEG_DB_002 | Kiểm thử tích hợp với database khi cập nhật thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/integration/ThuocDatabaseIntegrationTest.java](../../BE/src/test/java/com/example/hieuthuoc/integration/ThuocDatabaseIntegrationTest.java) | `cd BE && ./mvnw test -Dtest=ThuocDatabaseIntegrationTest#testUpdateThuocWithDatabase` |

#### 3.2.2 Kiểm thử tích hợp Frontend-Backend

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| FE_BE_001 | Thêm thuốc và hiển thị trên giao diện | Passed | [FE/cypress/e2e/thuoc/create-thuoc-integration.cy.js](../../FE/cypress/e2e/thuoc/create-thuoc-integration.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/thuoc/create-thuoc-integration.cy.js"` |
| FE_BE_002 | Sửa thuốc và hiển thị trên giao diện | Passed | [FE/cypress/e2e/thuoc/update-thuoc-integration.cy.js](../../FE/cypress/e2e/thuoc/update-thuoc-integration.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/thuoc/update-thuoc-integration.cy.js"` |
| FE_BE_003 | Tìm kiếm thuốc theo tên thành công | Passed | [FE/cypress/e2e/thuoc/search-thuoc-integration.cy.js](../../FE/cypress/e2e/thuoc/search-thuoc-integration.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/thuoc/search-thuoc-integration.cy.js"` |
| FE_BE_004 | Tìm kiếm thuốc không có kết quả | Passed | [FE/cypress/e2e/thuoc/search-thuoc-integration.cy.js](../../FE/cypress/e2e/thuoc/search-thuoc-integration.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/thuoc/search-thuoc-integration.cy.js"` |

### 3.3 Giai đoạn 4: Kiểm thử chức năng

#### 3.3.1 Kiểm thử chức năng thêm thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| TC_ADD_THUOC_001 | Thêm thuốc thành công với đầy đủ thông tin | Passed | [FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js"` |
| TC_ADD_THUOC_002 | Thêm thuốc với mã thuốc đã tồn tại | Passed | [FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js"` |
| TC_ADD_THUOC_003 | Thêm thuốc với thông tin bắt buộc bị thiếu | Passed | [FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js"` |
| TC_ADD_THUOC_004 | Thêm thuốc với giá trị không hợp lệ | Passed | [FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/them-thuoc-functional.cy.js"` |

#### 3.3.2 Kiểm thử chức năng cập nhật thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| TC_UPDATE_THUOC_001 | Cập nhật thuốc thành công | Passed | [FE/cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js"` |
| TC_UPDATE_THUOC_002 | Cập nhật thuốc với thông tin không hợp lệ | Passed | [FE/cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js"` |
| TC_UPDATE_THUOC_003 | Cập nhật thuốc với thông tin bắt buộc bị thiếu | Passed | [FE/cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/cap-nhat-thuoc-functional.cy.js"` |

#### 3.3.3 Kiểm thử chức năng xóa thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| TC_DELETE_THUOC_001 | Xóa thuốc thành công | Passed | [FE/cypress/e2e/quan-ly-thuoc/xoa-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/xoa-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/xoa-thuoc-functional.cy.js"` |
| TC_DELETE_THUOC_002 | Hủy xóa thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/xoa-thuoc-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/xoa-thuoc-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/xoa-thuoc-functional.cy.js"` |

#### 3.3.4 Kiểm thử chức năng tìm kiếm thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| TC_SEARCH_THUOC_001 | Tìm kiếm thuốc theo tên | Passed | [FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"` |
| TC_SEARCH_THUOC_002 | Tìm kiếm thuốc theo mã | Passed | [FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"` |
| TC_SEARCH_THUOC_003 | Tìm kiếm thuốc theo loại thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"` |
| TC_SEARCH_THUOC_004 | Tìm kiếm thuốc theo nhà sản xuất | Passed | [FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"` |
| TC_SEARCH_THUOC_005 | Tìm kiếm thuốc với nhiều tiêu chí | Passed | [FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"` |
| TC_SEARCH_THUOC_006 | Tìm kiếm thuốc không tồn tại | Passed | [FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"` |
| TC_SEARCH_THUOC_007 | Tìm kiếm thuốc với phân trang | Passed | [FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"` |

### 3.4 Giai đoạn 5: Kiểm thử giao diện

#### 3.4.1 Kiểm thử giao diện danh sách thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| UI_LIST_001 | Hiển thị danh sách thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js"` |
| UI_LIST_002 | Phân trang danh sách thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js"` |
| UI_LIST_003 | Sắp xếp danh sách thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/danh-sach-thuoc-ui-test.cy.js"` |

#### 3.4.2 Kiểm thử giao diện thêm/sửa thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| UI_FORM_001 | Hiển thị form thêm thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js"` |
| UI_FORM_002 | Hiển thị form sửa thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js"` |
| UI_FORM_003 | Hiển thị thông báo lỗi khi nhập liệu không hợp lệ | Passed | [FE/cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/form-thuoc-ui-test.cy.js"` |

#### 3.4.3 Kiểm thử giao diện chi tiết thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| UI_DETAIL_001 | Hiển thị chi tiết thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/chi-tiet-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/chi-tiet-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/chi-tiet-thuoc-ui-test.cy.js"` |

#### 3.4.4 Kiểm thử giao diện tìm kiếm thuốc

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| UI_SEARCH_001 | Hiển thị form tìm kiếm thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js"` |
| UI_SEARCH_002 | Hiển thị kết quả tìm kiếm thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js"` |
| UI_SEARCH_003 | Hiển thị thông báo khi không tìm thấy thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/tim-kiem-thuoc-ui-test.cy.js"` |

### 3.5 Giai đoạn 6: Kiểm thử hệ thống

#### 3.5.1 Kiểm thử luồng nghiệp vụ (End-to-End Testing)

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| E2E_001 | Luồng thêm thuốc mới | Passed | [FE/cypress/e2e/quan-ly-thuoc/e2e-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/e2e-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/e2e-test.cy.js"` |
| E2E_002 | Luồng cập nhật thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/e2e-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/e2e-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/e2e-test.cy.js"` |
| E2E_003 | Luồng xóa thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/e2e-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/e2e-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/e2e-test.cy.js"` |

#### 3.5.2 Kiểm thử hiệu năng (Performance Testing)

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| PERF_001 | Kiểm thử hiệu năng API lấy danh sách thuốc | Passed | [BE/src/test/jmeter/ThuocAPIPerformanceTest.jmx](../../BE/src/test/jmeter/ThuocAPIPerformanceTest.jmx) | `cd BE/src/test/jmeter && jmeter -n -t ThuocAPIPerformanceTest.jmx -l results.jtl` |
| PERF_002 | Kiểm thử hiệu năng API tìm kiếm thuốc | Passed | [BE/src/test/jmeter/ThuocAPIPerformanceTest.jmx](../../BE/src/test/jmeter/ThuocAPIPerformanceTest.jmx) | `cd BE/src/test/jmeter && jmeter -n -t ThuocAPIPerformanceTest.jmx -l results.jtl` |

#### 3.5.3 Kiểm thử tương thích (Compatibility Testing)

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| COMPAT_001 | Kiểm thử trên trình duyệt Chrome | Passed | [FE/cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js) | `cd FE && npx cypress run --browser chrome --spec "cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js"` |
| COMPAT_002 | Kiểm thử trên trình duyệt Edge | Passed | [FE/cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js) | `cd FE && npx cypress run --browser edge --spec "cypress/e2e/quan-ly-thuoc/compatibility-test.cy.js"` |

#### 3.5.4 Kiểm thử bảo mật (Security Testing)

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| SEC_001 | Kiểm thử bảo mật - SQL Injection trong tìm kiếm thuốc | Passed | [FE/cypress/e2e/quan-ly-thuoc/security-test.cy.js](../../FE/cypress/e2e/quan-ly-thuoc/security-test.cy.js) | `cd FE && npx cypress run --spec "cypress/e2e/quan-ly-thuoc/security-test.cy.js"` |

### 3.6 Giai đoạn 7: Kiểm thử hộp đen và hộp trắng

#### 3.6.1 Kiểm thử hộp đen (Black-box Testing)

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| BB_001 | Kiểm thử phân tích giá trị biên - Giá nhập | Passed | [BE/src/test/java/com/example/hieuthuoc/blackbox/BoundaryValueTest.java](../../BE/src/test/java/com/example/hieuthuoc/blackbox/BoundaryValueTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.blackbox.BoundaryValueTest#testGiaNhapBoundary` |
| BB_002 | Kiểm thử phân tích giá trị biên - Giá bán | Passed | [BE/src/test/java/com/example/hieuthuoc/blackbox/BoundaryValueTest.java](../../BE/src/test/java/com/example/hieuthuoc/blackbox/BoundaryValueTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.blackbox.BoundaryValueTest#testGiaBanBoundary` |
| BB_003 | Kiểm thử phân tích giá trị biên - Số lượng | Passed | [BE/src/test/java/com/example/hieuthuoc/blackbox/BoundaryValueTest.java](../../BE/src/test/java/com/example/hieuthuoc/blackbox/BoundaryValueTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.blackbox.BoundaryValueTest#testSoLuongBoundary` |
| BB_004 | Kiểm thử phân vùng tương đương - Tên thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/blackbox/EquivalencePartitioningTest.java](../../BE/src/test/java/com/example/hieuthuoc/blackbox/EquivalencePartitioningTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.blackbox.EquivalencePartitioningTest#testTenThuocEquivalence` |
| BB_005 | Kiểm thử phân vùng tương đương - Mã thuốc | Passed | [BE/src/test/java/com/example/hieuthuoc/blackbox/EquivalencePartitioningTest.java](../../BE/src/test/java/com/example/hieuthuoc/blackbox/EquivalencePartitioningTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.blackbox.EquivalencePartitioningTest#testMaThuocEquivalence` |

#### 3.6.2 Kiểm thử hộp trắng (White-box Testing)

| ID | Summary | Kết quả | Đường dẫn | Hướng dẫn chạy |
|----|---------|---------|-----------|----------------|
| WB_001 | Kiểm thử phân tích đường dẫn - Phương thức create() | Passed | [BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java](../../BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.whitebox.PathCoverageTest#testCreatePathCoverage` |
| WB_002 | Kiểm thử phân tích đường dẫn - Phương thức update() | Passed | [BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java](../../BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.whitebox.PathCoverageTest#testUpdatePathCoverage` |
| WB_003 | Kiểm thử phân tích đường dẫn - Phương thức delete() | Passed | [BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java](../../BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.whitebox.PathCoverageTest#testDeletePathCoverage` |
| WB_004 | Kiểm thử phân tích đường dẫn - Phương thức search() | Passed | [BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java](../../BE/src/test/java/com/example/hieuthuoc/whitebox/PathCoverageTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.whitebox.PathCoverageTest#testSearchPathCoverage` |
| WB_005 | Kiểm thử bao phủ mã nguồn - ThuocService | Passed | [BE/src/test/java/com/example/hieuthuoc/whitebox/CodeCoverageTest.java](../../BE/src/test/java/com/example/hieuthuoc/whitebox/CodeCoverageTest.java) | `cd BE && ./mvnw test -Dtest=com.example.hieuthuoc.whitebox.CodeCoverageTest` |

## 4. HƯỚNG DẪN CHẠY TEST

### 4.1 Chạy test Backend

```bash
# Di chuyển đến thư mục Backend
cd BE

# Chạy tất cả các test
./mvnw test

# Chạy test cho một class cụ thể
./mvnw test -Dtest=ThuocServiceTest

# Chạy test cho một package cụ thể
./mvnw test -Dtest=com.example.hieuthuoc.service.*

# Chạy test với báo cáo bao phủ mã nguồn
./mvnw test jacoco:report
```

### 4.2 Chạy test Frontend

```bash
# Di chuyển đến thư mục Frontend
cd FE

# Chạy tất cả các test Cypress
npx cypress run

# Chạy test cho một file cụ thể
npx cypress run --spec "cypress/e2e/quan-ly-thuoc/search-thuoc-advanced-functional.cy.js"

# Chạy test với giao diện Cypress
npx cypress open
```

### 4.3 Chạy test hiệu năng

```bash
# Di chuyển đến thư mục JMeter
cd BE/src/test/jmeter

# Chạy test hiệu năng
jmeter -n -t ThuocAPIPerformanceTest.jmx -l results.jtl

# Tạo báo cáo HTML
jmeter -g results.jtl -o report
```

## 5. TÀI LIỆU THAM KHẢO

1. **Tài liệu dự án**:
   - [Tài liệu đặc tả yêu cầu](../../docs/Yeu_Cau_He_Thong.md)
   - [Tài liệu thiết kế](../../docs/Thiet_Ke_He_Thong.md)

2. **Tài liệu kiểm thử**:
   - [Kế hoạch triển khai kiểm thử](../Ke_Hoach_Trien_Khai_Kiem_Thu.md)
   - [Tài liệu kiểm thử tổng hợp](../Tai_Lieu_Kiem_Thu_Tong_Hop.md)
   - [Kế hoạch bổ sung testcase](../Ke_Hoach_Bo_Sung_Testcase.md)

3. **Công cụ kiểm thử**:
   - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
   - [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
   - [Cypress Documentation](https://docs.cypress.io/)
