package com.juxing.test.mapper;

import com.juxing.test.pojo.User;

public interface UserMapper {

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    User selectByText(String text);

    int selectByTel(int tel);
}