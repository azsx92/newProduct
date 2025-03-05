package com.frankit.product_v1.controller;


import com.frankit.product_v1.common.enums.SuccessCode;
import com.frankit.product_v1.common.response.CommonResponse;
import com.frankit.product_v1.domain.product.model.ProductDto;
import com.frankit.product_v1.domain.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @GetMapping()
    public CommonResponse getList(ProductDto.SearchRequest request, Pageable pageable) throws Exception {
        return CommonResponse.success(service.getList(request, pageable), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @GetMapping("/{id}")
    public CommonResponse getOne(@PathVariable Long id) throws Exception {
        return CommonResponse.success(service.getOne(id), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PostMapping()
    public CommonResponse create(@RequestBody @Valid ProductDto.common request) throws Exception {
        return CommonResponse.success(service.create(request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @PatchMapping("/{id}")
    public CommonResponse update(@PathVariable Long id , @RequestBody ProductDto.UpdateRequest request) throws Exception {
        return CommonResponse.success(service.update(id, request), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }

    @DeleteMapping("/{id}")
    public CommonResponse delete(@PathVariable Long id) throws Exception {
        return CommonResponse.success(service.delete(id), SuccessCode.COMMON_SYSTEM_SUCCESS.getCode());
    }
}
