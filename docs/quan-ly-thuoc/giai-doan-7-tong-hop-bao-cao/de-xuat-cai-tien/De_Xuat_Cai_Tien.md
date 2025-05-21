# ĐỀ XUẤT CẢI TIẾN CHỨC NĂNG QUẢN LÝ THUỐC

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Thời gian thực hiện**: 23/05/2025
- **Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc

## 📊 TỔNG QUAN ĐỀ XUẤT

Dựa trên kết quả kiểm thử và phân tích lỗi, chúng tôi đề xuất một số cải tiến cho chức năng Quản lý thuốc nhằm nâng cao chất lượng và trải nghiệm người dùng. Các đề xuất được phân loại thành hai nhóm chính: đề xuất cải tiến chức năng và đề xuất cải tiến quy trình kiểm thử.

## 📝 ĐỀ XUẤT CẢI TIẾN CHỨC NĂNG

### 1. Cải tiến tính năng

| ID | Đề xuất | Mức độ ưu tiên | Lợi ích | Độ phức tạp | Thời gian ước tính |
|----|---------|----------------|---------|-------------|-------------------|
| FE_001 | Thêm tính năng lọc thuốc theo nhiều tiêu chí hơn | Cao | Giúp người dùng tìm kiếm thuốc nhanh chóng và chính xác hơn | Trung bình | 3 ngày |
| FE_002 | Thêm tính năng xuất/nhập danh sách thuốc từ/vào file Excel | Cao | Giúp người dùng quản lý thuốc hàng loạt, tiết kiệm thời gian | Cao | 5 ngày |
| FE_003 | Thêm tính năng quét mã vạch để tìm kiếm thuốc | Trung bình | Giúp người dùng tìm kiếm thuốc nhanh chóng bằng cách quét mã vạch | Cao | 7 ngày |
| FE_004 | Thêm tính năng gợi ý thuốc tương tự | Thấp | Giúp người dùng tìm kiếm thuốc tương tự khi thuốc cần tìm không có sẵn | Trung bình | 4 ngày |
| FE_005 | Thêm tính năng theo dõi lịch sử thay đổi thuốc | Trung bình | Giúp người dùng theo dõi các thay đổi của thuốc theo thời gian | Cao | 6 ngày |

#### Chi tiết đề xuất

##### FE_001: Thêm tính năng lọc thuốc theo nhiều tiêu chí hơn

**Mô tả**: Hiện tại, chức năng tìm kiếm thuốc chỉ hỗ trợ lọc theo tên, mã, loại thuốc và nhà sản xuất. Chúng tôi đề xuất thêm các tiêu chí lọc sau:
- Lọc theo khoảng giá (từ giá - đến giá)
- Lọc theo hạn sử dụng (còn hạn, sắp hết hạn, hết hạn)
- Lọc theo số lượng tồn kho (còn hàng, sắp hết hàng, hết hàng)
- Lọc theo đối tượng sử dụng (người lớn, trẻ em, phụ nữ mang thai)

**Lợi ích**: Giúp người dùng tìm kiếm thuốc nhanh chóng và chính xác hơn, đặc biệt là khi cần tìm thuốc theo các tiêu chí cụ thể.

**Cách triển khai**:
1. Thêm các trường lọc mới vào form tìm kiếm thuốc
2. Cập nhật API tìm kiếm thuốc để hỗ trợ các tiêu chí lọc mới
3. Cập nhật giao diện hiển thị kết quả tìm kiếm

##### FE_002: Thêm tính năng xuất/nhập danh sách thuốc từ/vào file Excel

**Mô tả**: Hiện tại, người dùng phải thêm từng thuốc một, rất tốn thời gian khi cần thêm nhiều thuốc cùng lúc. Chúng tôi đề xuất thêm tính năng xuất/nhập danh sách thuốc từ/vào file Excel:
- Xuất danh sách thuốc ra file Excel theo mẫu chuẩn
- Nhập danh sách thuốc từ file Excel vào hệ thống
- Hỗ trợ cập nhật hàng loạt thông tin thuốc qua file Excel

**Lợi ích**: Giúp người dùng quản lý thuốc hàng loạt, tiết kiệm thời gian, đặc biệt là khi cần thêm nhiều thuốc cùng lúc hoặc cập nhật thông tin hàng loạt.

**Cách triển khai**:
1. Tạo mẫu file Excel chuẩn cho danh sách thuốc
2. Phát triển tính năng xuất danh sách thuốc ra file Excel
3. Phát triển tính năng nhập danh sách thuốc từ file Excel
4. Phát triển tính năng kiểm tra và xác thực dữ liệu từ file Excel

##### FE_003: Thêm tính năng quét mã vạch để tìm kiếm thuốc

**Mô tả**: Hiện tại, người dùng phải nhập mã thuốc hoặc tên thuốc để tìm kiếm, rất tốn thời gian khi cần tìm kiếm nhiều thuốc. Chúng tôi đề xuất thêm tính năng quét mã vạch để tìm kiếm thuốc:
- Sử dụng camera của thiết bị để quét mã vạch thuốc
- Tự động tìm kiếm thuốc theo mã vạch đã quét
- Hỗ trợ các loại mã vạch phổ biến (EAN-13, UPC, QR Code)

**Lợi ích**: Giúp người dùng tìm kiếm thuốc nhanh chóng bằng cách quét mã vạch, đặc biệt là khi cần tìm kiếm nhiều thuốc cùng lúc.

**Cách triển khai**:
1. Tích hợp thư viện quét mã vạch (như QuaggaJS, ZXing)
2. Phát triển giao diện quét mã vạch
3. Cập nhật API tìm kiếm thuốc để hỗ trợ tìm kiếm theo mã vạch
4. Thêm trường mã vạch vào thông tin thuốc

### 2. Cải tiến hiệu năng

| ID | Đề xuất | Mức độ ưu tiên | Lợi ích | Độ phức tạp | Thời gian ước tính |
|----|---------|----------------|---------|-------------|-------------------|
| PE_001 | Tối ưu hóa truy vấn cơ sở dữ liệu | Cao | Giảm thời gian phản hồi của API, tăng tốc độ tìm kiếm | Trung bình | 3 ngày |
| PE_002 | Thêm caching để giảm tải cho cơ sở dữ liệu | Cao | Giảm tải cho cơ sở dữ liệu, tăng tốc độ phản hồi | Trung bình | 4 ngày |
| PE_003 | Tối ưu hóa kích thước ảnh thuốc | Trung bình | Giảm thời gian tải trang, tiết kiệm băng thông | Thấp | 2 ngày |
| PE_004 | Phân trang và tải dữ liệu theo yêu cầu (lazy loading) | Cao | Giảm thời gian tải trang, tăng trải nghiệm người dùng | Trung bình | 3 ngày |

#### Chi tiết đề xuất

##### PE_001: Tối ưu hóa truy vấn cơ sở dữ liệu

**Mô tả**: Hiện tại, một số truy vấn cơ sở dữ liệu chưa được tối ưu hóa, dẫn đến thời gian phản hồi của API còn chậm, đặc biệt là khi tìm kiếm thuốc với nhiều tiêu chí. Chúng tôi đề xuất tối ưu hóa truy vấn cơ sở dữ liệu:
- Thêm index cho các trường thường xuyên được sử dụng để tìm kiếm
- Sử dụng truy vấn có điều kiện (conditional query) để tránh truy vấn không cần thiết
- Sử dụng projection để chỉ lấy các trường cần thiết
- Tối ưu hóa join query

**Lợi ích**: Giảm thời gian phản hồi của API, tăng tốc độ tìm kiếm, cải thiện trải nghiệm người dùng.

**Cách triển khai**:
1. Phân tích các truy vấn hiện tại để xác định các truy vấn cần tối ưu hóa
2. Thêm index cho các trường thường xuyên được sử dụng để tìm kiếm
3. Cập nhật các truy vấn để sử dụng các kỹ thuật tối ưu hóa
4. Kiểm tra hiệu năng trước và sau khi tối ưu hóa

### 3. Cải tiến giao diện người dùng

| ID | Đề xuất | Mức độ ưu tiên | Lợi ích | Độ phức tạp | Thời gian ước tính |
|----|---------|----------------|---------|-------------|-------------------|
| UI_001 | Cải thiện giao diện người dùng trên thiết bị di động | Cao | Tăng trải nghiệm người dùng trên thiết bị di động | Trung bình | 4 ngày |
| UI_002 | Thêm chế độ tối (Dark Mode) | Thấp | Tăng trải nghiệm người dùng, giảm mỏi mắt khi sử dụng vào ban đêm | Trung bình | 3 ngày |
| UI_003 | Cải thiện trải nghiệm người dùng khi tìm kiếm thuốc | Cao | Giúp người dùng tìm kiếm thuốc nhanh chóng và dễ dàng hơn | Trung bình | 3 ngày |
| UI_004 | Thêm biểu đồ thống kê | Trung bình | Giúp người dùng theo dõi xu hướng và phân tích dữ liệu | Cao | 5 ngày |

#### Chi tiết đề xuất

##### UI_001: Cải thiện giao diện người dùng trên thiết bị di động

**Mô tả**: Hiện tại, giao diện người dùng chưa được tối ưu hóa cho thiết bị di động, dẫn đến trải nghiệm người dùng không tốt trên các thiết bị có màn hình nhỏ. Chúng tôi đề xuất cải thiện giao diện người dùng trên thiết bị di động:
- Thiết kế lại giao diện để phù hợp với màn hình nhỏ
- Sử dụng các thành phần UI thân thiện với thiết bị di động
- Tối ưu hóa hiệu năng trên thiết bị di động

**Lợi ích**: Tăng trải nghiệm người dùng trên thiết bị di động, mở rộng khả năng tiếp cận của ứng dụng.

**Cách triển khai**:
1. Phân tích giao diện hiện tại để xác định các vấn đề trên thiết bị di động
2. Thiết kế lại giao diện để phù hợp với màn hình nhỏ
3. Cập nhật CSS và JavaScript để hỗ trợ responsive design
4. Kiểm thử trên các thiết bị di động khác nhau

### 4. Cải tiến bảo mật

| ID | Đề xuất | Mức độ ưu tiên | Lợi ích | Độ phức tạp | Thời gian ước tính |
|----|---------|----------------|---------|-------------|-------------------|
| SE_001 | Tăng cường kiểm tra quyền truy cập | Cao | Đảm bảo chỉ người dùng có quyền mới có thể thực hiện các thao tác nhạy cảm | Trung bình | 3 ngày |
| SE_002 | Thêm xác thực hai yếu tố cho các thao tác quan trọng | Trung bình | Tăng cường bảo mật cho các thao tác quan trọng | Cao | 5 ngày |
| SE_003 | Mã hóa dữ liệu nhạy cảm | Cao | Bảo vệ dữ liệu nhạy cảm khỏi các cuộc tấn công | Cao | 4 ngày |
| SE_004 | Thêm nhật ký hoạt động (audit log) | Trung bình | Theo dõi và phát hiện các hoạt động đáng ngờ | Trung bình | 3 ngày |

#### Chi tiết đề xuất

##### SE_001: Tăng cường kiểm tra quyền truy cập

**Mô tả**: Hiện tại, việc kiểm tra quyền truy cập chưa được thực hiện một cách triệt để, dẫn đến nguy cơ người dùng không có quyền vẫn có thể thực hiện các thao tác nhạy cảm. Chúng tôi đề xuất tăng cường kiểm tra quyền truy cập:
- Kiểm tra quyền truy cập ở cả frontend và backend
- Sử dụng RBAC (Role-Based Access Control) để quản lý quyền truy cập
- Giới hạn quyền truy cập theo vai trò người dùng

**Lợi ích**: Đảm bảo chỉ người dùng có quyền mới có thể thực hiện các thao tác nhạy cảm, tăng cường bảo mật cho hệ thống.

**Cách triển khai**:
1. Phân tích các thao tác nhạy cảm trong hệ thống
2. Xác định các vai trò người dùng và quyền truy cập tương ứng
3. Cập nhật frontend và backend để kiểm tra quyền truy cập
4. Kiểm thử bảo mật để đảm bảo tính hiệu quả của giải pháp

## 📝 ĐỀ XUẤT CẢI TIẾN QUY TRÌNH KIỂM THỬ

### 1. Cải tiến phương pháp kiểm thử

| ID | Đề xuất | Mức độ ưu tiên | Lợi ích | Độ phức tạp | Thời gian ước tính |
|----|---------|----------------|---------|-------------|-------------------|
| TM_001 | Áp dụng phương pháp kiểm thử dựa trên hành vi (BDD) | Cao | Cải thiện chất lượng kiểm thử, tăng cường giao tiếp giữa các bên liên quan | Trung bình | 5 ngày |
| TM_002 | Tăng cường kiểm thử an toàn thông tin | Cao | Phát hiện và khắc phục các lỗ hổng bảo mật | Cao | 7 ngày |
| TM_003 | Áp dụng kiểm thử A/B để đánh giá trải nghiệm người dùng | Trung bình | Cải thiện trải nghiệm người dùng dựa trên dữ liệu thực tế | Cao | 6 ngày |
| TM_004 | Áp dụng kiểm thử hồi quy tự động | Cao | Phát hiện sớm các lỗi hồi quy, giảm thời gian kiểm thử | Trung bình | 4 ngày |

#### Chi tiết đề xuất

##### TM_001: Áp dụng phương pháp kiểm thử dựa trên hành vi (BDD)

**Mô tả**: Hiện tại, phương pháp kiểm thử chủ yếu là kiểm thử dựa trên kịch bản (script-based testing), chưa có sự tham gia nhiều của các bên liên quan. Chúng tôi đề xuất áp dụng phương pháp kiểm thử dựa trên hành vi (BDD):
- Sử dụng ngôn ngữ Gherkin để mô tả các kịch bản kiểm thử
- Tạo các kịch bản kiểm thử dựa trên các user story
- Tăng cường giao tiếp giữa các bên liên quan (developer, tester, business analyst)

**Lợi ích**: Cải thiện chất lượng kiểm thử, tăng cường giao tiếp giữa các bên liên quan, đảm bảo kiểm thử đúng yêu cầu nghiệp vụ.

**Cách triển khai**:
1. Đào tạo nhóm về phương pháp BDD và ngôn ngữ Gherkin
2. Tạo các kịch bản kiểm thử dựa trên các user story
3. Cập nhật quy trình kiểm thử để áp dụng BDD
4. Tích hợp BDD vào quy trình CI/CD

### 2. Cải tiến công cụ kiểm thử

| ID | Đề xuất | Mức độ ưu tiên | Lợi ích | Độ phức tạp | Thời gian ước tính |
|----|---------|----------------|---------|-------------|-------------------|
| TT_001 | Sử dụng công cụ kiểm thử tự động hóa mạnh mẽ hơn | Cao | Tăng hiệu quả kiểm thử, giảm thời gian kiểm thử | Trung bình | 5 ngày |
| TT_002 | Tích hợp kiểm thử vào quy trình CI/CD | Cao | Phát hiện sớm các lỗi, đảm bảo chất lượng code | Cao | 7 ngày |
| TT_003 | Sử dụng công cụ phân tích mã nguồn tĩnh | Trung bình | Phát hiện các vấn đề tiềm ẩn trong mã nguồn | Trung bình | 4 ngày |
| TT_004 | Sử dụng công cụ kiểm thử hiệu năng tự động | Trung bình | Theo dõi và phát hiện các vấn đề hiệu năng | Trung bình | 5 ngày |

## 📝 KẾT LUẬN

Dựa trên kết quả kiểm thử và phân tích lỗi, chúng tôi đã đề xuất một số cải tiến cho chức năng Quản lý thuốc và quy trình kiểm thử. Các đề xuất này nhằm nâng cao chất lượng và trải nghiệm người dùng, đồng thời cải thiện quy trình kiểm thử để phát hiện và khắc phục lỗi sớm hơn.

Chúng tôi đề nghị ưu tiên triển khai các đề xuất có mức độ ưu tiên cao trước, sau đó là các đề xuất có mức độ ưu tiên trung bình và thấp. Việc triển khai các đề xuất này sẽ giúp cải thiện đáng kể chất lượng của chức năng Quản lý thuốc và quy trình kiểm thử.

## 📎 TÀI LIỆU LIÊN QUAN

- [Tổng hợp kết quả kiểm thử](../ket-qua-tong-hop/Tong_Hop_Ket_Qua_Kiem_Thu.md)
- [Phân tích lỗi](../phan-tich-loi/Phan_Tich_Loi.md)
