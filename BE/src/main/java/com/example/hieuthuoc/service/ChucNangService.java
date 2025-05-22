package com.example.hieuthuoc.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hieuthuoc.dto.ChucNangDTO;
import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.ChucNang;
import com.example.hieuthuoc.repository.ChucNangRepo;

public interface ChucNangService {
	ResponseDTO<List<ChucNang>> getAllChucNangs();

	ResponseDTO<ChucNang> create(ChucNangDTO chucNangDTO);

	ResponseDTO<ChucNang> update(ChucNangDTO chucNangDTO);

	ResponseDTO<Void> delete(Integer id);

	ResponseDTO<ChucNang> getById(Integer id);
}

@Service
class ChucNangServiceImpl implements ChucNangService {

	@Autowired
	private ChucNangRepo chucNangRepo;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public ResponseDTO<List<ChucNang>> getAllChucNangs() {
		return ResponseDTO.<List<ChucNang>>builder().status(200).msg("Thành công").data(chucNangRepo.findAll()).build();
	}

	@Override
	@Transactional
	public ResponseDTO<ChucNang> create(ChucNangDTO chucNangDTO) {
		if (chucNangRepo.existsByTenChucNang(chucNangDTO.getTenChucNang())) {
			return ResponseDTO.<ChucNang>builder().status(409).msg("Chức năng đã tồn tại").build();
		}
		ChucNang chucNang = modelMapper.map(chucNangDTO, ChucNang.class);
		return ResponseDTO.<ChucNang>builder().status(201).msg("Tạo chức năng thành công").data(chucNangRepo.save(chucNang)).build();
	}

	@Override
	@Transactional
	public ResponseDTO<ChucNang> update(ChucNangDTO chucNangDTO) {
		ChucNang currentChucNang = chucNangRepo.findById(chucNangDTO.getId()).orElse(null);
		if (currentChucNang == null) {
			return ResponseDTO.<ChucNang>builder().status(404).msg("Không tìm thấy chức năng").build();
		}

		ChucNang chucNang = modelMapper.map(chucNangDTO, ChucNang.class);
		return ResponseDTO.<ChucNang>builder().status(200).msg("Cập nhật chức năng thành công").data(chucNangRepo.save(chucNang)).build();
	}

	@Override
	@Transactional
	public ResponseDTO<Void> delete(Integer id) {
		chucNangRepo.deleteById(id);
		return ResponseDTO.<Void>builder().status(200).msg("Thành công").build();
	}

	@Override
	public ResponseDTO<ChucNang> getById(Integer id) {
		ChucNang chucNang = chucNangRepo.findById(id).orElse(null);
		if (chucNang != null) {
			return ResponseDTO.<ChucNang>builder().status(200).msg("Thành công").data(chucNang).build();
		}
		return ResponseDTO.<ChucNang>builder().status(404).msg("Không tìm thấy chức năng").build();
	}
}
