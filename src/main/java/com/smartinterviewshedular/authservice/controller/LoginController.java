package com.smartinterviewshedular.authservice.controller;

import com.smartinterviewshedular.authservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    String loginUser() {
        log.info("redirecting the application to login page");
        return "login";
    }

    @GetMapping("/error")
    String errorPageUrl(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
        log.info("redirecting the application error page");
        return "error";
    }

    @GetMapping("/register")
    String registerUserGet(Model model) {
        log.info("redirecting the page to user registration");
        return "register";
    }

    @GetMapping("/forgot-password")
    String forgotPassword() {
        return "forgot-password";
    }

    @PostMapping("/register")
    public void registerUserPost(@RequestParam(name = "emailAddress") String email, @RequestParam(name = "password") String password, Model model) {
        log.info("user creation initiated for {}", email);
        userService.createUser(email, password, model);
    }

}
