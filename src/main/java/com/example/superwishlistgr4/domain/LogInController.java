package com.example.superwishlistgr4.domain;

import com.example.superwishlistgr4.data.DataFacadeImpl;


public class LogInController {
    // facade to datasource layer
    private DataFacade facade = null;

    public LogInController(DataFacade facade) {
        this.facade = facade;
    }

    public User login(String username, String password) throws SQLexceptionhandler {
        return facade.login(username, password);
    }

    public User createUser(String username, String password, int id) throws SQLexceptionhandler {
        // By default, new users are customers
        User user = new User(username, password, id);
        facade.createUser(user);
        return user;
    }
}

