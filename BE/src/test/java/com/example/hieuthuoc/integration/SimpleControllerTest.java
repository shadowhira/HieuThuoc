package com.example.hieuthuoc.integration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.hieuthuoc.dto.ResponseDTO;
import com.example.hieuthuoc.entity.Thuoc;
import com.example.hieuthuoc.service.ThuocService;

/**
 * Test đơn giản để kiểm tra xem có thể chạy được test không
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ThuocService thuocService;
    
    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetById_Success() throws Exception {
        // Arrange
        Thuoc thuoc = new Thuoc();
        thuoc.setId(1);
        thuoc.setTenThuoc("Paracetamol 500mg");
        thuoc.setMaThuoc("PARA500");
        
        ResponseDTO<Thuoc> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(200);
        responseDTO.setMsg("Thành công");
        responseDTO.setData(thuoc);
        
        when(thuocService.getById(1)).thenReturn(responseDTO);
        
        // Act & Assert
        mockMvc.perform(get("/thuoc/get")
                .param("id", "1"))
                .andExpect(status().isOk());
    }
}
