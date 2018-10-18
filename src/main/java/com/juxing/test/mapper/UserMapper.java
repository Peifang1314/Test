package com.juxing.test.mapper;

import com.juxing.test.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insert(User record);

}