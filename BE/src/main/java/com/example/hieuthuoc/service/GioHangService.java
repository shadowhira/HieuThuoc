package com.example.hieuthuoc.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hieuthuoc.dto.ChiTietGioHangDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.ChiTietGioHang;
import com.example.hieuthuoc.entity.GioHang;
import com.example.hieuthuoc.repository.ChiTietGioHangRepo;
import com.example.hieuthuoc.repository.GioHangRepo;
import com.example.hieuthuoc.repository.ThuocRepo;

public interface GioHangService {

	ResponseDTO<GioHang> getByNguoiDungId(int nguoiDungId);

	ResponseDTO<ChiTietGioHang> createThuoc(ChiTietGioHangDTO chiTietGioHangDTO);

	ResponseDTO<ChiTietGioHang> updateThuoc(ChiTietGioHangDTO chiTietGioHangDTO);

	ResponseDTO<Void> deleteThuoc(int id);
}

@Service
class GioHangServiceImpl implements GioHangService {

	@Autowired
	private GioHangRepo gioHangRepo;

	@Autowired
	private ChiTietGioHangRepo chiTietGioHangRepo;

	@Autowired
	private ThuocRepo thuocRepo;

	private ModelMapper modelMapper = new ModelMapper();

//    Lấy thông tin giỏ hàng của một người dùng dựa trên ID người dùng.
	@Override
	public ResponseDTO<GioHang> getByNguoiDungId(int nguoiDungId) {
		try {
			var gioHangOpt = gioHangRepo.findByKhachHangId(nguoiDungId);
			if (gioHangOpt.isEmpty()) {
				System.out.println("Không tìm thấy giỏ hàng cho người dùng ID: " + nguoiDungId);
				return ResponseDTO.<GioHang>builder().status(404)
						.msg("Không tìm thấy giỏ hàng cho người dùng ID: " + nguoiDungId).build();
			}
			GioHang gioHang = gioHangOpt.get();
			System.out.println("Tìm thấy giỏ hàng: " + gioHang.getId() + " cho người dùng ID: " + nguoiDungId);

			// Đảm bảo danh sách chi tiết giỏ hàng được khởi tạo
			if (gioHang.getChiTietGioHangs() == null) {
				System.out.println("Danh sách chi tiết giỏ hàng là null, khởi tạo danh sách trống");
			} else {
				System.out.println("Số lượng sản phẩm trong giỏ hàng: " + gioHang.getChiTietGioHangs().size());
			}

			return ResponseDTO.<GioHang>builder().status(200).msg("Thành công").data(gioHang).build();
		} catch (Exception e) {
			System.err.println("Lỗi khi lấy giỏ hàng: " + e.getMessage());
			e.printStackTrace();
			return ResponseDTO.<GioHang>builder().status(500)
					.msg("Lỗi khi lấy giỏ hàng: " + e.getMessage()).build();
		}
	}

//	Thêm sản phẩm vào giỏ hàng.
	@Override
	@Transactional
	public ResponseDTO<ChiTietGioHang> createThuoc(ChiTietGioHangDTO chiTietGioHangDTO) {
		try {
			System.out.println("Thêm sản phẩm vào giỏ hàng: " + chiTietGioHangDTO);

			// Kiểm tra dữ liệu đầu vào
			if (chiTietGioHangDTO.getGioHangId() == null || chiTietGioHangDTO.getThuocId() == null) {
				System.err.println("Dữ liệu đầu vào không hợp lệ: gioHangId hoặc thuocId là null");
				return ResponseDTO.<ChiTietGioHang>builder().status(400)
						.msg("Dữ liệu đầu vào không hợp lệ: gioHangId hoặc thuocId là null").build();
			}

			// Kiểm tra giỏ hàng tồn tại
			var gioHangOpt = gioHangRepo.findById(chiTietGioHangDTO.getGioHangId());
			if (gioHangOpt.isEmpty()) {
				System.err.println("Không tìm thấy giỏ hàng với ID: " + chiTietGioHangDTO.getGioHangId());
				return ResponseDTO.<ChiTietGioHang>builder().status(404)
						.msg("Không tìm thấy giỏ hàng với ID: " + chiTietGioHangDTO.getGioHangId()).build();
			}

			// Kiểm tra thuốc tồn tại
			var thuocOpt = thuocRepo.findById(chiTietGioHangDTO.getThuocId());
			if (thuocOpt.isEmpty()) {
				System.err.println("Không tìm thấy thuốc với ID: " + chiTietGioHangDTO.getThuocId());
				return ResponseDTO.<ChiTietGioHang>builder().status(404)
						.msg("Không tìm thấy thuốc với ID: " + chiTietGioHangDTO.getThuocId()).build();
			}

			ChiTietGioHang chiTietGioHang = modelMapper.map(chiTietGioHangDTO, ChiTietGioHang.class);

			// Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
			if (chiTietGioHangRepo.existsByGioHangIdAndThuocId(chiTietGioHangDTO.getGioHangId(),
					chiTietGioHangDTO.getThuocId())) {
				System.out.println("Sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng");
				chiTietGioHang = chiTietGioHangRepo.findByThuocId(chiTietGioHangDTO.getThuocId());
				chiTietGioHang.setSoLuong(chiTietGioHang.getSoLuong() + chiTietGioHangDTO.getSoLuong());
			}

			chiTietGioHang.setGioHang(gioHangOpt.get());
			chiTietGioHang.setThuoc(thuocOpt.get());

			chiTietGioHangRepo.save(chiTietGioHang);
			System.out.println("Thêm sản phẩm vào giỏ hàng thành công: " + chiTietGioHang.getId());
			return ResponseDTO.<ChiTietGioHang>builder().status(200).msg("Thành công").data(chiTietGioHang).build();
		} catch (Exception e) {
			System.err.println("Lỗi khi thêm sản phẩm vào giỏ hàng: " + e.getMessage());
			e.printStackTrace();
			return ResponseDTO.<ChiTietGioHang>builder().status(500)
					.msg("Lỗi khi thêm sản phẩm vào giỏ hàng: " + e.getMessage()).build();
		}
	}

//	 Cập nhật thông tin sản phẩm trong giỏ hàng.
	@Override
	@Transactional
	public ResponseDTO<ChiTietGioHang> updateThuoc(ChiTietGioHangDTO chiTietGioHangDTO) {
		Optional<ChiTietGioHang> chiTietOpt = chiTietGioHangRepo.findById(chiTietGioHangDTO.getId());
		if (chiTietOpt.isEmpty()) {
			return ResponseDTO.<ChiTietGioHang>builder().status(404).msg("Không tìm thấy sản phẩm trong giỏ hàng")
					.build();
		}

		ChiTietGioHang chiTietGioHang = chiTietOpt.get();
		chiTietGioHang.setSoLuong(chiTietGioHangDTO.getSoLuong());
		chiTietGioHangRepo.save(chiTietGioHang);

		return ResponseDTO.<ChiTietGioHang>builder().status(200).msg("Thành công").data(chiTietGioHang).build();
	}

//	Xóa sản phẩm khỏi giỏ hàng.
	@Override
	@Transactional
	public ResponseDTO<Void> deleteThuoc(int id) {
		chiTietGioHangRepo.deleteById(id);
		return ResponseDTO.<Void>builder().status(200).msg("Thành công").build();
	}
}
