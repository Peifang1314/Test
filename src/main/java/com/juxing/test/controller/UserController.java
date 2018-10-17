package com.juxing.test.controller;


import com.juxing.test.common.R;
import com.juxing.test.pojo.User;
import com.juxing.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("register.do")
    public R login(User user){
        return userService.register(user);
    }



}
