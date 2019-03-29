package com.example.demo.controller;

import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/addMessage")
    public boolean addMessage(String username,String text,int pid){
        return messageService.addMessage(username,text,pid);
    }

    @GetMapping(value = "/findMessage")
    public String findMessage(){
//        Gson gson=new Gson();
//        return gson.toJson(messageService.findAllMessages());
        return messageService.findAllMessages().toString();
    }
}
