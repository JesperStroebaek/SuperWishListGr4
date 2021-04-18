package com.example.superwishlistgr4.domain;

public interface DataFacade {
    User login(String username, String password) throws SQLexceptionhandler;
    User createUser(User user) throws SQLexceptionhandler;
}
