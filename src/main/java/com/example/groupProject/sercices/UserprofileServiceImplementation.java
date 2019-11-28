/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.Role;
import com.example.groupProject.model.User;
import com.example.groupProject.model.Userprofile;
import com.example.groupProject.repositories.UserRepository;
import com.example.groupProject.repositories.UserprofileRepository;
import java.util.ArrayList;
import java.util.Collection;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author antonis
 */
@Service
public class UserprofileServiceImplementation implements UserprofileService{

    @Autowired
    UserprofileRepository upr;
    
    @Autowired
    UserRepository ur;
    
    @Override
    public String saveUserprofile(Userprofile up) {
        up.getUsername();
    User thereIsUser=ur.findUserByUsername(up.getUsername());
    if(thereIsUser!=null){
        upr.save(up);
        return "success";
    } else {
        return "You cannot edit the username"; 
       }
    }
    
    @Override
    public Userprofile getUserprofile(String username){
        Userprofile up=upr.findUserprofileByUsername(username);
        if(up!=null){
            return up;
        } else{
            Userprofile dummy=new Userprofile(username, "undefied", "undefied");
            upr.save(dummy);
            return dummy;
        }
    }
    
}
