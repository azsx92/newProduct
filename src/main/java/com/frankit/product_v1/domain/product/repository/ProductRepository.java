package com.frankit.product_v1.domain.product.repository;


import com.frankit.product_v1.domain.product.model.ProductDto;
import com.frankit.product_v1.domain.product.model.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


  @Query("SELECT a " +
          "FROM ProductEntity a " +
          "WHERE (:#{#request.name} IS NULL OR CAST(a.name AS string) LIKE CONCAT('%', :#{#request.name}, '%')) " + // ✅ 기본값 적용
          "ORDER BY a.id DESC")
  Page<ProductEntity> findSearchAll(
          @Param("request") ProductDto.SearchRequest request,
          Pageable pageable);
}


