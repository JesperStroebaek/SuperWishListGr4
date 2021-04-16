package com.example.superwishlistgr4.domain;

public interface DataFacade {
    public User login(String username, String password) throws SQLexceptionhandler;
    public User createUser(User user) throws SQLexceptionhandler;
}
