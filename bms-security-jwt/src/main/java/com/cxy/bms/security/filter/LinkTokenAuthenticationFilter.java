package com.cxy.bms.security.filter;

import com.cxy.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenxy
 * @date 2020/4/28 11:08
 * @desc 实现了对请求的拦截，获取http头上的Authorization元素，token码就在这个键里，我们的token都是采用通用的Bearer开头，当你的token没有过期时，会
 *          存储在redis里，key就是用户名的md5码，而value就是用户名，当拿到token之后去数据库或者缓存里拿用户信息进行授权即可。
 */
@Slf4j
@Component
public class LinkTokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserDetailsService userDetailsService;


    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 获取http头上的Authorization元素
        String authHeader = httpServletRequest.getHeader(Constants.TOKEN_HEADER);
        if(authHeader != null && authHeader.startsWith(Constants.TOKEN_HEAD)){
            final String authToken = authHeader.substring(authHeader.length()); // The part after "BMS_SECURITY_TOKEN_"
            if(authToken != null && redisTemplate.hasKey(authToken)){
                String username = redisTemplate.opsForValue().get(authToken);

                if(username != null && SecurityContextHolder.getContext().getAuthentication() != null){
                    UserDetails details = userDetailsService.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                    log.info("LinkTokenAuthenticationFilter.doFilterInternal(); authenticated user [{}],setting security context", username);

                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }

            }


        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
