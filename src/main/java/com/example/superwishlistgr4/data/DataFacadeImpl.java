package com.example.superwishlistgr4.data;

import com.example.superwishlistgr4.model.DataFacade;
import com.example.superwishlistgr4.model.SQLexceptionhandler;
import com.example.superwishlistgr4.model.User;

public class DataFacadeImpl implements DataFacade {
    private UserMapper userMapper = new UserMapper();

    public User login(String username, String passwordwish) throws SQLexceptionhandler {
        return userMapper.login(username, passwordwish);
    }

    public User createUser(User user) throws SQLexceptionhandler {
        userMapper.createUser(user);
        return user;
    }
}
