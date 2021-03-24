package com.jelly.tic.service;

import com.jelly.tic.entity.User;
import com.jelly.tic.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.getById(id);
    }

    public User getUserByName(String username) {
        return userMapper.getByName(username);
    }

    // TODO: 2021/3/13  判断是否已经注册
    public void register(User user) {
        userMapper.insert(user);
    }

    public void updatePassword(String password) {
        userMapper.updatePassword(password);
    }

    public void signIn(User user) {

    }

    public void signOut(User user) {

    }

}
