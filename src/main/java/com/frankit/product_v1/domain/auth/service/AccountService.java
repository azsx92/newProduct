package com.frankit.product_v1.domain.auth.service;

import com.frankit.product_v1.domain.auth.model.LoginAccount;
import com.frankit.product_v1.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Service
public class AccountService {
  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  public LoginAccount getLoginAccount() {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    String jwtKeyAuthHeader = request.getHeader("Authorization");

    jwtKeyAuthHeader = jwtKeyAuthHeader.replace("Bearer ", "");
    return jwtTokenUtil.getAccount(jwtKeyAuthHeader);
  }
}
