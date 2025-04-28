package com.example.Database_assign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContenController {

    @GetMapping("/")
    public String home(){
        return "HomePage";
    }

    @GetMapping("/login")
    public String login(){
        return "LoginPage";
    }

    @GetMapping("/admin")
    public String AdminPage(){
        return "AdminPage";
    }
}
