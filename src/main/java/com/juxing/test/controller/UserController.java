package com.juxing.test.controller;


import com.juxing.test.common.util.FileUtil;
import com.juxing.test.common.vo.R;
import com.juxing.test.pojo.User;
import com.juxing.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("register.do")
//    public R login(User user) {
//        return userService.register(user);
//    }

    @PostMapping("register.do")
    public R pic(@RequestParam("pp") CommonsMultipartFile multipartFile, HttpServletRequest request,User user) throws IOException {
        if (!multipartFile.isEmpty()) {
            //文件夹
            File file = new File("e:/temp/pf_Img");
            if (!file.exists()) {
                file.mkdirs();
            }
            //需要存储的文件对象
            File tarFile = new File(file, FileUtil.getFileName(multipartFile.getOriginalFilename()));
            //存储到服务器
            multipartFile.transferTo(tarFile);
            user.setPic(tarFile.getName());
            System.out.println("文件上传路径：" + tarFile.getAbsolutePath());

        }
        return userService.save(user);
    }


}
