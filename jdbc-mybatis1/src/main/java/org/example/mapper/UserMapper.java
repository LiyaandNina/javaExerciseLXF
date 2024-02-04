package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.User;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getById(@Param("id") Long id);

    @Select("SELECT * FROM users WHERE email = #{email}")
    User getByEmail(@Param("email") String email);

    @Select("SELECT * FROM users LIMIT #{offset}, #{maxResults}")
    List<User> getAll(@Param("offset") int offset, @Param("maxResults") int maxResults);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO users (email, password, name, createdAt) " +
            "VALUES (#{user.email}, #{user.password}, #{user.name}, #{user.createdAt})")
    void insert(@Param("user") User user);

    @Update("UPDATE users SET name = #{user.name}, createAt = #{user.createAt} WHERE id = #{user.id}")
    void update(@Param("user") User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(@Param("id") Long id);
}
