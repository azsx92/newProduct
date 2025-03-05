package com.frankit.product_v1.domain.admin.repository;



import com.frankit.product_v1.domain.admin.model.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {

    public AdminEntity findByUsername(String username);
    public Optional<AdminEntity> findByName(String name);
    public boolean deleteByUsername(String username);

}


