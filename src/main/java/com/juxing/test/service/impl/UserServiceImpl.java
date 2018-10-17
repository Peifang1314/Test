package com.juxing.test.service.impl;

import com.juxing.test.common.R;
import com.juxing.test.mapper.UserMapper;
import com.juxing.test.pojo.User;
import com.juxing.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //注册
    @Override
    public R register(User user) {
        if (userMapper.insert(user)> 0) {
            return new R(1,"success",null);
        }else {
            return new R(0,"error",null);
        }



    }
}
