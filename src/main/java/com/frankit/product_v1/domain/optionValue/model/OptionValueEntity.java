package com.frankit.product_v1.domain.optionValue.model;


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
@Table(name = "option_value")
public class OptionValueEntity extends BaseCommEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 상품 아이디 (Primary Key), 자동 증가

    
    @Column(name = "option_value", nullable = false, length = 255)
    private String optionValue; // 옵션 값


}
