/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.controllers;

import com.example.groupProject.model.User;
import com.example.groupProject.sercices.UserService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author antonis
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap m) {
        User user = new User();
        m.addAttribute("user", user);
        m.addAttribute("edit", false);
        return "RegisterForm";
    }

    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "RegisterForm";
        }
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getUsername() + " registered successfully");
        return "success";
    }

    @GetMapping("/getuserbyid/{userId}")
    public Optional<User> findUserById(@PathVariable("userId") String id) {
        return userService.findById(id);
    }

    @RequestMapping(value = {"/listofusers"}, method = RequestMethod.GET)
    public String getUsers(ModelMap model) {
        Iterable<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "usersTable";
    }

    @GetMapping("/showloginform")
    public String showLoginForm() {
        return "LoginForm";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "welcomepage";
    }

    @RequestMapping(value = {"/edit-{userid}-user"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String userid, ModelMap model) {
        User user = userService.findById(userid).get();
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "RegisterForm";
    }

    @RequestMapping(value = {"/edit-{userid}-user"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable String userid) {
        if (result.hasErrors()) {
            return "RegisterForm";
        }
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getUsername() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete-{userid}-user"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
        return "redirect:/listofusers";
    }
}
