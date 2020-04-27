package com.cxy.bms.manage.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenxy
 * @date 2020/4/27 16:28
 * @desc this is description
 */
@Component
public class ManageAuthenticationSucessHandler implements AuthenticationSuccessHandler {
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletRequest.setAttribute("authentication",authentication);
        httpServletRequest.getRequestDispatcher("/declare/login_success").forward(httpServletRequest,httpServletResponse);
    }
}
