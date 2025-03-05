package com.frankit.product_v1.domain.admin.service;



import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.admin.model.AdminDto;
import com.frankit.product_v1.domain.admin.model.AdminEntity;
import com.frankit.product_v1.domain.admin.repository.AdminRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    // 목록 조회
    public List<AdminEntity> getList() throws Exception{
        try {

            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
    }

    // 조회 :AdminId
    public AdminEntity get(String username) throws Exception {
        try {
            return repository.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
    }

    // 조회 :LoginId
    public AdminEntity getOneByLoginId(String loginId) throws Exception {
        try {
            return repository.findByUsername(loginId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ErrorCode.RESPONSE_FAIL_SEARCH);
        }
    }

    // 등록
    public AdminEntity create(AdminEntity request) throws Exception {
        try {
            request.setPassword(passwordEncoder.encode(request.getPassword()));

            return repository.save(modelMapper.map(request, AdminEntity.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ErrorCode.RESPONSE_FAIL_INSERT);
        }
    }

    // 수정
    public AdminEntity update(AdminEntity request) throws Exception {
        try {
            return repository.save(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
    }

    // 수정 : 비번변경
    public AdminEntity updatePassword(@Valid AdminDto.UpdateAdmin request) throws Exception {
        try {
            AdminEntity entity = repository.findByUsername(request.getUsername());
            entity.setPassword(passwordEncoder.encode(request.getPassword()));
            return repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
    }

    // 삭제
    public boolean delete(String username) throws Exception {
        try {
            return repository.deleteByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ErrorCode.RESPONSE_FAIL_UPDATE);
        }
    }
    }