package com.frankit.product_v1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "nicepg")
public class NicepgConfig {

    @Value("wechat-mid")
    String wechatMid;

    @Value("wechat-pid")
    String wechatPid;


    @Value("alipay-plus-mid")
    String alipayPlusMid;

    
    @Value("alipay-plus-pid")
    String alipayPlusPid;

}