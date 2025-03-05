package com.frankit.product_v1.domain.auth.model;

import com.frankit.product_v1.domain.admin.model.AdminDto;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = true)
public class AuthRequestDto extends AdminDto {
    String searchField;
    String searchValue;


}
