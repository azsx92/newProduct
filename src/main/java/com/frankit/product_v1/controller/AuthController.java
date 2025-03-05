package com.frankit.product_v1.controller;


import com.frankit.product_v1.common.enums.SuccessCode;
import com.frankit.product_v1.common.response.CommonResponse;
import com.frankit.product_v1.domain.auth.model.AuthRegisterRequestDto;
import com.frankit.product_v1.domain.auth.model.AuthRequestDto;
import com.frankit.product_v1.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public CommonResponse register(@RequestBody AuthRegisterRequestDto request) throws Exception {
        return CommonResponse.success(service.register(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping("/authenticate")
    public CommonResponse authenticate(@RequestBody AuthRequestDto request) throws Exception {
        return CommonResponse.success(service.authenticate(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

}
