package com.example.demo;

import com.example.demo.dao.MessageDao;
import com.example.demo.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MessageDao messageDao;
    @Test
    public void testLogin(){
        System.out.println(this.userDao.login("test","123").toString());
    }

    @Test
    public void testAddMessage(){
        System.out.println(this.messageDao.addMessage("test","test",1));
    }

    @Test
    public void testFindMessageByPid(){
        System.out.println(this.messageDao.findMessageByPid(1));
    }
    @Test
    public void contextLoads() {
    }

}
