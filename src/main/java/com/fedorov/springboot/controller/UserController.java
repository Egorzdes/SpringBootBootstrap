package com.fedorov.springboot.controller;

import com.fedorov.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ModelAndView user(ModelAndView modelAndView) {
        modelAndView.addObject("user",
                userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        return modelAndView;
    }

}