package com.frankit.product_v1.common.model;



import com.frankit.product_v1.common.enums.code.OptionTypeEnum;
import com.frankit.product_v1.common.enums.code.UserStateEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class EnumService {

    // 목록 조회
    public Map<String, String> getOptionTypeEnumList() throws Exception{

        return OptionTypeEnum.toMap();

    }

    public Map<String, String> getUserStateEnumList() throws Exception{

        return UserStateEnum.toMap();

    }


}