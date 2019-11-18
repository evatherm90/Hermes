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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/joinchat")
            public String joinChat(){
                return "chatindex";
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

    
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String showLoginPage(Model m){
//        User user = new User();
//        m.addAttribute("user", user);
//        m.addAttribute("edit", false);
//        return "RegisterForm";
//    }
//    
//    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error, 
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "login";
    }
  
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
            
        }
        return "redirect:/login?logout=true";
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

//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "LoginForm";
//    }

//    @PostMapping("/login")
//    public String loginUser() {
//        return "welcomepage";x
//    }
    
    
    
    
}
