package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import com.example.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @user KyZhang
 * @date
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session){

        User user = userService.login(username, password);
        if (user == null) {
            return "redirect:/index";
        }else{
            session.setAttribute("user", user);
            return "redirect:/emp/list";
        }
    }

    @PostMapping("/register")    //Get也没有用 不会显示 相当于与toRegist同一个界面  只不过抽离出来一些代码来后台处理  同 /toRegist
    public String regist(String code,User user,HttpSession session){
        String sesCode = (String)session.getAttribute("code");
        if(sesCode.equalsIgnoreCase(code)){
            System.out.println("saving start");
            userService.save(user);
            System.out.println("saving out");
            return "redirect:/index";
        }else{
            return "redirect:/toRegist";
        }

    }

    @GetMapping("/code")
    public void code(HttpSession session, HttpServletResponse response) throws IOException {
        ////gene
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //存入session中
        session.setAttribute("code", securityCode);
        //响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

}
