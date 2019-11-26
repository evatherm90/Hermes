/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.User;
import java.util.Optional;
/**
 *
 * @author antonis
 */
public interface UserService {
    
    Iterable<User> getUsers();
    
    public Optional<User> findById(String id);
    
    void registerUser(User u);

    public void deleteUser(String id);
    
    public void updateUser(User u);
    
    public String getPrincipal();
    
    public String takeMyMoney(String username, int price);
    
    public int getMyBalance(String username);
     
        
}
