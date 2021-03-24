package com.jelly.tic.mapper;

import com.jelly.tic.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getById(Long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getByName(String username);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO user (username, password) VALUES (#{user.username}, #{user.password})")
    void insert(User user);

    @Update("UPDATE user SET password = #{password}")
    void updatePassword(String password);

    // update
//    @Update("UPDATE users SET name = #{user.name}, password = #{user.password}")
//    void update(@Param("user"), User user);
}
