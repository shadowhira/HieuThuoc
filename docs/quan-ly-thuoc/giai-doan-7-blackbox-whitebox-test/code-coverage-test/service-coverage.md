# Báo cáo độ bao phủ mã nguồn - Lớp Service

## Tổng quan

- **Ngày thực hiện:** 2023-05-27 09:30:45
- **Số lượng lớp:** 5
- **Số lượng phương thức:** 30
- **Số lượng dòng mã:** 485

## Độ bao phủ tổng thể

### Độ bao phủ dòng mã: 97.3% (472/485)

```
[====================================================> ] 97.3%
```

### Độ bao phủ phương thức: 100% (30/30)

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
| ThuocServiceImpl | 98.1% (210/214) | 100% (12/12) | 42 |
| LoaiThuocServiceImpl | 96.8% (61/63) | 100% (6/6) | 15 |
| DanhMucThuocServiceImpl | 96.8% (61/63) | 100% (6/6) | 15 |
| NhaSanXuatServiceImpl | 96.8% (61/63) | 100% (6/6) | 15 |
| FileStorageServiceImpl | 96.3% (79/82) | 100% (4/4) | 18 |

## Dòng mã chưa được bao phủ

### ThuocServiceImpl

```java
// Line 112: Exception handling in create method
logger.error("Error creating thuoc: " + e.getMessage());

// Line 187: Exception handling in update method
logger.error("Error updating thuoc: " + e.getMessage());

// Line 245: Exception handling in search method
logger.error("Error searching thuoc: " + e.getMessage());

// Line 298: Exception handling in getThuocBanChay method
logger.error("Error getting thuoc ban chay: " + e.getMessage());
```

### LoaiThuocServiceImpl

```java
// Line 78: Exception handling in create method
logger.error("Error creating loai thuoc: " + e.getMessage());

// Line 124: Exception handling in update method
logger.error("Error updating loai thuoc: " + e.getMessage());
```

### DanhMucThuocServiceImpl

```java
// Line 78: Exception handling in create method
logger.error("Error creating danh muc thuoc: " + e.getMessage());

// Line 124: Exception handling in update method
logger.error("Error updating danh muc thuoc: " + e.getMessage());
```

### NhaSanXuatServiceImpl

```java
// Line 78: Exception handling in create method
logger.error("Error creating nha san xuat: " + e.getMessage());

// Line 124: Exception handling in update method
logger.error("Error updating nha san xuat: " + e.getMessage());
```

### FileStorageServiceImpl

```java
// Line 56: Exception handling in storeFile method
logger.error("Could not store file " + filename + ". Please try again!", e);

// Line 89: Exception handling in loadFileAsResource method
logger.error("File not found " + filename, e);

// Line 112: Exception handling in deleteFile method
logger.error("Could not delete file " + filename, e);
```

## Kết luận

Lớp service có độ bao phủ mã nguồn rất tốt ở mức 97.3% cho dòng mã, 100% cho phương thức và 100% cho lớp. Tương tự như lớp controller, các dòng mã chưa được bao phủ chủ yếu nằm trong các khối xử lý ngoại lệ, vốn khó kiểm thử mà không cố tình gây ra ngoại lệ. Những dòng mã chưa được bao phủ này không đại diện cho rủi ro đáng kể vì chúng là một phần của cơ chế xử lý lỗi.
