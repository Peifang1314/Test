package com.juxing.test.mapper;

import com.juxing.test.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);

    User selectByPhone(int phone);
}