package com.juxing.test.mapper;

import com.juxing.test.pojo.Study;

public interface StudyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Study record);

    Study selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Study record);
}