package com.example.superwishlistgr4.data;

import com.example.superwishlistgr4.domain.DataFacade;
import com.example.superwishlistgr4.domain.SQLexceptionhandler;
import com.example.superwishlistgr4.domain.User;

public class DataFacadeImpl implements DataFacade {
    private UserMapper userMapper = new UserMapper();

    public User login(String username, String password) throws SQLexceptionhandler {
        return userMapper.login(username, password);
    }

    public User createrUser(User user) throws SQLexceptionhandler {
        userMapper.createUser(user);
        return user;
    }
}
