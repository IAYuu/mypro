package com.jelly.tic.security;

import com.jelly.tic.entity.Role;
import com.jelly.tic.entity.User;
import com.jelly.tic.entity.UserRole;
import com.jelly.tic.service.RoleService;
import com.jelly.tic.service.UserRoleService;
import com.jelly.tic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// 注入用户信息和权限
@Service("userDetailService")
public class CustomUserDetailsService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // 从数据库得到用户信息
        User user = userService.getUserByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        List<UserRole> userRoles = userRoleService.getByUserId(user.getId());

        logger.info(userRoles.toString());

        for (UserRole userRole : userRoles) {
            Role role = roleService.getById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }
}
