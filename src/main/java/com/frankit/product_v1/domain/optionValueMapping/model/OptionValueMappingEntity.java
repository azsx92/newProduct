package com.frankit.product_v1.domain.optionValueMapping.model;


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
@Table(name = "option_value_mapping")
public class OptionValueMappingEntity extends BaseCommEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 옵션 밸류 매핑 아이디 (Primary Key), 자동 증가

    @Column(name = "option_id")
    private Long optionId; // 옵션 아이디
    @Column(name = "option_value_id")
    private Long optionValueId; // 옵션 값 아이디


}
