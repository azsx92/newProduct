package com.frankit.product_v1.domain.optionGroup.model;


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
@Table(name = "option_group")
public class OptionGroupEntity extends BaseCommEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 상품 아이디 (Primary Key), 자동 증가

    @Column(name = "product_id")
    private Long productId; // 상품 아이디
    
    @Column(name = "name", nullable = false, length = 255)
    private String name; // 옵션 그룹 명
    
}
