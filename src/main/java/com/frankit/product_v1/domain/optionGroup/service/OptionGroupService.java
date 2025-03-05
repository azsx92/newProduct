package com.frankit.product_v1.domain.optionGroup.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.optionGroup.model.OptionGroupDto;
import com.frankit.product_v1.domain.optionGroup.model.OptionGroupEntity;
import com.frankit.product_v1.domain.optionGroup.repository.OptionGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OptionGroupService {

    private final OptionGroupRepository optionGroupRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;


    // 목록 조회
    public List<OptionGroupDto.Response> getList( ) throws Exception{
        List<OptionGroupEntity> list = optionGroupRepository.findAll();
        log.info("list: {}" , list);

        return list.stream().map(entity -> modelMapper.map(entity, OptionGroupDto.Response.class)).toList();
    }



    // 단건 조회
    public OptionGroupDto.Response getOne(Long id) throws Exception{

        Optional<OptionGroupEntity> entity =  optionGroupRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return  modelMapper.map(entity.get(), OptionGroupDto.Response.class);
    }

    // 등록
    public OptionGroupDto.Response create(OptionGroupDto.common request) throws Exception {
        // sortEncoding
        OptionGroupEntity entity = modelMapper.map(request, OptionGroupEntity.class);

        OptionGroupEntity savedEntity = optionGroupRepository.save(entity);
        return modelMapper.map(savedEntity , OptionGroupDto.Response.class);
    }



    // 수정
    public OptionGroupDto.Response update(Long id , OptionGroupDto.UpdateRequest request) throws Exception {
        Optional<OptionGroupEntity> entityOptional = optionGroupRepository.findById(id);
        if (entityOptional.isEmpty()) {
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }

        OptionGroupEntity entity = entityOptional.get();

        modelMapper.map(request, entity);             // 나머지 필드 업데이트
        OptionGroupEntity updatedEntity = optionGroupRepository.save(entity);

        return modelMapper.map(updatedEntity, OptionGroupDto.Response.class);
    }

    // 삭제
    public String delete(Long id) throws Exception {
        Optional<OptionGroupEntity> entity = optionGroupRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        optionGroupRepository.delete(entity.get());
        return id + "번 옵션 그룹이 삭제 되었습니다.";
    }

}