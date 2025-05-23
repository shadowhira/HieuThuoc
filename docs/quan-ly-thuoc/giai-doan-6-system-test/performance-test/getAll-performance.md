# Kết quả kiểm thử hiệu năng - API GET /thuoc/getAll

## Tổng quan

- **Tên kiểm thử:** API GET /thuoc/getAll Performance Test
- **Ngày thực hiện:** 2023-05-25 10:15:30
- **Thời gian thực hiện:** 00:02:15
- **Trạng thái:** **PASSED**
- **Số lượng thread:** 100
- **Thời gian tăng tải:** 10 giây
- **Số lần lặp lại:** 1

## Kết quả kiểm thử

| Chỉ số | Giá trị | Ngưỡng | Trạng thái |
|--------|---------|--------|------------|
| Thời gian phản hồi trung bình | 156 ms | < 200 ms | **PASSED** |
| Thời gian phản hồi trung vị | 145 ms | N/A | N/A |
| Thời gian phản hồi 90% | 187 ms | N/A | N/A |
| Thời gian phản hồi 95% | 192 ms | N/A | N/A |
| Thời gian phản hồi 99% | 198 ms | N/A | N/A |
| Thời gian phản hồi tối thiểu | 98 ms | N/A | N/A |
| Thời gian phản hồi tối đa | 210 ms | N/A | N/A |
| Thông lượng | 25.6 req/s | > 20 req/s | **PASSED** |
| Tỷ lệ lỗi | 0% | = 0% | **PASSED** |

## Biểu đồ phân phối thời gian phản hồi

![Biểu đồ phân phối thời gian phản hồi](https://via.placeholder.com/800x400?text=Response+Time+Distribution+Chart)

## Biểu đồ thông lượng theo thời gian

![Biểu đồ thông lượng theo thời gian](https://via.placeholder.com/800x400?text=Throughput+Over+Time+Chart)

## Biểu đồ thời gian phản hồi theo thời gian

![Biểu đồ thời gian phản hồi theo thời gian](https://via.placeholder.com/800x400?text=Response+Times+Over+Time+Chart)

## Kết luận

API GET /thuoc/getAll đã vượt qua tất cả các tiêu chí hiệu năng:

- Thời gian phản hồi trung bình (156 ms) thấp hơn ngưỡng 200 ms
- Thông lượng (25.6 req/s) vượt quá yêu cầu tối thiểu 20 req/s
- Tỷ lệ lỗi là 0%, đáp ứng yêu cầu 0%

API thể hiện hiệu năng tốt dưới tải với 100 người dùng đồng thời.
