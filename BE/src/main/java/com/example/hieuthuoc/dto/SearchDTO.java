package com.example.hieuthuoc.dto;

import lombok.Data;

@Data
public class SearchDTO {
	private String keyWord;
	private int id;

	private Integer currentPage;
	private Integer size;
	private String sortedField;

	// Thêm các trường bổ sung để tương thích với frontend
	private Boolean trangThai;
	private String loaiThuoc;
	private String nhaSanXuat;
	private String danhMucThuoc;
	private Double minGiaBan;
	private Double maxGiaBan;
	private String tenDoiTuong;
}
