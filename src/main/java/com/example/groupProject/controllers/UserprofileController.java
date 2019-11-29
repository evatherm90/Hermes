/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.controllers;

import com.example.groupProject.model.Role;
import com.example.groupProject.model.User;
import com.example.groupProject.model.Userprofile;
import com.example.groupProject.repositories.RoleRepository;
import com.example.groupProject.repositories.UserRepository;
import com.example.groupProject.sercices.UserService;
import com.example.groupProject.sercices.UserprofileService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author antonis
 */
@Controller
public class UserprofileController {
    
     @Autowired
    UserService userService;
     
     @Autowired
     UserprofileService ups;
     
     @Autowired
    UserRepository ur;
     
     @Autowired
    RoleRepository rr;
    
    @GetMapping("/accountsettings")
    public String getUserAccountSettings(ModelMap model) {
//        model.addAttribute("user", userService.getPrincipal());
//        Userprofile up=ups.getUserprofile(userService.getPrincipal());
        Userprofile userprofile=ups.getUserprofile(userService.getPrincipal());
        model.addAttribute("userprofile", userprofile);
        User user=ur.findUserByUsername(userService.getPrincipal());
         model.addAttribute("user", user);
         Iterable<User> userrs = userService.getUsers();
        model.addAttribute("userrs", userrs);
//        Role role=rr.findRoleByUserid(user.getUserid());
        List<String> roleList=new ArrayList<>();
//        roles=user.getRoleCollection();
Collection<Role> roles = user.getRoleCollection();

        for (Role role : roles) {
            roleList.add(role.getRolename());
            System.out.println("adding Role" + role.getRolename());
        }
        if(roleList.contains("Premium User")){
        model.addAttribute("role", "Premium User");
        }else if(roleList.contains("Admin")){
        model.addAttribute("role", "Admin");
        }else{
        model.addAttribute("role", "Free User");
        return "freeuserAccountSettings";
        }

        return "accountsettings";
    }
    
    @RequestMapping(value = {"/editUserprofile"}, method = RequestMethod.GET)
    public String newUserprofile(ModelMap m) {
        Userprofile userprofile = new Userprofile();
        m.addAttribute("userprofile", userprofile);
        m.addAttribute("edit", false);
        return "accountsettingsForm";
    }

    @RequestMapping(value = {"/editUserprofile"}, method = RequestMethod.POST)
    public String saveUserprofile(@Valid Userprofile userprofile, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "accountsettingsForm";
        }
       String resultMessage=ups.saveUserprofile(userprofile);
       if(resultMessage.equals("success")){
        model.addAttribute("success", resultMessage);
        return "successToEditProfile";
       } else {
       model.addAttribute("failure", resultMessage);
       return "failToEditProfile";
       }
    }
}
