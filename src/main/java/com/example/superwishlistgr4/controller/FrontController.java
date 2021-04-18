package com.example.superwishlistgr4.controller;

import com.example.superwishlistgr4.data.DataFacadeImpl;
import com.example.superwishlistgr4.model.LogInController;
import com.example.superwishlistgr4.model.SQLexceptionhandler;

import com.example.superwishlistgr4.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

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
    @GetMapping("/create_user_form_succes")
    public String create_user_form_succes(){
        return "create_user_form_succes";
    }
    // postmapping sender userdata videre.
    @PostMapping("/submit_create_user_form")
    public String post(WebRequest request)
    {
        //Retrieve values from HTML form via WebRequest
        String username = request.getParameter("username");
        String password = request.getParameter("passsword");


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
   /* @PostMapping("/login")
    public String login(){
        return "login";
    }

    */

}