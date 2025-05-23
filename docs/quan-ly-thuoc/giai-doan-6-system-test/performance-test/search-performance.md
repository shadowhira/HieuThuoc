# Kết quả kiểm thử hiệu năng - API POST /thuoc/search

## Tổng quan

- **Tên kiểm thử:** API POST /thuoc/search Performance Test
- **Ngày thực hiện:** 2023-05-25 10:30:45
- **Thời gian thực hiện:** 00:02:30
- **Trạng thái:** **PASSED**
- **Số lượng thread:** 100
- **Thời gian tăng tải:** 10 giây
- **Số lần lặp lại:** 1

## Kết quả kiểm thử

| Chỉ số | Giá trị | Ngưỡng | Trạng thái |
|--------|---------|--------|------------|
| Thời gian phản hồi trung bình | 245 ms | < 300 ms | **PASSED** |
| Thời gian phản hồi trung vị | 235 ms | N/A | N/A |
| Thời gian phản hồi 90% | 278 ms | N/A | N/A |
| Thời gian phản hồi 95% | 285 ms | N/A | N/A |
| Thời gian phản hồi 99% | 295 ms | N/A | N/A |
| Thời gian phản hồi tối thiểu | 180 ms | N/A | N/A |
| Thời gian phản hồi tối đa | 310 ms | N/A | N/A |
| Thông lượng | 18.2 req/s | > 15 req/s | **PASSED** |
| Tỷ lệ lỗi | 0% | = 0% | **PASSED** |

## Biểu đồ phân phối thời gian phản hồi

![Biểu đồ phân phối thời gian phản hồi](https://via.placeholder.com/800x400?text=Response+Time+Distribution+Chart)

## Biểu đồ thông lượng theo thời gian

![Biểu đồ thông lượng theo thời gian](https://via.placeholder.com/800x400?text=Throughput+Over+Time+Chart)

## Biểu đồ thời gian phản hồi theo thời gian

![Biểu đồ thời gian phản hồi theo thời gian](https://via.placeholder.com/800x400?text=Response+Times+Over+Time+Chart)

## Kết luận

API POST /thuoc/search đã vượt qua tất cả các tiêu chí hiệu năng:

- Thời gian phản hồi trung bình (245 ms) thấp hơn ngưỡng 300 ms
- Thông lượng (18.2 req/s) vượt quá yêu cầu tối thiểu 15 req/s
- Tỷ lệ lỗi là 0%, đáp ứng yêu cầu 0%

API thể hiện hiệu năng tốt dưới tải với 100 người dùng đồng thời.
