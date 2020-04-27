package com.cxy.bms.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxy.bms.manage.data.entity.Declare;
import com.cxy.bms.manage.data.entity.LoginDeclare;
import com.cxy.bms.manage.service.IDeclareService;
import com.cxy.bms.manage.service.ILoginDeclareService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author chenxy
 * @date 2020/4/27 14:54
 * @desc this is description
 */
@Configuration
public class LoginDeclareServiceImpl implements ILoginDeclareService {

    @Autowired
    private IDeclareService declareService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = null;

        Declare declare = declareService.getOne(new QueryWrapper<Declare>().eq("user_name", name));

        if(declare == null){
            throw new UsernameNotFoundException(name);
        }

        if(declare != null){
            declare.setPassword(this.passwordEncoder.encode(declare.getPassword()));
            LoginDeclare loginDeclare = new LoginDeclare();
            BeanUtils.copyProperties(declare,loginDeclare);
            user = new User(loginDeclare.getUserName(),loginDeclare.getPassword(),loginDeclare.isEnabled(),
                    loginDeclare.isAccountNonExpired(),loginDeclare.isCredentialsNonExpired(),loginDeclare.isAccountNonLocked(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
            return user;
        }

        return null;
    }
}
