package com.example.hieuthuoc.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.example.hieuthuoc.service.DoiTuongService;
import com.example.hieuthuoc.service.LoaiThuocService;
import com.example.hieuthuoc.service.NhaSanXuatService;
import com.example.hieuthuoc.service.ThuocService;
import com.example.hieuthuoc.service.UploadImageService;

@TestConfiguration
public class TestConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @MockBean
    public ThuocService thuocService;

    @MockBean
    public LoaiThuocService loaiThuocService;

    @MockBean
    public NhaSanXuatService nhaSanXuatService;

    @MockBean
    public DoiTuongService doiTuongService;

    @Bean
    public UploadImageService uploadImageService() {
        return new UploadImageService() {
            @Override
            public String uploadImage(org.springframework.web.multipart.MultipartFile file, String name) {
                return "https://example.com/images/" + name + ".jpg";
            }

            @Override
            public void deleteImage(String url) {
                // Do nothing for test
            }
        };
    }
}
