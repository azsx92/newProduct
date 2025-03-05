package com.frankit.product_v1.domain.optionValue.repository;




import com.frankit.product_v1.domain.optionValue.model.OptionValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionValueRepository extends JpaRepository<OptionValueEntity,Long> {

}


