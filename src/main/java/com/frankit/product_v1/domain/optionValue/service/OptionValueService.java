package com.frankit.product_v1.domain.optionValue.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.optionValue.model.OptionValueDto;
import com.frankit.product_v1.domain.optionValue.model.OptionValueEntity;
import com.frankit.product_v1.domain.optionValue.repository.OptionValueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OptionValueService {

    private final OptionValueRepository optionValueRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;


    // 목록 조회
    public List<OptionValueDto.Response> getList( ) throws Exception{
        List<OptionValueEntity> list = optionValueRepository.findAll();
        log.info("list: {}" , list);

        return list.stream().map(entity -> modelMapper.map(entity, OptionValueDto.Response.class)).toList();
    }



    // 단건 조회
    public OptionValueDto.Response getOne(Long id) throws Exception{

        Optional<OptionValueEntity> entity =  optionValueRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return  modelMapper.map(entity.get(), OptionValueDto.Response.class);
    }

    // 등록
    public OptionValueDto.Response create(OptionValueDto.common request) throws Exception {
        // sortEncoding
        OptionValueEntity entity = modelMapper.map(request, OptionValueEntity.class);

        OptionValueEntity savedEntity = optionValueRepository.save(entity);
        return modelMapper.map(savedEntity , OptionValueDto.Response.class);
    }



    // 수정
    public OptionValueDto.Response update(Long id , OptionValueDto.UpdateRequest request) throws Exception {
        Optional<OptionValueEntity> entityOptional = optionValueRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }

        OptionValueEntity entity = entityOptional.get();

        modelMapper.map(request, entity);             // 나머지 필드 업데이트
        OptionValueEntity updatedEntity = optionValueRepository.save(entity);

        return modelMapper.map(updatedEntity, OptionValueDto.Response.class);
    }

    // 삭제
    public String delete(Long id) throws Exception {
        Optional<OptionValueEntity> entity = optionValueRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        optionValueRepository.delete(entity.get());
        return id + "번 옵션 값이 삭제 되었습니다.";
    }

}