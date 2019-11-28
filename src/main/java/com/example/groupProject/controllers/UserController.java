/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.controllers;

import com.example.groupProject.model.User;
import com.example.groupProject.sercices.UserService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author antonis
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String homePage(ModelMap model) {
      model.addAttribute("user",userService.getPrincipal());
        return "index";
    }

    @GetMapping("/joinchat")
    public String joinChat(Model model) {
        model.addAttribute("user", userService.getPrincipal());
        return "chatindex";
    }
    
    @GetMapping("/joinhermespublicchat")
    public String joinHermesPublicChat(Model model) {
        model.addAttribute("user", userService.getPrincipal());
         model.addAttribute("channelName", "Hermes Public Chat");
        return "hermespublicchatindex";
    }
    
    @GetMapping("/messageafriend")
     public String messageAFriend(Model model) {
        model.addAttribute("user", userService.getPrincipal());
        return "onetoonechatindex";
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

        String registrationMessage=userService.registerUser(user);
        if(registrationMessage.equals("success")){
        model.addAttribute("success", "User " + user.getUsername() + " registered successfully");
        return "successUserRegistration";
        } else {
            model.addAttribute("failure", "Username " + user.getUsername() + " is allready taken!");
            return "usernameTaken";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            ModelMap model) {
        String errorMessge = null;
        if (error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
       
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
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

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", userService.getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", userService.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/premium", method = RequestMethod.GET)
    public String getPaymentProcedure(ModelMap model) {
        String username = userService.getPrincipal();
        model.addAttribute("user",username);
        return "payment";
    }
    
    @RequestMapping(value = "/payment", method = RequestMethod.GET)//@RequestParam(value = "price", required = true) int price
    public String takeMyMoney( Model model) {
        String username = userService.getPrincipal();
        int price=100;
        String resultMessage = userService.takeMyMoney(username, price);
        if(resultMessage.equals("success")){
            model.addAttribute("resultMessage","You have been updated to PREMIUM");
        return "successPayment";
        }else{
            model.addAttribute("resultMessage",resultMessage);
        return "failPayment";
        }
        
        
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public String getMyBalance(ModelMap model) {
        String username = userService.getPrincipal();
        int balance = userService.getMyBalance(username);
        model.addAttribute("balance",balance);
        return "balance";
    }
}
