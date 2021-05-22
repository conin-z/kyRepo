package com.example.service;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @user KyZhang
 * @date
 */
public interface UserService {
    void save(User user);

    //在mybatis中传递多个参数需要参数的绑定
    User login(@Param("username") String username, @Param("password") String password);
}
