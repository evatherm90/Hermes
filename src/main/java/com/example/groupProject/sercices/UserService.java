/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.User;

/**
 *
 * @author antonis
 */
public interface UserService {
    
    Iterable<User> getUsers();
    
    void registerUser(User u);
        
}
