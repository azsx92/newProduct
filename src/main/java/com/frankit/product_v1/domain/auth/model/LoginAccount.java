package com.frankit.product_v1.domain.auth.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginAccount {
  private String username;
  private String displayName;
  private Long stayId;
  private Long partnerId;
  private String auth;
  private String kind;
}
