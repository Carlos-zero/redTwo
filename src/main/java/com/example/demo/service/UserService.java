package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;

//    private static User user;
//    static {
//        user=new User();
//    }
//    一个美好的想法   -已经成为现实
//    @Autowired
//    private User user;
    public String addUserService(String username,String password){
        Boolean res=false;
        user.setUsername(username);
        user.setPassword(password);
        res=userDao.addUser(user);
        if (res!=false){
            return "注册用户成功！";
        }else {
            return "注册用户失败！";
        }
    }

    public String loginService(String username,String password){
        user=null;
        user=userDao.login(username,password);
        if (user!=null){
            return "登录成功！";
        }else {
            return "登录失败！";
        }
    }
}
