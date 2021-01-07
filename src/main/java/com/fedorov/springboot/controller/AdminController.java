package com.fedorov.springboot.controller;


import com.fedorov.springboot.model.User;
import com.fedorov.springboot.service.RoleService;
import com.fedorov.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("admin");
        modelAndView.addObject("currentuser", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        modelAndView.addObject("users", userService.getAllUsers());
        modelAndView.addObject("newuser", new User());
        modelAndView.addObject("roles", roleService.getAllRoles());
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView getNewPage(ModelAndView modelAndView) {
        modelAndView.setViewName("new");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("roles", roleService.getAllRoles());

        return modelAndView;
    }

    @PostMapping()
    public ModelAndView newPage(@ModelAttribute("user") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }


    @GetMapping("/{id}/edit")
    public ModelAndView getEdit(ModelAndView modelAndView, @PathVariable("id") long id) {
        modelAndView.addObject("user", userService.getUser(id));
        modelAndView.addObject("roles", roleService.getAllRoles());
        modelAndView.setViewName("/edit");
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ModelAndView edit(@ModelAttribute("user") User user) {
        userService.update(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        userService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }


}