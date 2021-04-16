package com.example.superwishlistgr4.controller;

import com.example.superwishlistgr4.data.DataFacadeImpl;
import com.example.superwishlistgr4.domain.LogInController;
import com.example.superwishlistgr4.domain.SQLexceptionhandler;
import com.example.superwishlistgr4.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@org.springframework.stereotype.Controller
public class FrontController {

    private LogInController loginController = new LogInController(new DataFacadeImpl());

    private void setSessionInfo(WebRequest request, User user) {
        // Place user info on session
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("id", user.getId(), WebRequest.SCOPE_SESSION);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/create_user_form")
    public String create_user_form(){
        return "create_user_form";
    }
    @GetMapping("/wishlist")
    public String wishlist(){
        return "wishlist";
    }
    // postmapping sender "dit" tavleopslag videre.
    @PostMapping("/submit_create_user_form")
    public String post(@RequestParam("username") String username, @RequestParam("passwordwish") String passwordwish)
    {
        //User user = new User(username,password); ------------ ???

        return "redirect:/wishlist";
    }
    @PostMapping("/login")
    public String User(WebRequest request) throws SQLexceptionhandler {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = loginController.login(username, password);
        setSessionInfo(request, user);

        return "login";
    }
}