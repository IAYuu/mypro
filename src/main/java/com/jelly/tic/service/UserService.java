package com.jelly.tic.service;

import com.jelly.tic.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    final Logger logger = LoggerFactory.getLogger(getClass());

//    public User findByUsername(User user);
//
//    public User findUserById(String userId);

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<User> userRowMapper = new BeanPropertyRowMapper<>(User.class);

    // TODO: 2021/3/13  判断是否已经注册
    public boolean register(User user) {
        // 注册成功
        if (1 == jdbcTemplate.update("INSERT into local_auth(name, password) values (?, ?)",
                user.getName(), user.getPassword()))
            return true;
        return false;
    }

    public void signIn(User user) {
        jdbcTemplate.update("");

    }

    public void signOut(User user) {

    }

}
