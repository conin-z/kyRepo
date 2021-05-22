package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @user KyZhang
 * @date
 */
@Controller
public class IndexController {

    @GetMapping("/index")   //门户
    public String login(){
        return "ems/login";
    }

    @GetMapping("/toSave")  //管理界面的门户  //其实不安全
    public String toList(){
        return "ems/addEmp";
    }

    @GetMapping("/toRegist") //注册
    public String toRegist(){
        return "ems/regist";
    }

}
