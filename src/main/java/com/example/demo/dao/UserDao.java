package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    //注册新用户
    @Insert("Insert into user set username = #{username}, " +
            "password = #{password}")
    Boolean addUser(User user);
    //登录用户
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);
}
