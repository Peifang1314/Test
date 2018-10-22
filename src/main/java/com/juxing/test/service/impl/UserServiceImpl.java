package com.juxing.test.service.impl;

import com.juxing.test.common.vo.R;
import com.juxing.test.mapper.UserMapper;
import com.juxing.test.pojo.User;
import com.juxing.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 模糊查询用户
     * @param text
     * @return
     */
    @Override
    public R query(String text) {
        User user = userMapper.selectByText(text);
        if (null != user){
            return new R(1,"success",user);
        }else {
            return new R(0,"未查找到",null);
        }
    }
//    电话号码检测
    @Override
    public R telCheck(int tel) {
        Integer i=userMapper.selectByTel(tel);
        if (null==i){
            return new R(0,"未找到该号码",null);
        }else {
            return new R(1,"号码已存在",null);
        }
    }

    //注册
    @Override
    public R save(User user) {
        if (userMapper.insert(user)> 0) {
            return new R(1,"success",null);
        }else {
            return new R(0,"error",null);
        }



    }
}
