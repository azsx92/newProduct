package com.frankit.product_v1.domain.optionValueMapping.repository;


import com.frankit.product_v1.domain.optionValueMapping.model.OptionValueMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionValueMappingRepository extends JpaRepository<OptionValueMappingEntity,Long> {

}


