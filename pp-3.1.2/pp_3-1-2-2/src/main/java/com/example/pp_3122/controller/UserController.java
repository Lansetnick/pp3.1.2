package com.example.pp_3122.controller;

import com.example.pp_3122.model.User;
import com.example.pp_3122.service.UserServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceClass userServiceClass;

    @Autowired
    public UserController(UserServiceClass userServiceClass) {
        this.userServiceClass = userServiceClass;
    }

    @GetMapping(value = "/")
    public String findAll(ModelMap model) {
        List<User> users = userServiceClass.findAll();
        model.addAttribute("messages", users);

        return "index";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/")
    public String createNewUser(@ModelAttribute("user") User user) {
        userServiceClass.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/del/{id}")
    public String deletedUser(@PathVariable Long id) {
        userServiceClass.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model, @PathVariable Long id) {
        model.addAttribute("userEdit", userServiceClass.findUserById(id));
        return "edit";
    }

    @PatchMapping("/")
    public String editedUser(@ModelAttribute("userEdit") User userEdit) {
        userServiceClass.changeUser(userEdit);
        return "redirect:/";
    }
}
