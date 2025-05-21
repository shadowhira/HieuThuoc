# KẾ HOẠCH BỔ SUNG TESTCASE CHO CHỨC NĂNG QUẢN LÝ THUỐC

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Mục tiêu**: Bổ sung testcase để đạt khoảng 150 testcase
- **Phương pháp**: Kết hợp kiểm thử hộp đen và hộp trắng

## 📊 HIỆN TRẠNG TESTCASE

Hiện tại, chức năng Quản lý thuốc có 87 testcase phân bố như sau:
- Giai đoạn 2 (Kiểm thử đơn vị): 41 testcase (18 testcase ban đầu + 23 testcase bổ sung)
- Giai đoạn 3 (Kiểm thử tích hợp): 12 testcase
- Giai đoạn 4 (Kiểm thử chức năng): 16 testcase
- Giai đoạn 5 (Kiểm thử giao diện): 10 testcase
- Giai đoạn 6 (Kiểm thử hệ thống): 8 testcase

## 🎯 MỤC TIÊU

Bổ sung 63 testcase để đạt tổng cộng 150 testcase, đảm bảo độ bao phủ cao và chất lượng kiểm thử tốt. Đã bổ sung 23 testcase cho giai đoạn 2 (Kiểm thử đơn vị).

## 📝 PHƯƠNG PHÁP KIỂM THỬ

### 1. Phương pháp kiểm thử hộp đen (Black Box Testing)

#### 1.1. Phân vùng tương đương (Equivalence Partitioning)
Chia đầu vào thành các nhóm dữ liệu có cùng đặc tính:
- Giá trị hợp lệ: Trong khoảng cho phép
- Giá trị không hợp lệ: Ngoài khoảng cho phép

#### 1.2. Phân tích giá trị biên (Boundary Value Analysis)
Kiểm thử các giá trị ở biên của phạm vi hợp lệ:
- Giá trị biên dưới: Min, Min-1
- Giá trị biên trên: Max, Max+1

#### 1.3. Bảng quyết định (Decision Table)
Kết hợp các điều kiện đầu vào và kết quả mong đợi:
- Các trường hợp kết hợp điều kiện khác nhau

#### 1.4. Kiểm thử trạng thái (State Transition Testing)
Kiểm tra chuyển đổi trạng thái của hệ thống:
- Các trạng thái của thuốc: Còn hàng, Sắp hết hàng, Hết hàng
- Các trạng thái của hạn sử dụng: Còn hạn, Sắp hết hạn, Hết hạn

#### 1.5. Kiểm thử trường hợp sử dụng (Use Case Testing)
Kiểm tra các luồng nghiệp vụ từ đầu đến cuối:
- Luồng thêm thuốc mới
- Luồng cập nhật thông tin thuốc
- Luồng xóa thuốc

### 2. Phương pháp kiểm thử hộp trắng (White Box Testing)

#### 2.1. Kiểm thử đường dẫn (Path Testing)
Kiểm tra tất cả các đường dẫn có thể trong mã nguồn:
- Các nhánh điều kiện if-else
- Các vòng lặp for, while

#### 2.2. Kiểm thử nhánh (Branch Testing)
Kiểm tra tất cả các nhánh trong mã nguồn:
- Các điều kiện true/false

#### 2.3. Kiểm thử câu lệnh (Statement Testing)
Kiểm tra tất cả các câu lệnh trong mã nguồn:
- Đảm bảo mỗi dòng mã được thực thi ít nhất một lần

#### 2.4. Kiểm thử luồng dữ liệu (Data Flow Testing)
Kiểm tra luồng dữ liệu trong mã nguồn:
- Khởi tạo biến
- Sử dụng biến

## 📋 KẾ HOẠCH BỔ SUNG TESTCASE

### 1. Kiểm thử đơn vị (Unit Testing) - Đã bổ sung 23/25 testcase

#### 1.1. Kiểm thử ThuocRepository (5/5 testcase) - Hoàn thành
1. ✅ Kiểm thử findByTenThuoc() với tên thuốc tồn tại
2. ✅ Kiểm thử existsByMaThuoc() với mã thuốc tồn tại
3. ✅ Kiểm thử existsByMaThuoc() với mã thuốc không tồn tại
4. ✅ Kiểm thử existsByTenThuoc() với tên thuốc tồn tại
5. ✅ Kiểm thử search() với nhiều tiêu chí tìm kiếm

#### 1.2. Kiểm thử ThuocService - Xử lý đầu vào (4/10 testcase) - Cần bổ sung thêm
6. ✅ Kiểm thử create() với tên thuốc trống
7. ✅ Kiểm thử create() với mã thuốc trống
8. ❌ Kiểm thử create() với loaiThuocId không tồn tại
9. ❌ Kiểm thử create() với nhaSanXuatId không tồn tại
10. ❌ Kiểm thử create() với giá nhập âm
11. ❌ Kiểm thử create() với giá bán âm
12. ❌ Kiểm thử create() với số lượng tồn âm
13. ❌ Kiểm thử create() với hạn sử dụng trong quá khứ
14. ✅ Kiểm thử create() với danh sách thành phần thuốc rỗng
15. ✅ Kiểm thử create() với danh sách đối tượng sử dụng rỗng

#### 1.3. Kiểm thử ThuocService - Xử lý ngoại lệ (4/5 testcase) - Cần bổ sung thêm
16. ✅ Kiểm thử create() khi repository ném exception
17. ✅ Kiểm thử update() khi repository ném exception
18. ✅ Kiểm thử delete() khi repository ném exception
19. ✅ Kiểm thử getById() khi repository ném exception
20. ❌ Kiểm thử search() khi repository ném exception (Testcase đã tạo nhưng chưa pass)

#### 1.4. Kiểm thử LoaiThuocService và DanhMucThuocService (5/5 testcase) - Hoàn thành
21. ✅ Kiểm thử LoaiThuocService.create() với danhMucThuocId không tồn tại
22. ✅ Kiểm thử LoaiThuocService.update() với id không tồn tại
23. ✅ Kiểm thử LoaiThuocService.delete() với id không tồn tại
24. ✅ Kiểm thử DanhMucThuocService.update() với id không tồn tại
25. ✅ Kiểm thử DanhMucThuocService.delete() với id không tồn tại

### 2. Kiểm thử tích hợp (Integration Testing) - Bổ sung 15 testcase

#### 2.1. Kiểm thử tích hợp giữa các service (6 testcase) - Hoàn thành
26. ✅ Kiểm thử tích hợp giữa ThuocService và LoaiThuocService khi thêm thuốc
27. ✅ Kiểm thử tích hợp giữa ThuocService và NhaSanXuatService khi thêm thuốc
28. ✅ Kiểm thử tích hợp giữa ThuocService và DoiTuongService khi thêm thuốc
29. ✅ Kiểm thử tích hợp giữa LoaiThuocService và DanhMucThuocService khi thêm loại thuốc
30. ✅ Kiểm thử tích hợp giữa ThuocService và ThanhPhanThuocService khi thêm thuốc
31. ✅ Kiểm thử tích hợp giữa ThuocService và UploadImageService khi thêm thuốc có hình ảnh

#### 2.2. Kiểm thử tích hợp với cơ sở dữ liệu (5 testcase) - Hoàn thành
32. ✅ Kiểm thử tích hợp với database khi thêm thuốc
33. ✅ Kiểm thử tích hợp với database khi cập nhật thuốc
34. ✅ Kiểm thử tích hợp với database khi xóa thuốc
35. ✅ Kiểm thử tích hợp với database khi tìm kiếm thuốc
36. ✅ Kiểm thử tích hợp với database khi phân trang danh sách thuốc

#### 2.3. Kiểm thử tích hợp API (4 testcase) - Hoàn thành
37. ✅ Kiểm thử tích hợp API thêm thuốc với multipart/form-data
38. ✅ Kiểm thử tích hợp API cập nhật thuốc với multipart/form-data
39. ✅ Kiểm thử tích hợp API tìm kiếm thuốc với nhiều tiêu chí
40. ✅ Kiểm thử tích hợp API lấy thuốc bán chạy

### 3. Kiểm thử chức năng (Functional Testing) - Bổ sung 20 testcase

#### 3.1. Kiểm thử chức năng tìm kiếm nâng cao (10 testcase)
41. Kiểm thử tìm kiếm thuốc theo khoảng giá (minGiaBan, maxGiaBan)
42. Kiểm thử tìm kiếm thuốc theo loại thuốc
43. Kiểm thử tìm kiếm thuốc theo nhà sản xuất
44. Kiểm thử tìm kiếm thuốc theo danh mục thuốc
45. Kiểm thử tìm kiếm thuốc theo đối tượng sử dụng
46. Kiểm thử tìm kiếm thuốc theo trạng thái
47. Kiểm thử tìm kiếm thuốc kết hợp nhiều tiêu chí
48. Kiểm thử tìm kiếm thuốc với kết quả trống
49. Kiểm thử tìm kiếm thuốc với từ khóa đặc biệt (có dấu, ký tự đặc biệt)
50. Kiểm thử tìm kiếm thuốc với phân trang

#### 3.2. Kiểm thử quản lý loại thuốc (5 testcase)
51. Kiểm thử thêm loại thuốc thành công
52. Kiểm thử thêm loại thuốc với tên đã tồn tại
53. Kiểm thử cập nhật loại thuốc thành công
54. Kiểm thử xóa loại thuốc thành công
55. Kiểm thử xóa loại thuốc đang được sử dụng bởi thuốc

#### 3.3. Kiểm thử quản lý danh mục thuốc (5 testcase)
56. Kiểm thử thêm danh mục thuốc thành công
57. Kiểm thử thêm danh mục thuốc với tên đã tồn tại
58. Kiểm thử cập nhật danh mục thuốc thành công
59. Kiểm thử xóa danh mục thuốc thành công
60. Kiểm thử xóa danh mục thuốc đang được sử dụng bởi loại thuốc



### 4. Kiểm thử giao diện (UI Testing) - Bổ sung 10 testcase

#### 4.1. Kiểm thử responsive (3 testcase)
61. Kiểm thử responsive trên màn hình điện thoại (width < 576px)
62. Kiểm thử responsive trên màn hình tablet (width 768px - 992px)
63. Kiểm thử responsive trên màn hình desktop lớn (width > 1200px)

#### 4.2. Kiểm thử accessibility (3 testcase)
64. Kiểm thử accessibility với keyboard navigation
65. Kiểm thử accessibility với screen reader
66. Kiểm thử accessibility với high contrast mode

#### 4.3. Kiểm thử giao diện nâng cao (4 testcase)
67. Kiểm thử hiển thị thông báo lỗi inline
68. Kiểm thử hiển thị tooltip khi hover
69. Kiểm thử hiển thị loading spinner khi tải dữ liệu
70. Kiểm thử hiển thị modal xác nhận khi xóa

### 5. Kiểm thử hệ thống (System Testing) - Bổ sung 16 testcase

#### 5.1. Kiểm thử bảo mật (5 testcase)
71. Kiểm thử bảo mật - SQL Injection trong tìm kiếm thuốc
72. Kiểm thử bảo mật - XSS trong mô tả thuốc
73. Kiểm thử bảo mật - CSRF khi thêm/sửa thuốc
74. Kiểm thử bảo mật - Authentication bypass
75. Kiểm thử bảo mật - Unauthorized access

#### 5.2. Kiểm thử hiệu năng (5 testcase)
76. Kiểm thử hiệu năng tải trang với 100 thuốc
77. Kiểm thử hiệu năng tải trang với 1,000 thuốc
78. Kiểm thử hiệu năng tải trang với 10,000 thuốc
79. Kiểm thử hiệu năng tìm kiếm với 10,000 thuốc
80. Kiểm thử hiệu năng phân trang với 10,000 thuốc

#### 5.3. Kiểm thử khả năng chịu lỗi (3 testcase)
81. Kiểm thử khả năng chịu lỗi khi mất kết nối database
82. Kiểm thử khả năng chịu lỗi khi dịch vụ upload ảnh không khả dụng
83. Kiểm thử khả năng chịu lỗi khi hệ thống file không khả dụng

#### 5.4. Kiểm thử tương thích (3 testcase)
84. Kiểm thử tương thích trên Firefox
85. Kiểm thử tương thích trên Safari
86. Kiểm thử tương thích trên Opera

## 📝 KIỂM THỬ HỘP ĐEN VÀ HỘP TRẮNG BỔ SUNG

### 6. Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên - Bổ sung 15 testcase

87. Kiểm thử thêm thuốc với tên thuốc = 1 ký tự (biên dưới)
88. Kiểm thử thêm thuốc với tên thuốc = 2 ký tự (biên dưới + 1)
89. Kiểm thử thêm thuốc với tên thuốc = 99 ký tự (biên trên - 1)
90. Kiểm thử thêm thuốc với tên thuốc = 100 ký tự (biên trên)
91. Kiểm thử thêm thuốc với tên thuốc = 101 ký tự (biên trên + 1)
92. Kiểm thử thêm thuốc với giá nhập = 0 (biên dưới)
93. Kiểm thử thêm thuốc với giá nhập = -1 (biên dưới - 1)
94. Kiểm thử thêm thuốc với giá nhập = 999999999 (biên trên)
95. Kiểm thử thêm thuốc với giá nhập = 1000000000 (biên trên + 1)
96. Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại (biên dưới)
97. Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại - 1 ngày (biên dưới - 1)
98. Kiểm thử thêm thuốc với hạn sử dụng = ngày hiện tại + 1 ngày (biên dưới + 1)
99. Kiểm thử thêm thuốc với hạn sử dụng = 10 năm sau (biên trên)
100. Kiểm thử thêm thuốc với hạn sử dụng = 10 năm + 1 ngày sau (biên trên + 1)
101. Kiểm thử thêm thuốc với số lượng = 2147483647 (Integer.MAX_VALUE)

### 7. Kiểm thử hộp đen - Bảng quyết định - Bổ sung 10 testcase

102. Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)
103. Kiểm thử thêm thuốc với (tên không hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)
104. Kiểm thử thêm thuốc với (tên hợp lệ, mã không hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)
105. Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập không hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)
106. Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán không hợp lệ, hạn sử dụng hợp lệ)
107. Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng không hợp lệ)
108. Kiểm thử thêm thuốc với (tên không hợp lệ, mã không hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng hợp lệ)
109. Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập không hợp lệ, giá bán không hợp lệ, hạn sử dụng hợp lệ)
110. Kiểm thử thêm thuốc với (tên hợp lệ, mã hợp lệ, giá nhập hợp lệ, giá bán hợp lệ, hạn sử dụng không hợp lệ, loại thuốc không tồn tại)
111. Kiểm thử thêm thuốc với (tên không hợp lệ, mã không hợp lệ, giá nhập không hợp lệ, giá bán không hợp lệ, hạn sử dụng không hợp lệ)

### 8. Kiểm thử hộp đen - Kiểm thử trạng thái - Bổ sung 6 testcase

112. Kiểm thử chuyển trạng thái thuốc từ "Còn hàng" sang "Sắp hết hàng" khi số lượng < nguongCanhBao
113. Kiểm thử chuyển trạng thái thuốc từ "Sắp hết hàng" sang "Hết hàng" khi số lượng = 0
114. Kiểm thử chuyển trạng thái thuốc từ "Hết hàng" sang "Còn hàng" khi nhập thêm hàng
115. Kiểm thử chuyển trạng thái thuốc từ "Còn hạn" sang "Sắp hết hạn" khi còn 30 ngày
116. Kiểm thử chuyển trạng thái thuốc từ "Sắp hết hạn" sang "Hết hạn" khi đến ngày hết hạn
117. Kiểm thử chuyển trạng thái thuốc từ "Hết hạn" sang "Còn hạn" khi cập nhật hạn sử dụng mới

### 9. Kiểm thử hộp trắng - Kiểm thử đường dẫn - Bổ sung 10 testcase

118. Kiểm thử đường dẫn trong phương thức create() khi tất cả điều kiện đều true
119. Kiểm thử đường dẫn trong phương thức create() khi điều kiện kiểm tra mã thuốc đã tồn tại là true
120. Kiểm thử đường dẫn trong phương thức create() khi điều kiện kiểm tra tên thuốc hợp lệ là false
121. Kiểm thử đường dẫn trong phương thức update() khi tất cả điều kiện đều true
122. Kiểm thử đường dẫn trong phương thức update() khi điều kiện kiểm tra ID thuốc tồn tại là false
123. Kiểm thử đường dẫn trong phương thức update() khi điều kiện kiểm tra mã thuốc đã tồn tại là true
124. Kiểm thử đường dẫn trong phương thức delete() khi điều kiện kiểm tra ID thuốc tồn tại là true
125. Kiểm thử đường dẫn trong phương thức delete() khi điều kiện kiểm tra ID thuốc tồn tại là false
126. Kiểm thử đường dẫn trong phương thức search() với nhiều điều kiện tìm kiếm
127. Kiểm thử đường dẫn trong phương thức validateThuoc() với các nhánh điều kiện khác nhau

## 📊 TỔNG HỢP TESTCASE

| Loại kiểm thử | Hiện có | Đã bổ sung | Cần bổ sung thêm | Tổng cộng |
|---------------|---------|------------|-----------------|-----------|
| Kiểm thử đơn vị | 18 | 23 | 2 | 43 |
| Kiểm thử tích hợp | 12 | 15 | 0 | 27 |
| Kiểm thử chức năng | 16 | 0 | 20 | 36 |
| Kiểm thử giao diện | 10 | 0 | 10 | 20 |
| Kiểm thử hệ thống | 8 | 0 | 16 | 24 |
| Kiểm thử hộp đen - Phân vùng tương đương và Phân tích giá trị biên | 0 | 0 | 15 | 15 |
| Kiểm thử hộp đen - Bảng quyết định | 0 | 0 | 10 | 10 |
| Kiểm thử hộp đen - Kiểm thử trạng thái | 0 | 0 | 6 | 6 |
| Kiểm thử hộp trắng - Kiểm thử đường dẫn | 0 | 0 | 10 | 10 |
| **Tổng cộng** | **64** | **38** | **89** | **191** |

## 🚀 KẾ HOẠCH TRIỂN KHAI

### Giai đoạn 1: Chuẩn bị (1 ngày)
- Phân tích các testcase hiện có
- Xác định các testcase cần bổ sung
- Chuẩn bị môi trường kiểm thử

### Giai đoạn 2: Triển khai kiểm thử đơn vị và tích hợp (2 ngày)
- Triển khai 25 testcase kiểm thử đơn vị (Đã hoàn thành 23/25 testcase)
- Triển khai 15 testcase kiểm thử tích hợp (Đã hoàn thành 15/15 testcase)

### Giai đoạn 3: Triển khai kiểm thử chức năng và giao diện (2 ngày)
- Triển khai 20 testcase kiểm thử chức năng
- Triển khai 10 testcase kiểm thử giao diện

### Giai đoạn 4: Triển khai kiểm thử hệ thống (1 ngày)
- Triển khai 16 testcase kiểm thử hệ thống

### Giai đoạn 5: Triển khai kiểm thử hộp đen và hộp trắng (2 ngày)
- Triển khai 31 testcase kiểm thử hộp đen
- Triển khai 10 testcase kiểm thử hộp trắng

### Giai đoạn 6: Tổng hợp và báo cáo (1 ngày)
- Tổng hợp kết quả kiểm thử
- Viết báo cáo kiểm thử
- Cập nhật tài liệu testcase

## 📝 LƯU Ý QUAN TRỌNG

1. Kế hoạch này dựa trên các testcase đã xây dựng làm cơ sở, từ đó bổ sung thêm các testcase mới.
2. Số lượng testcase có thể điều chỉnh trong quá trình triển khai để phù hợp với thực tế.
3. Ưu tiên triển khai các testcase quan trọng trước, sau đó mới đến các testcase ít quan trọng hơn.
4. Đảm bảo các testcase mới không trùng lặp với các testcase đã có.
5. Cập nhật tài liệu testcase sau mỗi giai đoạn triển khai.
