package com.frankit.product_v1.domain.optionGroup.repository;


import com.frankit.product_v1.domain.optionGroup.model.OptionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionGroupRepository extends JpaRepository<OptionGroupEntity,Long> {

}


