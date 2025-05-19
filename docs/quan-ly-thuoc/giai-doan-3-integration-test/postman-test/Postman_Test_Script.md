# KIỂM THỬ API BẰNG POSTMAN - TEST SCRIPT

## 1. Mục tiêu

Viết test script cho các API trong Postman Collection để kiểm thử tự động.

## 2. Phạm vi

- Viết test script cho API quản lý thuốc
- Viết test script cho API quản lý loại thuốc
- Viết test script cho API quản lý danh mục thuốc

## 3. Cách viết test script trong Postman

### 3.1. Cấu trúc cơ bản

```javascript
pm.test("Tên test case", function () {
    // Các assertion
    pm.expect(pm.response.code).to.equal(200);
});
```

### 3.2. Các loại assertion phổ biến

- Kiểm tra status code:
  ```javascript
  pm.expect(pm.response.code).to.equal(200);
  ```

- Kiểm tra response body:
  ```javascript
  var jsonData = pm.response.json();
  pm.expect(jsonData).to.have.property('status');
  pm.expect(jsonData.status).to.equal(200);
  ```

- Kiểm tra response time:
  ```javascript
  pm.expect(pm.response.responseTime).to.be.below(1000);
  ```

- Kiểm tra response header:
  ```javascript
  pm.expect(pm.response.headers.get('Content-Type')).to.equal('application/json');
  ```

## 4. Test script cho API quản lý thuốc

### 4.1. Test script cho API lấy danh sách thuốc

```javascript
// Kiểm tra status code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Kiểm tra response body
pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

// Kiểm tra status trong response
pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.equal(200);
});

// Kiểm tra data trong response
pm.test("Response data is an object with data array", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('data');
    pm.expect(jsonData.data.data).to.be.an('array');
});

// Kiểm tra response time
pm.test("Response time is less than 1000ms", function () {
    pm.expect(pm.response.responseTime).to.be.below(1000);
});
```

### 4.2. Test script cho API lấy thuốc theo ID

```javascript
// Kiểm tra status code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Kiểm tra response body
pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

// Kiểm tra status trong response
pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.equal(200);
});

// Kiểm tra data trong response
pm.test("Response data has correct thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data).to.have.property('tenThuoc');
    pm.expect(jsonData.data).to.have.property('maThuoc');
    pm.expect(jsonData.data).to.have.property('loaiThuoc');
    pm.expect(jsonData.data).to.have.property('nhaSanXuat');
});

// Lưu ID thuốc để sử dụng trong các request khác
var jsonData = pm.response.json();
if (jsonData.data && jsonData.data.id) {
    pm.environment.set("thuocId", jsonData.data.id);
}
```

### 4.3. Test script cho API thêm mới thuốc

```javascript
// Kiểm tra status code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Kiểm tra response body
pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

// Kiểm tra status trong response
pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.equal(200);
});

// Kiểm tra message trong response
pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.equal("Thành công");
});

// Kiểm tra dữ liệu thuốc trong response
pm.test("Response data has correct thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data.tenThuoc).to.equal("Vitamin C 500mg");
    pm.expect(jsonData.data.maThuoc).to.equal("VITC500");
    pm.expect(jsonData.data.donVi).to.equal("Viên");
    pm.expect(jsonData.data.giaNhap).to.equal(6000);
    pm.expect(jsonData.data.giaBan).to.equal(9000);
    pm.expect(jsonData.data.soLuongTon).to.equal(80);
    pm.expect(jsonData.data.nguongCanhBao).to.equal(15);
    pm.expect(jsonData.data.congDung).to.equal("Bổ sung vitamin C");
    pm.expect(jsonData.data.huongDanSuDung).to.equal("Uống 1 viên mỗi ngày");
    pm.expect(jsonData.data.trangThai).to.be.true;
});

// Lưu ID thuốc mới để sử dụng trong các test case khác
var jsonData = pm.response.json();
if (jsonData.data && jsonData.data.id) {
    pm.environment.set("newThuocId", jsonData.data.id);
}
```

## 5. Test script cho API quản lý loại thuốc

### 5.1. Test script cho API lấy danh sách loại thuốc

```javascript
// Kiểm tra status code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Kiểm tra response body
pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

// Kiểm tra status trong response
pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.equal(200);
});

// Kiểm tra data trong response
pm.test("Response data is an array", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.be.an('array');
});

// Lưu ID loại thuốc đầu tiên để sử dụng trong các request khác
var jsonData = pm.response.json();
if (jsonData.data && jsonData.data.length > 0) {
    pm.environment.set("loaiThuocId", jsonData.data[0].id);
}
```

### 5.2. Test script cho API thêm mới loại thuốc

```javascript
// Kiểm tra status code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Kiểm tra response body
pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

// Kiểm tra status trong response
pm.test("Response status is 201", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.equal(201);
});

// Kiểm tra message trong response
pm.test("Response message is 'Tạo loại thuốc thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.equal("Tạo loại thuốc thành công");
});

// Kiểm tra dữ liệu loại thuốc trong response
pm.test("Response data has correct loai thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data.tenLoai).to.equal("Vitamin và khoáng chất");
    pm.expect(jsonData.data.moTa).to.equal("Nhóm vitamin và khoáng chất");
});

// Lưu ID loại thuốc mới để sử dụng trong các test case khác
var jsonData = pm.response.json();
if (jsonData.data && jsonData.data.id) {
    pm.environment.set("newLoaiThuocId", jsonData.data.id);
}
```

## 6. Test script cho API quản lý danh mục thuốc

### 6.1. Test script cho API lấy danh sách danh mục thuốc

```javascript
// Kiểm tra status code
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

// Kiểm tra response body
pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

// Kiểm tra status trong response
pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.equal(200);
});

// Kiểm tra data trong response
pm.test("Response data is an array", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.be.an('array');
});

// Lưu ID danh mục thuốc đầu tiên để sử dụng trong các request khác
var jsonData = pm.response.json();
if (jsonData.data && jsonData.data.length > 0) {
    pm.environment.set("danhMucThuocId", jsonData.data[0].id);
}
```

## 7. Chạy test tự động

### 7.1. Chạy test cho một request

1. Mở request cần test
2. Nhấn nút "Send" để gửi request
3. Xem kết quả test trong tab "Test Results"

### 7.2. Chạy test cho toàn bộ Collection

1. Nhấp chuột phải vào Collection "Quản lý thuốc"
2. Chọn "Run collection"
3. Cấu hình các tùy chọn chạy
4. Nhấn "Run Quản lý thuốc"
5. Xem kết quả test trong tab "Run Results"

### 7.3. Chạy test bằng Newman

```bash
newman run QuanLyThuoc.postman_collection.json -e Local.postman_environment.json
```

## 8. Lưu ý khi viết test script

1. **Thứ tự thực hiện**: Test script được thực hiện sau khi nhận được response
2. **Biến môi trường**: Sử dụng biến môi trường để lưu trữ dữ liệu giữa các request
3. **Xử lý lỗi**: Thêm các test case để xử lý các trường hợp lỗi
4. **Tài liệu tham khảo**: Tham khảo [Postman Test Script Documentation](https://learning.postman.com/docs/writing-scripts/test-scripts/) để biết thêm chi tiết
