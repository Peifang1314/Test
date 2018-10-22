package com.juxing.test.controller;

import com.juxing.test.common.util.FileUtil;
import com.juxing.test.common.vo.R;
import com.juxing.test.miaodiyun.httpApiDemo.IndustrySMS;
import com.juxing.test.miaodiyun.httpApiDemo.common.RandUtil;
import com.juxing.test.pojo.User;
import com.juxing.test.service.StudyService;
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

    @Autowired
    private StudyService studyService;

//    @RequestMapping("register.do")
//    public R login(User user) {
//        return userService.register(user);
//    }

//    文件图片上传
//    public R pic(@RequestParam("pp") CommonsMultipartFile multipartFile, HttpServletRequest request, User user) throws IOException {
//        if (!multipartFile.isEmpty()) {
//            //文件夹
//            File file = new File("e:/temp/pf_Img");
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//            //需要存储的文件对象
//            File tarFile = new File(file, FileUtil.getFileName(multipartFile.getOriginalFilename()));
//            //存储到服务器
//            multipartFile.transferTo(tarFile);
//            user.setPic(tarFile.getName());
//            System.out.println("文件上传路径：" + tarFile.getAbsolutePath());
//
//        }
//        return userService.save(user);
//    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("register.do")
    public R register(User user){
        return userService.save(user);
    }

    /**
     * 模糊查询（电话或手机号）
     * @param text
     * @return
     */
    @RequestMapping("getUser.do")
    public R getUser(String text){
        return userService.query(text);
    }

    /**
     * 检查电话号码是否已被注册
     * @param tel
     * @return 0，未找到号码，可以使用；1，号码已被注册
     */
    @RequestMapping("telCheck.do")
    public R telCheck(int tel){
        return userService.telCheck(tel);
    }

    @RequestMapping("getCode.do")
    public void getCode(String tel){
        String i=RandUtil.getRandNum();
        String smsContent = "【千峰教育】您的验证码为" + i + "，请于2分钟内正确输入，如非本人操作，请忽略此短信。";



        IndustrySMS.execute(tel,smsContent);
    }

}
