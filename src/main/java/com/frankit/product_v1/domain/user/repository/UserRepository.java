package com.frankit.product_v1.domain.user.repository;

import com.frankit.product_v1.domain.user.model.UserDto;
import com.frankit.product_v1.domain.user.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {






  @Query("SELECT a " +
          "FROM UserEntity a " +
          "WHERE (COALESCE(:#{#request.state?.toString()}, 'ACTIVATED') = a.state) " + // ✅ 기본값 적용
          "AND (:#{#request.createdAt} IS NULL OR CAST(a.createdAt AS string) LIKE CONCAT('%', :#{#request.createdAt}, '%')) " +
          "AND (:#{#request.mobile} IS NULL OR a.mobile LIKE CONCAT('%', :#{#request.mobile}, '%'))  " +
          "ORDER BY a.id DESC")
  Page<UserEntity> findSearchAll(
          @Param("request") UserDto.SearchRequest request,
          Pageable pageable);
}


