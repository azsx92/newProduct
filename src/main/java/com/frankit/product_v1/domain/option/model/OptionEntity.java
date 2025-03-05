package com.frankit.product_v1.domain.option.model;


import com.frankit.product_v1.common.enums.code.OptionTypeEnum;
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
@Table(name = "option")
public class OptionEntity extends BaseCommEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 상품 아이디 (Primary Key), 자동 증가

    @Column(name = "option_group_id")
    private Long optionGroupId; // 옵션 그룹 아이디
    
    @Column(name = "option_name", nullable = false, length = 255)
    private String optionName; // 옵션 명

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OptionTypeEnum optionType;
}
