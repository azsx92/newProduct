package com.frankit.product_v1.domain.user.model;

import com.frankit.product_v1.common.model.BaseCommEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserEntity extends BaseCommEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 고유 식별자 (Primary Key), 자동 증가

    @Column(name = "login_id", nullable = false, length = 255)
    private String loginId; // 사용자 로그인 ID 이메일로 로그인 (중복 불가)

    @Column(name = "password", nullable = false, length = 255)
    private String password; // 사용자 비밀번호 (암호화된 형태로 저장)

    @Column(name = "mobile", nullable = false, length = 255)
    private String mobile; // 사용자의 휴대전화 번호


    @Column(name = "name", length = 255)
    private String name; // 사용자의 이름 (선택 입력)


    @Column(name = "state", nullable = false, length = 255)
    private String state; // 계정 상태 (예: 활성, 비활성)


}
