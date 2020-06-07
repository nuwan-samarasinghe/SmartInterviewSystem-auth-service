package com.smartinterviewshedular.authservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    String loginUser() {
        return "login";
    }

    @GetMapping("/register")
    String registerUser() {
        return "register";
    }

    @GetMapping("/forgot-password")
    String forgotPassword() {
        return "forgot-password";
    }

}
