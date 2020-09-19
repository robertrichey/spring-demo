package com.udacity.java.course1.review.mapper;

import com.udacity.java.course1.review.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE userid = #{userId}")
    User findUser(Integer userId);

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES " +
            "(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    Integer insert(User user);

    @Delete("DELETE FROM USERS WHERE userid = #{userId}")
    void delete(Integer userId);
}
