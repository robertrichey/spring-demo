package com.udacity.java.course1.review.mapper;

import com.udacity.java.course1.review.model.ChatMessage;
import com.udacity.java.course1.review.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getMessages();

    @Select("SELECT * FROM MESSAGES WHERE username = #{username}")
    User findUser(String username);

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES " +
            "(#{username}, #{message})")
    // @Options(useGeneratedKeys = true, keyProperty = "messageid")
    @Options(useGeneratedKeys = true)
    void insert(ChatMessage chatMessage);

    @Delete("DELETE FROM MESSAGES WHERE messageid = #{id}")
    void delete(Integer id);
}
