package com.frankit.product_v1.domain.option.repository;



import com.frankit.product_v1.domain.option.model.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<OptionEntity,Long> {

}


