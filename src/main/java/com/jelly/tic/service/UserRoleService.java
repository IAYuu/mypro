package com.jelly.tic.service;

import com.jelly.tic.entity.UserRole;
import com.jelly.tic.mapper.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<UserRole> getByUserId(Long userId) {
        return userRoleMapper.getByUserId(userId);
    }

    public void insert(Long userId, Long roleId) {
        userRoleMapper.insert(userId, roleId);
    }

}
