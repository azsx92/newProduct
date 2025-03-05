package com.frankit.product_v1.domain.optionValueMapping.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.optionValueMapping.model.OptionValueMappingDto;
import com.frankit.product_v1.domain.optionValueMapping.model.OptionValueMappingEntity;
import com.frankit.product_v1.domain.optionValueMapping.repository.OptionValueMappingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OptionValueMappingService {

    private final OptionValueMappingRepository optionValueMappingRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;


    // 목록 조회
    public List<OptionValueMappingDto.Response> getList( ) throws Exception{
        List<OptionValueMappingEntity> list = optionValueMappingRepository.findAll();
        log.info("list: {}" , list);

        return list.stream().map(entity -> modelMapper.map(entity, OptionValueMappingDto.Response.class)).toList();
    }



    // 단건 조회
    public OptionValueMappingDto.Response getOne(Long id) throws Exception{

        Optional<OptionValueMappingEntity> entity =  optionValueMappingRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return  modelMapper.map(entity.get(), OptionValueMappingDto.Response.class);
    }

    // 등록
    public OptionValueMappingDto.Response create(OptionValueMappingDto.common request) throws Exception {
        // sortEncoding
        OptionValueMappingEntity entity = modelMapper.map(request, OptionValueMappingEntity.class);

        OptionValueMappingEntity savedEntity = optionValueMappingRepository.save(entity);
        return modelMapper.map(savedEntity , OptionValueMappingDto.Response.class);
    }



    // 수정
    public OptionValueMappingDto.Response update(Long id , OptionValueMappingDto.UpdateRequest request) throws Exception {
        Optional<OptionValueMappingEntity> entityOptional = optionValueMappingRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }

        OptionValueMappingEntity entity = entityOptional.get();

        modelMapper.map(request, entity);             // 나머지 필드 업데이트
        OptionValueMappingEntity updatedEntity = optionValueMappingRepository.save(entity);

        return modelMapper.map(updatedEntity, OptionValueMappingDto.Response.class);
    }

    // 삭제
    public String delete(Long id) throws Exception {
        Optional<OptionValueMappingEntity> entity = optionValueMappingRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        optionValueMappingRepository.delete(entity.get());
        return id + "번 옵션 값 매핑이 삭제 되었습니다.";
    }

}