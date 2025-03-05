package com.frankit.product_v1.domain.product.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.frankit.product_v1.common.enums.ErrorCode;

import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.product.model.ProductDto;
import com.frankit.product_v1.domain.product.model.ProductEntity;
import com.frankit.product_v1.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;


    // 목록 조회
    public List<ProductDto.Response> getList(ProductDto.SearchRequest request , Pageable pageable) throws Exception{
        System.out.println("request: {}" + request);

        Page<ProductEntity> list = productRepository.findSearchAll(request, pageable);
        log.info("list: {}" , list);
        return list.map(entity -> modelMapper.map(entity, ProductDto.Response.class)).toList();
    }



    // 단건 조회
    public ProductDto.Response getOne(Long id) throws Exception{

        Optional<ProductEntity> entity =  productRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return  modelMapper.map(entity.get(), ProductDto.Response.class);
    }

    // 등록
    public ProductDto.Response create(ProductDto.common request) throws Exception {
        // sortEncoding
        ProductEntity entity = modelMapper.map(request, ProductEntity.class);

        ProductEntity savedEntity = productRepository.save(entity);
        return modelMapper.map(savedEntity , ProductDto.Response.class);
    }



    // 수정
    public ProductDto.Response update(Long id , ProductDto.UpdateRequest request) throws Exception {
        Optional<ProductEntity> entityOptional = productRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }

        ProductEntity entity = entityOptional.get();

        modelMapper.map(request, entity);             // 나머지 필드 업데이트
        ProductEntity updatedEntity = productRepository.save(entity);

        return modelMapper.map(updatedEntity, ProductDto.Response.class);
    }

    // 삭제
    public String delete(Long id) throws Exception {
        Optional<ProductEntity> entity = productRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        productRepository.delete(entity.get());
        return id + "번 상품이 삭제 되었습니다.";
    }

}