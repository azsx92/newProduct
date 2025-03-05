package com.frankit.product_v1.domain.product.model;


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
@Table(name = "product")
public class ProductEntity extends BaseCommEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 상품 아이디 (Primary Key), 자동 증가

    @Column(name = "name", nullable = false, length = 255)
    private String name; // 상품 이름
    
    @Lob
    @Column(name = "description", nullable = false, length = 255)
    private String description; // 상품 설명

    @Column(name = "price", nullable = false, length = 255)
    private int price; // 상품 가격



}
