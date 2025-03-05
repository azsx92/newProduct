package com.frankit.product_v1.controller;


import com.frankit.product_v1.common.enums.SuccessCode;
import com.frankit.product_v1.common.response.CommonResponse;
import com.frankit.product_v1.domain.optionValue.model.OptionValueDto;
import com.frankit.product_v1.domain.optionValue.service.OptionValueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/option-value")
@RequiredArgsConstructor
@Slf4j
public class OptionValueController {

    private final OptionValueService service;

    @GetMapping()
    public CommonResponse getList() throws Exception {
        return CommonResponse.success(service.getList(), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{id}")
    public CommonResponse getOne(@PathVariable Long id) throws Exception {
        return CommonResponse.success(service.getOne(id), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping()
    public CommonResponse create(@RequestBody @Valid OptionValueDto.common request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PatchMapping("/{id}")
    public CommonResponse update(@PathVariable Long id, @RequestBody OptionValueDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(id, request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{id}")
    public CommonResponse delete(@PathVariable Long id) throws Exception {
        return CommonResponse.success(service.delete(id), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
}