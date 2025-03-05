package com.frankit.product_v1.domain.option.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.option.model.OptionDto;
import com.frankit.product_v1.domain.option.model.OptionEntity;
import com.frankit.product_v1.domain.option.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OptionService {

    private final OptionRepository optionRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;


    // 목록 조회
    public List<OptionDto.Response> getList( ) throws Exception{
        List<OptionEntity> list = optionRepository.findAll();
        log.info("list: {}" , list);

        return list.stream().map(entity -> modelMapper.map(entity, OptionDto.Response.class)).toList();
    }



    // 단건 조회
    public OptionDto.Response getOne(Long id) throws Exception{

        Optional<OptionEntity> entity =  optionRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return  modelMapper.map(entity.get(), OptionDto.Response.class);
    }

    // 등록
    public OptionDto.Response create(OptionDto.common request) throws Exception {
        // sortEncoding
        OptionEntity entity = modelMapper.map(request, OptionEntity.class);

        OptionEntity savedEntity = optionRepository.save(entity);
        return modelMapper.map(savedEntity , OptionDto.Response.class);
    }



    // 수정
    public OptionDto.Response update(Long id , OptionDto.UpdateRequest request) throws Exception {
        Optional<OptionEntity> entityOptional = optionRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }

        OptionEntity entity = entityOptional.get();

        modelMapper.map(request, entity);             // 나머지 필드 업데이트
        OptionEntity updatedEntity = optionRepository.save(entity);

        return modelMapper.map(updatedEntity, OptionDto.Response.class);
    }

    // 삭제
    public String delete(Long id) throws Exception {
        Optional<OptionEntity> entity = optionRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        optionRepository.delete(entity.get());
        return id + "번 옵션이 삭제 되었습니다.";
    }

}