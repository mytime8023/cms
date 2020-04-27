package com.cxy.bms.manage.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenxy
 * @date 2020/4/27 16:48
 * @desc this is description
 */
@Component
public class ManageAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println(e);
        httpServletRequest.setAttribute("authenticationException", e.getMessage());
        httpServletRequest.getRequestDispatcher("/declare/login_failure").forward(httpServletRequest,httpServletResponse);
    }
}
