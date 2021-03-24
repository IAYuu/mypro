package com.jelly.tic.mapper;

import com.jelly.tic.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper {

    @Select("SELECT * FROM user_role WHERE userId = #{userId}")
    List<UserRole> getByUserId(Long userId);

    // 普通用户注册
    @Insert("INSERT INTO user_role(userId, roleId) VALUES (#{userId}, #{roleId})")
    void insert(Long userId, Long roleId);
}
