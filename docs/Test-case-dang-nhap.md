# TEST CASE CHI TIẾT: CHỨC NĂNG ĐĂNG NHẬP VÀ QUẢN LÝ TÀI KHOẢN

## 1. Thông tin chung

| Thông tin | Chi tiết                               |
| --------- | -------------------------------------- |
| Dự án     | Hệ thống web bán và quản lý hiệu thuốc |
| Module    | Quản lý người dùng                     |
| Chức năng | Đăng nhập và quản lý tài khoản         |
| Người tạo | Nhóm SQA                               |
| Ngày tạo  | 15/07/2024                             |
| Phiên bản | 1.0                                    |

## 2. Các test case đăng nhập

### TC1: Đăng nhập với thông tin hợp lệ

| ID  | Tên test case                             | Mô tả                                                                     | Dữ liệu đầu vào                                 | Các bước thực hiện                                                                                                | Kỳ vọng                                                                                               |
| :-- | :---------------------------------------- | :------------------------------------------------------------------------ | :---------------------------------------------- | :---------------------------------------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------- |
| TC1 | Người dùng đăng nhập với thông tin hợp lệ | Kiểm tra chức năng đăng nhập khi người dùng nhập đúng thông tin tài khoản | - Tên đăng nhập: admin<br>- Mật khẩu: Admin@123 | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "admin"<br>3. Nhập mật khẩu "Admin@123"<br>4. Nhấn nút "Đăng nhập" | - Đăng nhập thành công<br>- Chuyển hướng đến trang chủ<br>- Hiển thị thông báo "Đăng nhập thành công" |

### TC2: Đăng nhập với tên đăng nhập sai

| ID  | Tên test case                   | Mô tả                                                              | Dữ liệu đầu vào                                                    | Các bước thực hiện                                                                                                   | Kỳ vọng                                                                                                              |
| :-- | :------------------------------ | :----------------------------------------------------------------- | :----------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------- |
| TC2 | Đăng nhập với tên đăng nhập sai | Kiểm tra chức năng đăng nhập khi người dùng nhập sai tên đăng nhập | - Tên đăng nhập: admin123 (không tồn tại)<br>- Mật khẩu: Admin@123 | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "admin123"<br>3. Nhập mật khẩu "Admin@123"<br>4. Nhấn nút "Đăng nhập" | - Đăng nhập thất bại<br>- Hiển thị thông báo lỗi "Tên đăng nhập hoặc mật khẩu không đúng"<br>- Vẫn ở trang đăng nhập |

### TC3: Đăng nhập với mật khẩu sai

| ID  | Tên test case              | Mô tả                                                         | Dữ liệu đầu vào                                     | Các bước thực hiện                                                                                                    | Kỳ vọng                                                                                                              |
| :-- | :------------------------- | :------------------------------------------------------------ | :-------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------- |
| TC3 | Đăng nhập với mật khẩu sai | Kiểm tra chức năng đăng nhập khi người dùng nhập sai mật khẩu | - Tên đăng nhập: admin<br>- Mật khẩu: wrongpassword | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "admin"<br>3. Nhập mật khẩu "wrongpassword"<br>4. Nhấn nút "Đăng nhập" | - Đăng nhập thất bại<br>- Hiển thị thông báo lỗi "Tên đăng nhập hoặc mật khẩu không đúng"<br>- Vẫn ở trang đăng nhập |

### TC4: Đăng nhập tài khoản bị khóa

| ID  | Tên test case               | Mô tả                                                                          | Dữ liệu đầu vào                                          | Các bước thực hiện                                                                                                         | Kỳ vọng                                                                                                                                    |
| :-- | :-------------------------- | :----------------------------------------------------------------------------- | :------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------- |
| TC4 | Đăng nhập tài khoản bị khóa | Kiểm tra chức năng đăng nhập khi người dùng đăng nhập vào tài khoản đã bị khóa | - Tên đăng nhập: locked_user<br>- Mật khẩu: Password@123 | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "locked_user"<br>3. Nhập mật khẩu "Password@123"<br>4. Nhấn nút "Đăng nhập" | - Đăng nhập thất bại<br>- Hiển thị thông báo lỗi "Tài khoản của bạn đã bị khóa. Vui lòng liên hệ quản trị viên"<br>- Vẫn ở trang đăng nhập |

### TC5: Để trống tên đăng nhập

| ID  | Tên test case          | Mô tả                                                              | Dữ liệu đầu vào                                   | Các bước thực hiện                                                                                                   | Kỳ vọng                                                                                                   |
| :-- | :--------------------- | :----------------------------------------------------------------- | :------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------- |
| TC5 | Để trống tên đăng nhập | Kiểm tra chức năng đăng nhập khi người dùng để trống tên đăng nhập | - Tên đăng nhập: (trống)<br>- Mật khẩu: Admin@123 | 1. Mở trang đăng nhập<br>2. Để trống trường tên đăng nhập<br>3. Nhập mật khẩu "Admin@123"<br>4. Nhấn nút "Đăng nhập" | - Đăng nhập thất bại<br>- Hiển thị thông báo lỗi "Vui lòng nhập tên đăng nhập"<br>- Vẫn ở trang đăng nhập |

### TC6: Để trống mật khẩu

| ID  | Tên test case     | Mô tả                                                         | Dữ liệu đầu vào                               | Các bước thực hiện                                                                                               | Kỳ vọng                                                                                              |
| :-- | :---------------- | :------------------------------------------------------------ | :-------------------------------------------- | :--------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------- |
| TC6 | Để trống mật khẩu | Kiểm tra chức năng đăng nhập khi người dùng để trống mật khẩu | - Tên đăng nhập: admin<br>- Mật khẩu: (trống) | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "admin"<br>3. Để trống trường mật khẩu<br>4. Nhấn nút "Đăng nhập" | - Đăng nhập thất bại<br>- Hiển thị thông báo lỗi "Vui lòng nhập mật khẩu"<br>- Vẫn ở trang đăng nhập |

### TC7: Nhập mã SQL Injection

| ID  | Tên test case         | Mô tả                                              | Dữ liệu đầu vào                                           | Các bước thực hiện                                                                                                          | Kỳ vọng                                                                                                              |
| :-- | :-------------------- | :------------------------------------------------- | :-------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------- |
| TC7 | Nhập mã SQL Injection | Kiểm tra khả năng chống SQL Injection của hệ thống | - Tên đăng nhập: admin' OR '1'='1<br>- Mật khẩu: anything | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "admin' OR '1'='1"<br>3. Nhập mật khẩu "anything"<br>4. Nhấn nút "Đăng nhập" | - Đăng nhập thất bại<br>- Hiển thị thông báo lỗi "Tên đăng nhập hoặc mật khẩu không đúng"<br>- Vẫn ở trang đăng nhập |

### TC8: Bảo mật mật khẩu

| ID  | Tên test case    | Mô tả                                                  | Dữ liệu đầu vào                                 | Các bước thực hiện                                                                                                                             | Kỳ vọng                                                              |
| :-- | :--------------- | :----------------------------------------------------- | :---------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------- |
| TC8 | Bảo mật mật khẩu | Kiểm tra xem mật khẩu có bị hiển thị rõ khi nhập không | - Tên đăng nhập: admin<br>- Mật khẩu: Admin@123 | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "admin"<br>3. Nhập mật khẩu "Admin@123"<br>4. Kiểm tra hiển thị của ký tự trong trường mật khẩu | - Ký tự mật khẩu hiển thị dưới dạng dấu \* hoặc •, không hiển thị rõ |

### TC9: Giới hạn số lần đăng nhập sai

| ID  | Tên test case            | Mô tả                                            | Dữ liệu đầu vào                                                        | Các bước thực hiện                                                                                                                                  | Kỳ vọng                                                                                              |
| :-- | :----------------------- | :----------------------------------------------- | :--------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------- |
| TC9 | Giới hạn số lần nhập sai | Người dùng nhập sai mật khẩu quá số lần cho phép | - Tên đăng nhập: admin<br>- Mật khẩu: wrong_password (5 lần liên tiếp) | 1. Mở trang đăng nhập<br>2. Nhập tên đăng nhập "admin"<br>3. Nhập mật khẩu "wrong_password" 5 lần liên tiếp<br>4. Kiểm tra thông báo khóa tài khoản | - Hệ thống khóa tài khoản và hiển thị thông báo "Tài khoản của bạn đã bị khóa do nhập sai nhiều lần" |

## 3. Các test case đổi mật khẩu

### TC10: Hiển thị màn hình đổi mật khẩu

| ID   | Tên test case                  | Mô tả                                                                                                                 | Dữ liệu đầu vào | Các bước thực hiện                                                                       | Kỳ vọng                                                                              |
| :--- | :----------------------------- | :-------------------------------------------------------------------------------------------------------------------- | :-------------- | :--------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------- |
| TC10 | Hiển thị màn hình đổi mật khẩu | Kiểm tra khi người dùng bấm chọn mục "Cá nhân" và nhấn nút "đổi mật khẩu" thì hệ thống hiển thị màn hình đổi mật khẩu | N/A             | 1. Đăng nhập vào hệ thống<br>2. Nhấp vào tab "Cá nhân"<br>3. Nhấp vào nút "đổi mật khẩu" | Màn hình nhập "Mật khẩu cũ" và "Mật khẩu mới" hiển thị đúng và sẵn sàng để nhập liệu |

### TC11: Nhập đúng mật khẩu cũ và mật khẩu mới

| ID   | Tên test case                         | Mô tả                                                                                                             | Dữ liệu đầu vào                                         | Các bước thực hiện                                                                                                     | Kỳ vọng                                                                         |
| :--- | :------------------------------------ | :---------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------ | :--------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------ |
| TC11 | Nhập đúng mật khẩu cũ và mật khẩu mới | Kiểm tra khi người dùng nhập đúng mật khẩu cũ và mật khẩu mới hợp lệ (theo tiêu chí: ≥8 ký tự, gồm số và chữ cái) | Mật khẩu cũ: "Admin@123"<br>Mật khẩu mới: "NewPass@123" | 1. Thực hiện bước 1-3 của Test Case 10<br>2. Nhập đúng mật khẩu cũ<br>3. Nhập mật khẩu mới hợp lệ<br>4. Nhấn nút "Lưu" | Mật khẩu được thay đổi thành công. Thông báo "Đổi mật khẩu thành công" hiển thị |

### TC12: Nhập sai mật khẩu cũ

| ID   | Tên test case        | Mô tả                                        | Dữ liệu đầu vào                                             | Các bước thực hiện                                                                                             | Kỳ vọng                                                    |
| :--- | :------------------- | :------------------------------------------- | :---------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------- |
| TC12 | Nhập sai mật khẩu cũ | Kiểm tra khi người dùng nhập sai mật khẩu cũ | Mật khẩu cũ: "WrongPassword"<br>Mật khẩu mới: "NewPass@123" | 1. Thực hiện bước 1-3 của Test Case 10<br>2. Nhập sai mật khẩu cũ<br>3. Nhập mật khẩu mới<br>4. Nhấn nút "Lưu" | Thông báo lỗi: "Mật khẩu cũ không đúng. Vui lòng thử lại." |

### TC13: Mật khẩu mới không hợp lệ

| ID   | Tên test case             | Mô tả                                                                                                                     | Dữ liệu đầu vào                                 | Các bước thực hiện                                                                                                           | Kỳ vọng                                                                                                          |
| :--- | :------------------------ | :------------------------------------------------------------------------------------------------------------------------ | :---------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------------------- |
| TC13 | Mật khẩu mới không hợp lệ | Kiểm tra khi người dùng nhập mật khẩu mới không thỏa mãn tiêu chí hợp lệ (dưới 8 ký tự, không có số, hoặc ký tự đặc biệt) | Mật khẩu cũ: "Admin@123"<br>Mật khẩu mới: "123" | 1. Thực hiện bước 1-3 của Test Case 10<br>2. Nhập đúng mật khẩu cũ<br>3. Nhập mật khẩu mới không hợp lệ<br>4. Nhấn nút "Lưu" | Thông báo lỗi: "Mật khẩu mới không hợp lệ. Vui lòng nhập mật khẩu dài ít nhất 8 ký tự và chứa cả số và chữ cái." |

### TC14: Trường mật khẩu mới để trống

| ID   | Tên test case                | Mô tả                                           | Dữ liệu đầu vào                                   | Các bước thực hiện                                                                                                           | Kỳ vọng                                                                        |
| :--- | :--------------------------- | :---------------------------------------------- | :------------------------------------------------ | :--------------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------- |
| TC14 | Trường mật khẩu mới để trống | Kiểm tra khi người dùng không nhập mật khẩu mới | Mật khẩu cũ: "Admin@123"<br>Mật khẩu mới: (trống) | 1. Thực hiện bước 1-3 của Test Case 10<br>2. Nhập đúng mật khẩu cũ<br>3. Để trống trường "Mật khẩu mới"<br>4. Nhấn nút "Lưu" | Thông báo lỗi: "Mật khẩu mới không được để trống. Vui lòng nhập mật khẩu mới." |

### TC15: Nhập lại mật khẩu sau khi đổi thành công

| ID   | Tên test case                            | Mô tả                                                                                   | Dữ liệu đầu vào                                   | Các bước thực hiện                                                                                                  | Kỳ vọng                                           |
| :--- | :--------------------------------------- | :-------------------------------------------------------------------------------------- | :------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------ | :------------------------------------------------ |
| TC15 | Nhập lại mật khẩu sau khi đổi thành công | Kiểm tra người dùng đăng xuất và đăng nhập lại bằng mật khẩu mới sau khi đổi thành công | Tài khoản: "admin"<br>Mật khẩu mới: "NewPass@123" | 1. Thực hiện đổi mật khẩu thành công (Test Case 11)<br>2. Đăng xuất tài khoản<br>3. Đăng nhập lại bằng mật khẩu mới | Người dùng đăng nhập thành công bằng mật khẩu mới |

## 4. Các test case quên mật khẩu

### TC16: Hiển thị màn hình quên mật khẩu

| ID   | Tên test case                   | Mô tả                                                                          | Dữ liệu đầu vào | Các bước thực hiện                                            | Kỳ vọng                                               |
| :--- | :------------------------------ | :----------------------------------------------------------------------------- | :-------------- | :------------------------------------------------------------ | :---------------------------------------------------- |
| TC16 | Hiển thị màn hình quên mật khẩu | Kiểm tra khi người dùng nhấn vào liên kết "Quên mật khẩu" trên trang đăng nhập | N/A             | 1. Mở trang đăng nhập<br>2. Nhấn vào liên kết "Quên mật khẩu" | Màn hình quên mật khẩu hiển thị với trường nhập email |

### TC17: Yêu cầu đặt lại mật khẩu với email hợp lệ

| ID   | Tên test case                             | Mô tả                                                             | Dữ liệu đầu vào            | Các bước thực hiện                                                                                       | Kỳ vọng                                                                                                       |
| :--- | :---------------------------------------- | :---------------------------------------------------------------- | :------------------------- | :------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------ |
| TC17 | Yêu cầu đặt lại mật khẩu với email hợp lệ | Kiểm tra chức năng quên mật khẩu khi người dùng nhập email hợp lệ | Email: "admin@example.com" | 1. Thực hiện bước 1-2 của Test Case 16<br>2. Nhập email "admin@example.com"<br>3. Nhấn nút "Gửi yêu cầu" | Thông báo: "Một email đặt lại mật khẩu đã được gửi đến địa chỉ email của bạn. Vui lòng kiểm tra hộp thư đến." |

### TC18: Yêu cầu đặt lại mật khẩu với email không tồn tại

| ID   | Tên test case                                    | Mô tả                                                                                   | Dữ liệu đầu vào                  | Các bước thực hiện                                                                                             | Kỳ vọng                                                                     |
| :--- | :----------------------------------------------- | :-------------------------------------------------------------------------------------- | :------------------------------- | :------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------- |
| TC18 | Yêu cầu đặt lại mật khẩu với email không tồn tại | Kiểm tra chức năng quên mật khẩu khi người dùng nhập email không tồn tại trong hệ thống | Email: "nonexistent@example.com" | 1. Thực hiện bước 1-2 của Test Case 16<br>2. Nhập email "nonexistent@example.com"<br>3. Nhấn nút "Gửi yêu cầu" | Thông báo lỗi: "Email không tồn tại trong hệ thống. Vui lòng kiểm tra lại." |

### TC19: Để trống email khi yêu cầu đặt lại mật khẩu

| ID   | Tên test case                               | Mô tả                                                                 | Dữ liệu đầu vào | Các bước thực hiện                                                                              | Kỳ vọng                                       |
| :--- | :------------------------------------------ | :-------------------------------------------------------------------- | :-------------- | :---------------------------------------------------------------------------------------------- | :-------------------------------------------- |
| TC19 | Để trống email khi yêu cầu đặt lại mật khẩu | Kiểm tra chức năng quên mật khẩu khi người dùng để trống trường email | Email: (trống)  | 1. Thực hiện bước 1-2 của Test Case 16<br>2. Để trống trường email<br>3. Nhấn nút "Gửi yêu cầu" | Thông báo lỗi: "Vui lòng nhập địa chỉ email." |

### TC20: Đặt lại mật khẩu từ liên kết trong email

| ID   | Tên test case                            | Mô tả                                                                            | Dữ liệu đầu vào                                                     | Các bước thực hiện                                                                                                                                            | Kỳ vọng                                                                                 |
| :--- | :--------------------------------------- | :------------------------------------------------------------------------------- | :------------------------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------ | :-------------------------------------------------------------------------------------- |
| TC20 | Đặt lại mật khẩu từ liên kết trong email | Kiểm tra chức năng đặt lại mật khẩu khi người dùng nhấn vào liên kết trong email | Mật khẩu mới: "ResetPass@123"<br>Xác nhận mật khẩu: "ResetPass@123" | 1. Thực hiện Test Case 17<br>2. Mở email và nhấn vào liên kết đặt lại mật khẩu<br>3. Nhập mật khẩu mới và xác nhận mật khẩu<br>4. Nhấn nút "Đặt lại mật khẩu" | Thông báo: "Mật khẩu đã được đặt lại thành công. Vui lòng đăng nhập bằng mật khẩu mới." |
