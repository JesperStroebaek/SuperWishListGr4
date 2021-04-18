package com.example.superwishlistgr4.controller;

import com.example.superwishlistgr4.data.DataFacadeImpl;
import com.example.superwishlistgr4.data.WishListMapper;
import com.example.superwishlistgr4.model.SQLexceptionhandler;

import com.example.superwishlistgr4.model.User;
import com.example.superwishlistgr4.model.Wish;
import com.example.superwishlistgr4.model.Wishlist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;

@org.springframework.stereotype.Controller
public class FrontController {

    private LogInController loginController = new LogInController(new DataFacadeImpl());

    private void setSessionInfo(WebRequest request, User user) {
        // Place user info on session
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("id", user.getId(), WebRequest.SCOPE_SESSION);
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/create_user_form")
    public String create_user_form(){
        return "create_user_form";
    }
    @PostMapping("/submit_create_user_form")
    public String User(WebRequest request) throws SQLexceptionhandler {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = loginController.login(username, password);
        setSessionInfo(request, user);
        return "redirect:/create_user_form_succes";
    }

    @GetMapping("/create_user_form_succes")
    public String create_user_form_succes(){
        return "create_user_form_succes";
    }
    @PostMapping("/login")
    public String login(){
        return "/login";
    }
    @GetMapping("createwishlist")
    public String createWishlist(){
        return "redirect:/create_wishlist_form";
    }
    @PostMapping("/submit_create_wish_form")
    public String wishlist(WebRequest wishlistrequest){
        String wishlistname = wishlistrequest.getParameter("wishlistname");
        String enddate = wishlistrequest.getParameter("enddate");
        Wishlist wishlist = new Wishlist(wishlistname,enddate);
        return wishlistname+enddate;
    }
}