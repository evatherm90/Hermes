/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.controllers;

import com.example.groupProject.model.User;
import com.example.groupProject.sercices.UserService;
import java.util.List;
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

    //method to show home page
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

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
        return "index";
        // }
    }//prepei na peraso kai rolo sto userrole!!!!!!!!!!

    @GetMapping("/getuserbyid/{userId}")
    @ResponseBody
    public User findUserById(@PathVariable("userId") String id) {
        return userService.findById(id);
    }

    //method to get all registered users
    
    @GetMapping("/usersTable")
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

    @GetMapping("/deleteuserbyid/{userId}")
    public String deleteUser(@PathVariable("userId") String id) {
        userService.deleteUser(id);
        return "homePage";
    }//tha prepei na ton diagrapso apo pantoy!!!!!!!!!!!!!!!!
    
    @PostMapping(path="/update")
public String updateUser(@ModelAttribute("myuser") User u, ModelMap mm) {//@Valid @RequestBody User user
    userService.updateUser(u);
    return "homePage";
}


//@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
//    public String listEmployees(ModelMap model) {
// 
//        List<Employee> employees = service.findAllEmployees();
//        model.addAttribute("employees", employees);
//        //ftiaxnei (metabliti employees gia to jsp, h lista employees poy ftiaxno apo pano)
//        return "allemployees";
//    }

    }
