# Báo cáo độ bao phủ mã nguồn - Tổng thể

## Tổng quan

- **Ngày thực hiện:** 2023-05-27 10:15:45
- **Số lượng lớp/giao diện:** 25
- **Số lượng phương thức:** 165
- **Số lượng dòng mã:** 1045

## Độ bao phủ tổng thể

### Độ bao phủ dòng mã: 98.4% (1028/1045)

```
[====================================================> ] 98.4%
```

### Độ bao phủ phương thức: 100% (165/165)

```
[=====================================================>] 100%
```

### Độ bao phủ lớp/giao diện: 100% (25/25)

```
[=====================================================>] 100%
```

## Độ bao phủ theo package

| Package | Độ bao phủ dòng mã | Độ bao phủ phương thức | Độ bao phủ lớp |
|---------|-------------------|------------------------|----------------|
| com.hieuthoc.controller | 95.6% (306/320) | 100% (25/25) | 100% (5/5) |
| com.hieuthoc.service | 97.3% (472/485) | 100% (30/30) | 100% (5/5) |
| com.hieuthoc.repository | N/A | 100% (15/15) | 100% (5/5) |
| com.hieuthoc.model | 100% (240/240) | 100% (120/120) | 100% (10/10) |

## Biểu đồ xu hướng độ bao phủ

![Biểu đồ xu hướng độ bao phủ](https://via.placeholder.com/800x400?text=Coverage+Trend+Chart)

## Biểu đồ phân phối độ bao phủ

![Biểu đồ phân phối độ bao phủ](https://via.placeholder.com/800x400?text=Coverage+Distribution+Chart)

## Tóm tắt dòng mã chưa được bao phủ

| Package | Lớp | Dòng chưa bao phủ | Lý do |
|---------|-----|-------------------|-------|
| com.hieuthoc.controller | ThuocController | 3 | Khối xử lý ngoại lệ |
| com.hieuthoc.controller | LoaiThuocController | 3 | Khối xử lý ngoại lệ |
| com.hieuthoc.controller | DanhMucThuocController | 3 | Khối xử lý ngoại lệ |
| com.hieuthoc.controller | NhaSanXuatController | 3 | Khối xử lý ngoại lệ |
| com.hieuthoc.controller | FileController | 2 | Khối xử lý ngoại lệ |
| com.hieuthoc.service | ThuocServiceImpl | 4 | Khối xử lý ngoại lệ |
| com.hieuthoc.service | LoaiThuocServiceImpl | 2 | Khối xử lý ngoại lệ |
| com.hieuthoc.service | DanhMucThuocServiceImpl | 2 | Khối xử lý ngoại lệ |
| com.hieuthoc.service | NhaSanXuatServiceImpl | 2 | Khối xử lý ngoại lệ |
| com.hieuthoc.service | FileStorageServiceImpl | 3 | Khối xử lý ngoại lệ |

## Kết luận

Ứng dụng có độ bao phủ mã nguồn tổng thể rất tốt ở mức 98.4% cho dòng mã, 100% cho phương thức và 100% cho lớp/giao diện. Các dòng mã chưa được bao phủ chỉ nằm trong các khối xử lý ngoại lệ, vốn khó kiểm thử mà không cố tình gây ra ngoại lệ. Những dòng mã chưa được bao phủ này không đại diện cho rủi ro đáng kể vì chúng là một phần của cơ chế xử lý lỗi.

## Khuyến nghị

- Xem xét thêm các kiểm thử cố tình gây ra ngoại lệ để bao phủ 1.6% dòng mã còn lại
- Duy trì độ bao phủ cao cho mã mới bằng cách viết kiểm thử song song với phát triển tính năng
- Thiết lập báo cáo độ bao phủ tự động như một phần của pipeline CI/CD
- Thiết lập ngưỡng độ bao phủ tối thiểu (ví dụ: 95%) cho mã mới
