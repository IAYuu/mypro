package com.jelly.tic.mapper;

import com.jelly.tic.entity.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select("SELECT * from role WHERE id = #{id}")
    Role getById(Long id);
}
