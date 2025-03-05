package com.frankit.product_v1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "kovan")
public class KovanConfig {

    @Value("mid")
    String mid;

    @Value("baseUrl")
    String baseUrl;

    @Value("secretKey")
    String secretKey;

    @Value("mid-noauth")
    String midNoAuth;

    @Value("secretKey-noauth")
    String secretKeyNoAuth;

    @Value("mid-global")
    String midGlobal;

    @Value("secretKey-global")
    String secretKeyGlobal;
}