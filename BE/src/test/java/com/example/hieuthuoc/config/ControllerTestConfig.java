package com.example.hieuthuoc.config;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.hieuthuoc.repository.ChucNangRepo;
import com.example.hieuthuoc.repository.GioHangRepo;
import com.example.hieuthuoc.repository.NguoiDungRepo;
import com.example.hieuthuoc.repository.NhomQuyenRepo;
import com.example.hieuthuoc.jwt.JwtService;
import com.example.hieuthuoc.service.ChucNangService;
import com.example.hieuthuoc.service.EmailService;
import com.example.hieuthuoc.service.NguoiDungService;
import com.example.hieuthuoc.service.NhomQuyenService;
import com.example.hieuthuoc.service.UploadImageService;

/**
 * Cấu hình cho kiểm thử Controller
 * Sử dụng @MockBean để mock các dependency
 * và tránh xung đột với cấu hình của ứng dụng chính
 */
@TestConfiguration
@EnableWebMvc
@Import(TestSecurityConfig.class)
public class ControllerTestConfig {

    @MockBean
    private NguoiDungRepo nguoiDungRepo;

    @MockBean
    private NhomQuyenRepo nhomQuyenRepo;

    @MockBean
    private ChucNangRepo chucNangRepo;

    @MockBean
    private GioHangRepo gioHangRepo;

    @MockBean
    private EmailService emailService;

    @MockBean
    private UploadImageService uploadImageService;

    @MockBean
    private JwtService jwtService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return Mockito.mock(AuthenticationManager.class);
    }

    @Bean
    public NguoiDungService nguoiDungService() {
        return Mockito.mock(NguoiDungService.class);
    }

    @Bean
    public NhomQuyenService nhomQuyenService() {
        return Mockito.mock(NhomQuyenService.class);
    }

    @Bean
    public ChucNangService chucNangService() {
        return Mockito.mock(ChucNangService.class);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                return new User(username, "password", authorities);
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }
}
