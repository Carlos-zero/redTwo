package com.example.demo.service;

import com.example.demo.dao.MessageDao;
import com.example.demo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private Message message;
    @Autowired
    private MessageDao messageDao;


    //插入新留言
    public boolean addMessage(String username,String test,int pid){
        return messageDao.addMessage(username,test,pid);
    }

    //查找子节点
    private List<Message> findContentChild(Message content){
        List<Message> list=messageDao.findMessageByPid(content.getId());

        for (Message message:list){
            List<Message> childList = findContentChild(message);
            message.setChildContent(childList);
        }
        return list;
    }

    //查找所有留言极其评论
    public List<Message> findAllMessages(){
        //先找到所有pid为0的留言，即留言板上无父节点的留言
        List<Message> list=messageDao.findMessageByPid(0);

        //然后找到每条留言的评论 并赋值
        for (Message message:list){
            List<Message> childList=findContentChild(message);
            message.setChildContent(childList);
        }
        return list;
    }
}
