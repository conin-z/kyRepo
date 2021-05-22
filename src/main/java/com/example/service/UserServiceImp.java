package com.example.service;

import com.example.bean.User;
import com.example.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @user KyZhang
 * @date
 */
@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        String s = UUID.randomUUID().toString();
        user.setId(Integer.valueOf(s.substring(0,5),16));
        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userDAO.login(username, password);
        return user;
    }
}
