package com.example.herokusample;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT id, name FROM users")
    List<User> selectAll();
}
