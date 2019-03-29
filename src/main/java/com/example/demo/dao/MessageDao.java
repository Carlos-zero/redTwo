package com.example.demo.dao;

import com.example.demo.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageDao {
    @Insert("Insert into message_board set username = #{username},text = #{text},pid = #{pid}")
    Boolean addMessage(@Param("username") String username,@Param("text") String text,@Param("pid") int pid);

    @Select("select * from message_board where pid = #{pid}")
    List<Message> findMessageByPid(@Param("pid") int pid);
}
