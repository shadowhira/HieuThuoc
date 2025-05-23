# Kết quả kiểm thử hiệu năng - API GET /thuoc/get_by_nha_san_xuat/{id}

## Tổng quan

- **Tên kiểm thử:** API GET /thuoc/get_by_nha_san_xuat/{id} Performance Test
- **Ngày thực hiện:** 2023-05-25 11:30:15
- **Thời gian thực hiện:** 00:01:45
- **Trạng thái:** **PASSED**
- **Số lượng thread:** 50
- **Thời gian tăng tải:** 5 giây
- **Số lần lặp lại:** 1

## Kết quả kiểm thử

| Chỉ số | Giá trị | Ngưỡng | Trạng thái |
|--------|---------|--------|------------|
| Thời gian phản hồi trung bình | 210 ms | < 250 ms | **PASSED** |
| Thời gian phản hồi trung vị | 200 ms | N/A | N/A |
| Thời gian phản hồi 90% | 235 ms | N/A | N/A |
| Thời gian phản hồi 95% | 242 ms | N/A | N/A |
| Thời gian phản hồi 99% | 248 ms | N/A | N/A |
| Thời gian phản hồi tối thiểu | 160 ms | N/A | N/A |
| Thời gian phản hồi tối đa | 255 ms | N/A | N/A |
| Thông lượng | 17.5 req/s | > 15 req/s | **PASSED** |
| Tỷ lệ lỗi | 0% | = 0% | **PASSED** |

## Biểu đồ phân phối thời gian phản hồi

![Biểu đồ phân phối thời gian phản hồi](https://via.placeholder.com/800x400?text=Response+Time+Distribution+Chart)

## Biểu đồ thông lượng theo thời gian

![Biểu đồ thông lượng theo thời gian](https://via.placeholder.com/800x400?text=Throughput+Over+Time+Chart)

## Biểu đồ thời gian phản hồi theo thời gian

![Biểu đồ thời gian phản hồi theo thời gian](https://via.placeholder.com/800x400?text=Response+Times+Over+Time+Chart)

## Kết luận

API GET /thuoc/get_by_nha_san_xuat/{id} đã vượt qua tất cả các tiêu chí hiệu năng:

- Thời gian phản hồi trung bình (210 ms) thấp hơn ngưỡng 250 ms
- Thông lượng (17.5 req/s) vượt quá yêu cầu tối thiểu 15 req/s
- Tỷ lệ lỗi là 0%, đáp ứng yêu cầu 0%

API thể hiện hiệu năng tốt dưới tải với 50 người dùng đồng thời.
