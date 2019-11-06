/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.controllers;

import com.example.groupProject.model.User;
import com.example.groupProject.sercices.UserService;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    //method to show register user form
    @GetMapping("/showregistrationform")
    public String showRegistrationForm(ModelMap m) {
        User u = new User();
        m.addAttribute("myuser", u);
        return "RegisterForm";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("myuser") User u, BindingResult bindingResult, ModelMap mm) {
        //if (bindingResult.hasErrors()) {

        //return "registerUserForm";
        // }
        //else{
//        String password = u.getUserpassword();
//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
//        u.setUserpassword(hashed);
        userService.registerUser(u);
        return "success";
        // }
    }

    //method to get all registered users
    @ResponseBody
    @GetMapping(
            value = "getusers",
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json"
    )
    public Iterable<User> getUsers() {

        return userService.getUsers();
    }

    @GetMapping("/showloginform")
    public String showLoginForm() {
        return "LoginForm";
    }

    @PostMapping("/login")
    public String loginUser() {
//        getUserByPassword
//                if (username.equals(un) && userpassword.equals(up)){
//                    get user connected}
//                else
//                    return "wrong username or password";

        return "index";
    }

}
