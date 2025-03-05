package com.frankit.product_v1.domain.user.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.user.model.UserDto;
import com.frankit.product_v1.domain.user.model.UserEntity;
import com.frankit.product_v1.domain.user.repository.UserRepository;
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
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    // 목록 조회
    public List<UserDto.Response> getList(UserDto.SearchRequest request , Pageable pageable) throws Exception{
        System.out.println("request: {}" + request);

        Page<UserEntity> list = userRepository.findSearchAll(request, pageable);
        log.info("list: {}" , list);
        return list.map(entity -> modelMapper.map(entity, UserDto.Response.class)).toList();
    }



    // 단건 조회
    public UserDto.Response getOne(Long id) throws Exception{

        Optional<UserEntity> entity =  userRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
        return  modelMapper.map(entity.get(), UserDto.Response.class);
    }

    // 등록
    public UserDto.Response create(UserDto.common request) throws Exception {
        // sortEncoding
        UserEntity entity = modelMapper.map(request, UserEntity.class);

        UserEntity savedEntity = userRepository.save(entity);
        return modelMapper.map(savedEntity , UserDto.Response.class);
    }



    // 수정
    public UserDto.Response update(UserDto.UpdateRequest request) throws Exception {
        Optional<UserEntity> entityOptional = userRepository.findById(request.getId());
        if (entityOptional.isEmpty()) {
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }

        UserEntity entity = entityOptional.get();

        modelMapper.map(request, entity);             // 나머지 필드 업데이트
        UserEntity updatedEntity = userRepository.save(entity);

        return modelMapper.map(updatedEntity, UserDto.Response.class);
    }

    // 삭제
    public boolean delete(Long id) throws Exception {
        Optional<UserEntity> entity = userRepository.findById(id);
        if(entity.isEmpty()){
            throw new BaseException(ErrorCode.RESPONSE_FAIL_DELETE);
        }
        userRepository.delete(entity.get());
        return true;
    }

}