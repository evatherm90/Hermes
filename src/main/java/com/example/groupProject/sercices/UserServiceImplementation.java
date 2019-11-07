/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.User;
import com.example.groupProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author antonis
 */
@Service
public class UserServiceImplementation implements UserService{
    
    @Autowired
    UserRepository ur;
    
    @Override
    public Iterable<User> getUsers() {
        return ur.findAll();
    }

    @Override
    public void registerUser(User u) {
       ur.save(u);  
    }
    
    @Override
    public void deleteUser(String id){
        ur.deleteById();
    }
    
}
