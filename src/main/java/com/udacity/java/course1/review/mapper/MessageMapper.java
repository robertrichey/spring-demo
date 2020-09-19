package com.udacity.java.course1.review.mapper;

import com.udacity.java.course1.review.model.ChatMessage;
import com.udacity.java.course1.review.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE messageid = #{id}")
    User findUser(Integer id);

    @Insert("INSERT INTO MESSAGES (username, message) VALUES " +
            "(#{username}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    Integer insert(ChatMessage chatMessage);

    @Delete("DELETE FROM MESSAGES WHERE messageid = #{id}")
    void delete(Integer id);
}
