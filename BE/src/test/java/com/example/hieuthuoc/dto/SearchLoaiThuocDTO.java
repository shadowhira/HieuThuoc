package com.example.hieuthuoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO cho tìm kiếm loại thuốc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLoaiThuocDTO {
    private String keyWord;
    private Integer currentPage;
    private Integer size;
}
