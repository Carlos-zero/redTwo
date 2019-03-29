package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public String addUser(String username,String password){
        return userService.addUserService(username,password);
    }

    @GetMapping(value = "/login")
    public String login(String username,String password){
        return userService.loginService(username,password);
    }
}
