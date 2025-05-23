# Báo cáo độ bao phủ mã nguồn - Lớp Controller

## Tổng quan

- **Ngày thực hiện:** 2023-05-27 09:15:30
- **Số lượng lớp:** 5
- **Số lượng phương thức:** 25
- **Số lượng dòng mã:** 320

## Độ bao phủ tổng thể

### Độ bao phủ dòng mã: 95.6% (306/320)

```
[===================================================>  ] 95.6%
```

### Độ bao phủ phương thức: 100% (25/25)

```
[=====================================================>] 100%
```

### Độ bao phủ lớp: 100% (5/5)

```
[=====================================================>] 100%
```

## Độ bao phủ theo lớp

| Lớp | Độ bao phủ dòng mã | Độ bao phủ phương thức | Độ phức tạp |
|-----|-------------------|------------------------|-------------|
| ThuocController | 97.8% (134/137) | 100% (10/10) | 25 |
| LoaiThuocController | 94.2% (49/52) | 100% (5/5) | 12 |
| DanhMucThuocController | 94.2% (49/52) | 100% (5/5) | 12 |
| NhaSanXuatController | 94.2% (49/52) | 100% (5/5) | 12 |
| FileController | 92.6% (25/27) | 100% (2/2) | 6 |

## Dòng mã chưa được bao phủ

### ThuocController

```java
// Line 78: Exception handling in create method
if (e instanceof DataIntegrityViolationException) {
    return new ResponseDTO(409, "Mã thuốc đã tồn tại", null);
}

// Line 142: Exception handling in update method
logger.error("Error updating thuoc: " + e.getMessage());
```

### LoaiThuocController

```java
// Line 56: Exception handling in create method
logger.error("Error creating loai thuoc: " + e.getMessage());

// Line 89: Exception handling in update method
logger.error("Error updating loai thuoc: " + e.getMessage());

// Line 112: Exception handling in delete method
logger.error("Error deleting loai thuoc: " + e.getMessage());
```

### DanhMucThuocController

```java
// Line 56: Exception handling in create method
logger.error("Error creating danh muc thuoc: " + e.getMessage());

// Line 89: Exception handling in update method
logger.error("Error updating danh muc thuoc: " + e.getMessage());

// Line 112: Exception handling in delete method
logger.error("Error deleting danh muc thuoc: " + e.getMessage());
```

### NhaSanXuatController

```java
// Line 56: Exception handling in create method
logger.error("Error creating nha san xuat: " + e.getMessage());

// Line 89: Exception handling in update method
logger.error("Error updating nha san xuat: " + e.getMessage());

// Line 112: Exception handling in delete method
logger.error("Error deleting nha san xuat: " + e.getMessage());
```

### FileController

```java
// Line 42: Exception handling in uploadFile method
logger.error("Error uploading file: " + e.getMessage());

// Line 68: Exception handling in getFile method
logger.error("Error retrieving file: " + e.getMessage());
```

## Kết luận

Lớp controller có độ bao phủ mã nguồn rất tốt ở mức 95.6% cho dòng mã, 100% cho phương thức và 100% cho lớp. Các dòng mã chưa được bao phủ chủ yếu nằm trong các khối xử lý ngoại lệ, vốn khó kiểm thử mà không cố tình gây ra ngoại lệ. Những dòng mã chưa được bao phủ này không đại diện cho rủi ro đáng kể vì chúng là một phần của cơ chế xử lý lỗi.
