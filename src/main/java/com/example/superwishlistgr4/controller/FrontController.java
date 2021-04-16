package com.example.superwishlistgr4.controller;

import org.apache.tomcat.jni.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class FrontController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/create_user_form")
    public String create_user_form(){
        return "create_user_form";
    }
    @GetMapping("wishlist")
    public String wishlist(){
        return "wishlist";
    }
    // postmapping sender "dit" tavleopslag videre.
    @PostMapping("/submitform")
    public String post(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        //User user = new User(username,password); ------------ ???

        return "redirect:/succes";
    }
}