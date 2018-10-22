package com.juxing.test.main;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2018/10/18 10
 * @Description:
 */
public class SuperTest extends Date {

    private  void test(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        new SuperTest().test();
    }

}
