package com.jelly.tic.service;

import com.jelly.tic.entity.Role;
import com.jelly.tic.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public Role getById(Long id) {
        return roleMapper.getById(id);
    }
}
