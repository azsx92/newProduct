package com.frankit.product_v1.controller;



import com.frankit.product_v1.common.enums.SuccessCode;
import com.frankit.product_v1.common.model.EnumService;
import com.frankit.product_v1.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/enum")
@RequiredArgsConstructor
public class SelectEnumController {

    private final EnumService service;

    @GetMapping("/option/type")
    public CommonResponse getOptionTypeEnumList() throws Exception {
        return CommonResponse.success(service.getOptionTypeEnumList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/user/state")
    public CommonResponse getUserStateEnumList() throws Exception {
        return CommonResponse.success(service.getUserStateEnumList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
}

