package com.example.superwishlistgr4.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class FrontController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
