package com.example.hieuthuoc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hieuthuoc.entity.Thuoc;

@Repository
public interface ThuocRepo extends JpaRepository<Thuoc, Integer> {

	// Tìm thuốc theo tên
	Page<Thuoc> findByTenThuoc(String tenThuoc, Pageable pageable);

	Boolean existsByMaThuoc(String maThuoc);

	Boolean existsByTenThuoc(String tenThuoc);

//    Search thuoc
	@Query("SELECT DISTINCT t FROM Thuoc t " +
	       "LEFT JOIN t.loaiThuoc lt " +
	       "LEFT JOIN t.nhaSanXuat nsx " +
	       "LEFT JOIN lt.danhMucThuoc dmt " +
	       "LEFT JOIN t.doiTuongs dt " +
	       "WHERE (:keyWord IS NULL OR :keyWord = '' OR (LOWER(t.tenThuoc) LIKE LOWER(CONCAT('%', :keyWord, '%')) " +
	       "OR LOWER(t.maThuoc) LIKE LOWER(CONCAT('%', :keyWord, '%')))) " +
	       "AND (:loaiThuoc IS NULL OR :loaiThuoc = '' OR (lt IS NOT NULL AND LOWER(lt.tenLoai) LIKE LOWER(CONCAT('%', :loaiThuoc, '%')))) " +
	       "AND (:nhaSanXuat IS NULL OR :nhaSanXuat = '' OR (nsx IS NOT NULL AND LOWER(nsx.tenNhaSanXuat) LIKE LOWER(CONCAT('%', :nhaSanXuat, '%')))) " +
	       "AND (:danhMucThuoc IS NULL OR :danhMucThuoc = '' OR (dmt IS NOT NULL AND LOWER(dmt.tenDanhMuc) LIKE LOWER(CONCAT('%', :danhMucThuoc, '%')))) " +
	       "AND ((:minGiaBan IS NULL AND :maxGiaBan IS NULL) OR (:minGiaBan IS NOT NULL AND :maxGiaBan IS NOT NULL AND t.giaBan >= :minGiaBan AND t.giaBan <= :maxGiaBan) " +
	       "OR (:minGiaBan IS NOT NULL AND :maxGiaBan IS NULL AND t.giaBan >= :minGiaBan) " +
	       "OR (:minGiaBan IS NULL AND :maxGiaBan IS NOT NULL AND t.giaBan <= :maxGiaBan)) " +
	       "AND (:tenDoiTuong IS NULL OR :tenDoiTuong = '' OR (dt IS NOT NULL AND LOWER(dt.tenDoiTuong) LIKE LOWER(CONCAT('%', :tenDoiTuong, '%')))) " +
	       "AND (:trangThai IS NULL OR t.trangThai = :trangThai)"
	)
	Page<Thuoc> search(@Param("keyWord") String keyWord, @Param("loaiThuoc") String loaiThuoc,
			@Param("nhaSanXuat") String nhaSanXuat, @Param("danhMucThuoc") String danhMucThuoc,
			@Param("minGiaBan") Double minGiaBan, @Param("maxGiaBan") Double maxGiaBan,
			@Param("tenDoiTuong") String tenDoiTuong, @Param("trangThai") Boolean trangThai, Pageable pageable
	);
}
