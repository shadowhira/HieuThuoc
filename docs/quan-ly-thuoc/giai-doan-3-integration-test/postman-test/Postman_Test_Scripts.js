// Test script cho API đăng nhập
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has token", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('token');
    pm.expect(jsonData.token).to.be.a('string').and.to.have.lengthOf.above(10);
    
    // Lưu token vào biến môi trường
    if (jsonData.token) {
        pm.environment.set("token", jsonData.token);
    }
});

// Test script cho API lấy danh sách thuốc
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
    pm.expect(jsonData.data).to.have.property('content');
    pm.expect(jsonData.data).to.have.property('totalElements');
    pm.expect(jsonData.data).to.have.property('totalPages');
    pm.expect(jsonData.data).to.have.property('size');
    pm.expect(jsonData.data).to.have.property('number');
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

// Test script cho API lấy thuốc theo ID
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response data has correct thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data).to.have.property('tenThuoc');
    pm.expect(jsonData.data).to.have.property('maThuoc');
    pm.expect(jsonData.data).to.have.property('donVi');
    pm.expect(jsonData.data).to.have.property('giaNhap');
    pm.expect(jsonData.data).to.have.property('giaBan');
    pm.expect(jsonData.data).to.have.property('soLuongTon');
    pm.expect(jsonData.data).to.have.property('nguongCanhBao');
});

// Test script cho API thêm mới thuốc
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});

pm.test("Response data has correct thuoc info", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.data).to.have.property('id');
    pm.expect(jsonData.data.tenThuoc).to.eql("Vitamin D3 1000IU");
    pm.expect(jsonData.data.maThuoc).to.eql("VITD1000");
    pm.expect(jsonData.data.donVi).to.eql("Viên");
    pm.expect(jsonData.data.giaNhap).to.eql(8000);
    pm.expect(jsonData.data.giaBan).to.eql(12000);
    pm.expect(jsonData.data.soLuongTon).to.eql(100);
    pm.expect(jsonData.data.nguongCanhBao).to.eql(20);
    pm.expect(jsonData.data.congDung).to.eql("Bổ sung vitamin D3");
    pm.expect(jsonData.data.huongDanSuDung).to.eql("Uống 1 viên mỗi ngày");
    pm.expect(jsonData.data.trangThai).to.be.true;
    
    // Lưu ID thuốc mới để sử dụng trong các test case khác
    if (jsonData.data && jsonData.data.id) {
        pm.environment.set("newThuocId", jsonData.data.id);
    }
});

// Test script cho API cập nhật thuốc
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
    pm.expect(jsonData).to.have.property('data');
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});

// Test script cho API xóa thuốc
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has correct structure", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('status');
    pm.expect(jsonData).to.have.property('msg');
});

pm.test("Response status is 200", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.status).to.eql(200);
});

pm.test("Response message is 'Thành công'", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.msg).to.eql("Thành công");
});
