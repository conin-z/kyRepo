package com.example.dao;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @user KyZhang
 * @date
 */
@Repository
public interface UserDAO {

    void save(User user);

    //在mybatis中传递多个参数需要参数的绑定
    User login(@Param("username") String username, @Param("password") String password);
}
