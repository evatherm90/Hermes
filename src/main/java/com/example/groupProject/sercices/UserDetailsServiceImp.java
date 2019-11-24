/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.User;
import com.example.groupProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author antonis
 */
@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = ur.findUserByUsername(username); //findUserbyUername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return new UserPricipal(user);
    }

}
