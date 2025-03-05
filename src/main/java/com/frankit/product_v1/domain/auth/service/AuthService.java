package com.frankit.product_v1.domain.auth.service;



import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.enums.admin.AdminTypeEnum;
import com.frankit.product_v1.common.enums.code.UserStateEnum;
import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.domain.admin.model.AdminEntity;
import com.frankit.product_v1.domain.admin.repository.AdminRepository;
import com.frankit.product_v1.domain.auth.model.AuthRegisterRequestDto;
import com.frankit.product_v1.domain.auth.model.AuthRequestDto;
import com.frankit.product_v1.domain.auth.model.AuthResponseDto;
import com.frankit.product_v1.domain.user.repository.UserRepository;
import com.frankit.product_v1.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final AdminRepository repository;
    private final JwtTokenUtil jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    private final UserRepository userRepository;

    public AuthResponseDto register(AuthRegisterRequestDto request) throws Exception {
        System.out.println("request.getUsername() : "+request.getLoginId());
        AdminEntity entity=repository.findByUsername(request.getLoginId());
        if(entity!=null){
            throw new BaseException(ErrorCode.EMPTY_LOGIN_DUPLICATION);
        }

        var admin = AdminEntity.builder()
                .username(request.getLoginId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .state(UserStateEnum.ACTIVATED.getCode())
                .auth(AdminTypeEnum.ADMIN_TYPE_USER.getCode())
                .kind("USER")
                .build();

        AdminEntity user = repository.save(admin);
        String jwtToken = jwtService.generateToken(user);

        AuthResponseDto authResponseDto = AuthResponseDto
                .builder()
                .token(jwtToken)
                .build();

        log.info("AuthService.register.authResponseDto :: {}",authResponseDto);

        return authResponseDto;
    }


    public AuthResponseDto authenticate(AuthRequestDto request) throws Exception {

        System.out.println("request.getPassword() : "+request.getPassword());
        System.out.println("request.getUsername() : "+request.getUsername());
        modelMapper.map(request, AuthResponseDto.class);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                )
        );

        var user = repository.findByUsername(request.getUsername());
        String jwtToken = jwtService.generateToken(user);
        return AuthResponseDto.builder()
                .token(jwtToken)
                .build();
    }


}


