# BIỂU ĐỒ TỔNG HỢP KẾT QUẢ KIỂM THỬ

## 📋 THÔNG TIN CHUNG

- **Dự án**: Hệ thống web bán và quản lý hiệu thuốc
- **Module**: Quản lý thuốc
- **Thời gian thực hiện**: 17/05/2025 - 22/05/2025
- **Người thực hiện**: Nhóm Kiểm thử Hiệu thuốc

## 📊 DANH SÁCH BIỂU ĐỒ

1. [Biểu đồ cột thể hiện tỷ lệ thành công/thất bại của từng giai đoạn](#biểu-đồ-1-tỷ-lệ-thành-côngthất-bại-của-từng-giai-đoạn)
2. [Biểu đồ tròn thể hiện phân bố test case theo giai đoạn](#biểu-đồ-2-phân-bố-test-case-theo-giai-đoạn)
3. [Biểu đồ tròn thể hiện phân bố lỗi theo loại](#biểu-đồ-3-phân-bố-lỗi-theo-loại)
4. [Biểu đồ tròn thể hiện phân bố lỗi theo mức độ nghiêm trọng](#biểu-đồ-4-phân-bố-lỗi-theo-mức-độ-nghiêm-trọng)
5. [Biểu đồ cột thể hiện số lượng test case theo chức năng](#biểu-đồ-5-số-lượng-test-case-theo-chức-năng)
6. [Biểu đồ đường thể hiện tiến độ kiểm thử theo thời gian](#biểu-đồ-6-tiến-độ-kiểm-thử-theo-thời-gian)

## 📈 CHI TIẾT BIỂU ĐỒ

### Biểu đồ 1: Tỷ lệ thành công/thất bại của từng giai đoạn

```
Tỷ lệ thành công/thất bại của từng giai đoạn
┌────────────────────────────────────────────────────────────┐
│                                                            │
│  100% ┌───┐ ┌───┐ ┌───┐ ┌───┐ ┌───┐                       │
│       │   │ │   │ │   │ │   │ │   │                       │
│   80% │   │ │   │ │   │ │   │ │   │                       │
│       │   │ │   │ │   │ │   │ │   │                       │
│   60% │   │ │   │ │   │ │   │ │   │                       │
│       │   │ │   │ │   │ │   │ │   │                       │
│   40% │   │ │   │ │   │ │   │ │   │                       │
│       │   │ │   │ │   │ │   │ │   │                       │
│   20% │   │ │   │ │   │ │   │ │   │                       │
│       │   │ │   │ │   │ │   │ │   │                       │
│    0% └───┘ └───┘ └───┘ └───┘ └───┘                       │
│        G2    G3    G4    G5    G6                         │
│                                                            │
│  Thành công █  Thất bại █                                  │
└────────────────────────────────────────────────────────────┘
```

**Mô tả**: Biểu đồ cột thể hiện tỷ lệ thành công/thất bại của từng giai đoạn kiểm thử. Tất cả các giai đoạn đều có tỷ lệ thành công 100%.

**Dữ liệu**:

| Giai đoạn | Tổng số test case | Thành công | Thất bại | Tỷ lệ thành công |
|-----------|-------------------|------------|----------|------------------|
| G2: Kiểm thử đơn vị | 18 | 18 | 0 | 100% |
| G3: Kiểm thử tích hợp | 12 | 12 | 0 | 100% |
| G4: Kiểm thử chức năng | 16 | 16 | 0 | 100% |
| G5: Kiểm thử giao diện | 10 | 10 | 0 | 100% |
| G6: Kiểm thử hệ thống | 8 | 8 | 0 | 100% |

### Biểu đồ 2: Phân bố test case theo giai đoạn

```
Phân bố test case theo giai đoạn
┌────────────────────────────────────────────────────────────┐
│                                                            │
│                      ┌───────┐                             │
│                     /         \                            │
│                    /           \                           │
│                   /             \                          │
│                  /   G2: 28%     \                         │
│                 /                 \                        │
│                |                   |                       │
│                |                   |                       │
│                |   G4: 25%         |                       │
│                 \                 /                        │
│                  \               /                         │
│                   \             /                          │
│                    \           /                           │
│                     \         /                            │
│                      └───────┘                             │
│                                                            │
│                G3: 19%        G5: 16%       G6: 12%        │
│                                                            │
└────────────────────────────────────────────────────────────┘
```

**Mô tả**: Biểu đồ tròn thể hiện phân bố test case theo giai đoạn kiểm thử. Giai đoạn 2 (Kiểm thử đơn vị) chiếm tỷ lệ cao nhất (28%), tiếp theo là Giai đoạn 4 (Kiểm thử chức năng) với 25%.

**Dữ liệu**:

| Giai đoạn | Tổng số test case | Tỷ lệ |
|-----------|-------------------|-------|
| G2: Kiểm thử đơn vị | 18 | 28% |
| G3: Kiểm thử tích hợp | 12 | 19% |
| G4: Kiểm thử chức năng | 16 | 25% |
| G5: Kiểm thử giao diện | 10 | 16% |
| G6: Kiểm thử hệ thống | 8 | 12% |
| **Tổng cộng** | **64** | **100%** |

### Biểu đồ 3: Phân bố lỗi theo loại

```
Phân bố lỗi theo loại
┌────────────────────────────────────────────────────────────┐
│                                                            │
│                      ┌───────┐                             │
│                     /         \                            │
│                    /           \                           │
│                   /             \                          │
│                  /               \                         │
│                 /                 \                        │
│                |                   |                       │
│                |                   |                       │
│                |  Chức năng: 75%   |                       │
│                |                   |                       │
│                |                   |                       │
│                 \                 /                        │
│                  \               /                         │
│                   \             /                          │
│                    \           /                           │
│                     \         /                            │
│                      └───────┘                             │
│                                                            │
│                      Giao diện: 25%                        │
│                                                            │
└────────────────────────────────────────────────────────────┘
```

**Mô tả**: Biểu đồ tròn thể hiện phân bố lỗi theo loại. Lỗi chức năng chiếm tỷ lệ cao nhất (75%), tiếp theo là lỗi giao diện (25%).

**Dữ liệu**:

| Loại lỗi | Số lượng | Tỷ lệ |
|----------|----------|-------|
| Lỗi chức năng (Functional) | 3 | 75% |
| Lỗi giao diện (UI) | 1 | 25% |
| Lỗi hiệu năng (Performance) | 0 | 0% |
| Lỗi bảo mật (Security) | 0 | 0% |
| Lỗi tương thích (Compatibility) | 0 | 0% |
| Lỗi khác (Other) | 0 | 0% |
| **Tổng cộng** | **4** | **100%** |

### Biểu đồ 4: Phân bố lỗi theo mức độ nghiêm trọng

```
Phân bố lỗi theo mức độ nghiêm trọng
┌────────────────────────────────────────────────────────────┐
│                                                            │
│                      ┌───────┐                             │
│                     /         \                            │
│                    /           \                           │
│                   /             \                          │
│                  /               \                         │
│                 /                 \                        │
│                |                   |                       │
│                |                   |                       │
│                |     Thấp: 50%     |                       │
│                |                   |                       │
│                |                   |                       │
│                 \                 /                        │
│                  \               /                         │
│                   \             /                          │
│                    \           /                           │
│                     \         /                            │
│                      └───────┘                             │
│                                                            │
│                  Cao: 25%        Trung bình: 25%           │
│                                                            │
└────────────────────────────────────────────────────────────┘
```

**Mô tả**: Biểu đồ tròn thể hiện phân bố lỗi theo mức độ nghiêm trọng. Lỗi có mức độ nghiêm trọng thấp chiếm tỷ lệ cao nhất (50%), tiếp theo là lỗi có mức độ nghiêm trọng cao và trung bình (mỗi loại 25%).

**Dữ liệu**:

| Mức độ nghiêm trọng | Số lượng | Tỷ lệ |
|---------------------|----------|-------|
| Nghiêm trọng (Critical) | 0 | 0% |
| Cao (High) | 1 | 25% |
| Trung bình (Medium) | 1 | 25% |
| Thấp (Low) | 2 | 50% |
| **Tổng cộng** | **4** | **100%** |

### Biểu đồ 5: Số lượng test case theo chức năng

```
Số lượng test case theo chức năng
┌────────────────────────────────────────────────────────────┐
│                                                            │
│  20 ┐                                                      │
│     │                                                      │
│     │                   ┌───┐                              │
│  15 ┤         ┌───┐    │   │                              │
│     │  ┌───┐  │   │    │   │                              │
│     │  │   │  │   │    │   │                              │
│  10 ┤  │   │  │   │    │   │                              │
│     │  │   │  │   │    │   │                              │
│     │  │   │  │   │    │   │    ┌───┐                     │
│   5 ┤  │   │  │   │    │   │    │   │                     │
│     │  │   │  │   │    │   │    │   │                     │
│     │  │   │  │   │    │   │    │   │                     │
│   0 ┼──┴───┴──┴───┴────┴───┴────┴───┴─────────────────────┤
│       Thêm   Sửa    Xóa   Tìm kiếm  Phân trang            │
│                                                            │
└────────────────────────────────────────────────────────────┘
```

**Mô tả**: Biểu đồ cột thể hiện số lượng test case theo chức năng. Chức năng tìm kiếm thuốc có số lượng test case nhiều nhất (18), tiếp theo là chức năng thêm thuốc và sửa thuốc (mỗi chức năng 15).

**Dữ liệu**:

| Chức năng | Tổng số test case |
|-----------|-------------------|
| Thêm thuốc | 15 |
| Sửa thuốc | 15 |
| Xóa thuốc | 12 |
| Tìm kiếm thuốc | 18 |
| Phân trang và sắp xếp | 4 |
| **Tổng cộng** | **64** |

### Biểu đồ 6: Tiến độ kiểm thử theo thời gian

```
Tiến độ kiểm thử theo thời gian
┌────────────────────────────────────────────────────────────┐
│                                                            │
│ 100% ┐                                        ┌───────────┐│
│      │                                ┌───────┘           ││
│  80% ┤                        ┌───────┘                   ││
│      │                ┌───────┘                           ││
│  60% ┤        ┌───────┘                                   ││
│      │┌───────┘                                           ││
│  40% ┤│                                                   ││
│      ││                                                   ││
│  20% ┤│                                                   ││
│      ││                                                   ││
│   0% ┼┴───────────────────────────────────────────────────┤│
│       17/05   18/05   19/05   20/05   21/05   22/05       ││
│                                                            │
└────────────────────────────────────────────────────────────┘
```

**Mô tả**: Biểu đồ đường thể hiện tiến độ kiểm thử theo thời gian. Tiến độ tăng dần theo thời gian và đạt 100% vào ngày 22/05/2025.

**Dữ liệu**:

| Ngày | Tiến độ |
|------|---------|
| 17/05/2025 | 20% |
| 18/05/2025 | 40% |
| 19/05/2025 | 60% |
| 20/05/2025 | 80% |
| 21/05/2025 | 90% |
| 22/05/2025 | 100% |

## 📝 KẾT LUẬN

Dựa trên các biểu đồ trên, chúng ta có thể rút ra một số kết luận sau:

1. Tất cả các giai đoạn kiểm thử đều có tỷ lệ thành công 100%, cho thấy chất lượng của chức năng Quản lý thuốc rất tốt.

2. Giai đoạn 2 (Kiểm thử đơn vị) và Giai đoạn 4 (Kiểm thử chức năng) chiếm tỷ lệ cao nhất về số lượng test case, cho thấy sự tập trung vào việc kiểm thử các thành phần riêng lẻ và chức năng của hệ thống.

3. Lỗi chức năng chiếm tỷ lệ cao nhất (75%), cho thấy cần tập trung hơn vào việc kiểm thử chức năng trong quá trình phát triển.

4. Lỗi có mức độ nghiêm trọng thấp chiếm tỷ lệ cao nhất (50%), cho thấy hệ thống không có lỗi nghiêm trọng nào.

5. Chức năng tìm kiếm thuốc có số lượng test case nhiều nhất (18), cho thấy đây là chức năng quan trọng và phức tạp nhất trong module Quản lý thuốc.

6. Tiến độ kiểm thử tăng dần theo thời gian và đạt 100% vào ngày 22/05/2025, cho thấy quá trình kiểm thử đã được thực hiện đúng tiến độ.

## 📎 TÀI LIỆU LIÊN QUAN

- [Tổng hợp kết quả kiểm thử](../ket-qua-tong-hop/Tong_Hop_Ket_Qua_Kiem_Thu.md)
- [Phân tích lỗi](../phan-tich-loi/Phan_Tich_Loi.md)
