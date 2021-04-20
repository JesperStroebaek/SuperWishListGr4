package com.example.superwishlistgr4.model;

import com.example.superwishlistgr4.model.DataFacade;
import com.example.superwishlistgr4.model.SQLexceptionhandler;
import com.example.superwishlistgr4.model.User;


public class LogInHandler {
    // facade to datasource layer
    private DataFacade facade = null;

    public LogInHandler(DataFacade facade) {
        this.facade = facade;
    }

    public User login(String username, String password) throws SQLexceptionhandler {
        return facade.login(username, password);
    }

    public User user(String username, String password, int id) throws SQLexceptionhandler {
        // By default, new users are customers
        User user = new User(username, password, id);
        facade.createUser(user);
        return user;
    }
}


