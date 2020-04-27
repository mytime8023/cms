package com.cxy.bms.manage.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenxy
 * @date 2020/4/27 14:51
 * @desc this is description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDeclare implements Serializable {

    private static final long serialVersionUID = 3497935890426858541L;

    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;


}
