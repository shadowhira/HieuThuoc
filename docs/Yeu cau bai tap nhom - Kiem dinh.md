**YÊU CẦU BÀI TẬP NHÓM MÔN SQA**

1. **Số lượng thành viên nhóm: 4-5 sinh viên**
1. **Lựa chọn chủ đề:**

Nhóm có thể chọn một hệ thống đã xây dựng, có thể chọn theo các phương án sau:

- Hệ thống được công khai trên GIT
- Bài tập lớn của môn học khác
- Đồ án tốt nghiệp của Anh/Chị khóa trước

Hệ thống được lựa chọn cần đảm bảo tối thiểu:

- Có mã nguồn và cài đặt để chạy được
- Có đủ chức năng để phân công mỗi thành viên trong nhóm 1 chức năng (chức năng đủ phức tạp).
- Tài liệu có thể có hoặc không (nếu không có hoặc có nhưng chưa đủ thì sẽ cần bổ sung một số nội dung).
1. **Phân chia công việc:**

   ***3.1 Công việc làm chung của cả nhóm:***

   1. Lựa chọn chủ đề, 
   1. Xây dựng kế hoạch kiểm thử (sẽ có mẫu để tham khảo).
   1. Thực hiện kiểm tra checklist những tài liệu, có thể là một hoặc một số tài liệu sau: đặc tả yêu cầu/phân tích/ thiết kế (mẫu các checklist sẽ gửi).
   1. Trong trường hợp dự án không có tài liệu đặc tả yêu cầu thì nhóm thực hiện bổ sung (tối đa có thể) để làm cơ sở thực hiện việc đảm bảo chất lượng. Sẽ có mẫu đặc tả để tham khảo.Chú ý, phần đặc tả chi tiết chức năng thì chỉ cần bổ sung đối với các chức năng mà thành viên trong nhóm lựa chọn để thực hiện phần việc cá nhân.
   1. Xây dựng báo cáo kết quả kiểm thử (có khung nội dung phía sau):
      1. Phần chung của nhóm.
      1. Phần của từng cá nhân.

***3.2 Công việc làm từng cá nhân:***

1. Mỗi cá nhận lựa chọn 1 chức năng (hoặc một nhóm chức năng, nhưng phải cùng chuỗi nghiệp vụ liên quan) để thực hiện việc đảm bảo chất lượng. Yêu cầu chức năng được chọn cần đủ phức tạp.
1. Thực hiện review cụ thể tài liệu đặc tả phần chức năng mà cá nhân lựa chọn. 
1. Thực hiện review code phần chức năng của cá nhân lựa chọn.
1. Thực hiện xây dựng test case và thực hiện test bao gồm:
   1. Kiểm thử giao diện
   1. Kiểm thử đơn vị: có thể chỉ cần thực hiện một phần chức năng.
   1. Kiểm thử hộp đen.
   1. Nội dung lựa chọn thêm (không bắt buộc): kiểm thử tự động, áp dụng công cụ AI vào kiểm thử, kiểm thử hiệu năng,…
1. Đánh giá kết quả kiểm thử và lập báo cáo phần cá nhân (để ghép chung vào báo cáo nhóm)
1. **Sản phẩm nộp và trình bày**

Nhóm cần nộp các sản phẩm sau 

- <a name="ole_link1"></a><a name="ole_link2"></a>Kế hoạch kiểm thử
- Báo cáo kết quả kiểm thử (tổng hợp cả nhóm)
- Tài liệu minh chứng kèm theo, có thể bao gồm:
  - Các tài liệu phần mềm đã có trước đây hoặc tài liệu mà nhóm bổ sung (ví dụ dự án không có tài liệu đặc tả thì nhóm làm bổ sung).
  - Mã nguồn hoặc đường link đến GIT…. 
  - Sql plan, test plan
  - System test (black boc),unit test (white boxc)
- BE:
  - Unit test cho services
  - Intergration test cho controller
- FE:
  - Unit test cho services
  - Unit test cho components
1. **Thời hạn:** 
   - Đại diện nhóm nộp lên thư mục GG Driver thầy sẽ gửi sau. Cách thực đặt tên file, tên thư mục thầy sẽ hướng dẫn sau. 
   - Thời gian: Thầy sẽ nhắc lịch chính xác.

**Lưu ý:** một số nội dung khi kiểm thử ứng dụng web và ứng dụng app mobile có thể khác nhau, nên các nhóm tùy thuộc công việc của nhóm để thực hiện cho phù hợp nhất.



**BỐ CỤC BÁO CÁO BÀI TẬP NHÓM**

1. **Trang bìa:** 
- Tên báo cáo “BÁO CÁO BÀI TẬP DỰ ÁN NHÓM MÔN ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM”
- Số thứ tự nhóm
- Tên chủ đề của nhóm
- Danh sách thành viên nhóm và ghi rõ thành viên đó đảm nhiệm đảm bảo chất lượng chức năng nào
1. **Phần 1 – Công việc chung của nhóm**
1. ***Mô tả hệ thống của nhóm***
- Giới thiệu về hệ thống: sản phẩm từ đâu, đường link,..
- Công nghệ được sử dụng
- Các chức năng chính của hệ thống
- Hiện trạng đảm bảo chất lượng của hệ thống (có tài liệu gì, đã được kiểm thử hay chưa,…).
1. ***Kết quả thực hiện rà soát theo checklist***
1. **Phần 2 – Kết quả từng thành viên**
   1. ***Nguyễn Văn A (thực hiện chức năng……………………………..)***
- Kết quả thực hiện review cụ thể tài liệu đặc tả phần chức năng mà cá nhân lựa chọn. 
- Kết quả thực hiện review code phần chức năng của cá nhân lựa chọn.
- Kết quả thực hiện xây dựng test case và thực hiện test bao gồm:
  1. Kiểm thử giao diện
  1. Kiểm thử đơn vị: có thể chỉ cần thực hiện một phần chức năng.
  1. Kiểm thử hộp đen.
  1. Nội dung lựa chọn thêm (không bắt buộc): kiểm thử tự động, áp dụng công cụ AI vào kiểm thử, kiểm thử hiệu năng,…


***3.2 Nguyễn Văn B (thực hiện chức năng……………………………..)***

- Kết quả thực hiện review cụ thể tài liệu đặc tả phần chức năng mà cá nhân lựa chọn. 
- Kết quả thực hiện review code phần chức năng của cá nhân lựa chọn.
- Kết quả thực hiện xây dựng test case và thực hiện test bao gồm:
  1. Kiểm thử giao diện
  1. Kiểm thử đơn vị: có thể chỉ cần thực hiện một phần chức năng.
  1. Kiểm thử hộp đen.
  1. Nội dung lựa chọn thêm (không bắt buộc): kiểm thử tự động, áp dụng công cụ AI vào kiểm thử, kiểm thử hiệu năng,…

