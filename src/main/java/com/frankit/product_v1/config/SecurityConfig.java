package com.frankit.product_v1.config;

import com.frankit.product_v1.common.enums.admin.AdminTypeEnum;
import com.frankit.product_v1.filter.JwtAuthFilter;
import com.frankit.product_v1.handlers.CustomSecurityHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomSecurityHandler customSecurityHandlers;
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] IGNORE_PAGES = {
            "favicon.ico", "/api/v1/auth/**", "/error", "/h2-console/**"
    }; // 제외할 경로

    private static final String[] BASE_PAGES = {
            "/api/v1/moapos/**", "/api/v1/base/**", "/api/v1/admin/**",
            "/api/v1/commonstore/**", "/api/v1/master/**", "/api/v1/order/master/**"
    };

    private static final String[] MASTER_PAGES = { "/api/v1/baseStoreDivision/**" }; // 마스터 경로
    private static final String[] PARTNER_PAGES = { "/api/v1/baseWorks/**", "/api/v1/baseStoreDivision/**" }; // 파트너 경로
    private static final String[] HOTEL_PAGES = { "/api/v1/order/hotel/**" }; // 호텔 경로
    private static final String[] STORE_PAGES = { "/api/v1/order/store/**" }; // 매장 경로

    private static final String[] MASTER_AND_HOTEL_PAGES = {
            "/api/v1/hotel/**", "/api/v1/baseWorks/**",
            "/api/v1/works/hotel/**", "/api/v1/near/store/**", "/api/v1/works/hotel/product/**",
            "/api/v1/works/hotel/**", "/api/v1/hotel/worksHotel/**", "/api/v1/checkout/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(IGNORE_PAGES).permitAll() // 제외 페이지
                        .requestMatchers(BASE_PAGES).permitAll()
                        .requestMatchers("/h2-console/**").permitAll() // ✅ H2 Console 허용
                        .requestMatchers(MASTER_PAGES).hasAnyRole(AdminTypeEnum.ADMIN_TYPE_MASTER.getCode(), AdminTypeEnum.ADMIN_TYPE_PARTNER.getCode()) // 마스터,파트너 권한
                        .anyRequest().authenticated() // 토큰 체크
                )
                .headers(headers -> headers.disable()) // ✅ 전체 Headers 비활성화 (H2 Console iframe 문제 해결)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionConfig -> exceptionConfig
                        .authenticationEntryPoint(customSecurityHandlers.unauthorizedEntryPoint)
                        .accessDeniedHandler(customSecurityHandlers.accessDeniedHandler)
                );

        return http.build();
    }
}
