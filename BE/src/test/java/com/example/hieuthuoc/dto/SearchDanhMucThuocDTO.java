package com.example.hieuthuoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO cho tìm kiếm danh mục thuốc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDanhMucThuocDTO {
    private String keyWord;
    private Integer currentPage;
    private Integer size;
}
