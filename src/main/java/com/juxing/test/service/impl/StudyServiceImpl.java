package com.juxing.test.service.impl;

import com.juxing.test.common.vo.R;
import com.juxing.test.mapper.StudyMapper;
import com.juxing.test.pojo.Study;
import com.juxing.test.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2018/10/22 16
 * @Description:
 */


@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StudyMapper studyMapper;

    @Override
    public R insert(Study study) {
        if(studyMapper.insert(study)>0){
            return new R(1,"success",null);
        }else {
            return new R(0,"error",null);
        }
    }
}
