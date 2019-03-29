package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Message {
    //这条留言的id
    private int id;
    //父节点的id
    private int pid;
    //用户名
    private String username;
    //留言内容
    private String text;
    //子节点
    private List<Message> childContent;

    //自己提供一个构造方法后编译器不提供默认的无参构造器，这里补上
    public Message() {
    }

    public Message(int pid, String username, String text) {
        this.pid = pid;
        this.username = username;
        this.text = text;
    }
}
