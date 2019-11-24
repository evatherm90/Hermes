/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.User;
import com.example.groupProject.repositories.UserRepository;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author antonis
 */
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository ur;

    @Override
    public Iterable<User> getUsers() {
        return ur.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        int result = Integer.parseInt(id);
        Optional<User> users = ur.findById(result);
        return users;
    }

    @Override
    public void registerUser(User u) {
        String password = u.getUserpassword();
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        u.setUserpassword(hashed);
        System.out.println(u.getUserpassword());
        ur.save(u);
    }

    @Override
    public void deleteUser(String id) {
        int result = Integer.parseInt(id);
        ur.deleteById(result);
    }

    @Override
    public void updateUser(User u) {
        ur.save(u);
    }

    @Override
    public String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
