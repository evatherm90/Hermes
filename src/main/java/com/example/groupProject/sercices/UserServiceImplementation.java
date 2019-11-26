/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.Role;
import com.example.groupProject.model.User;
import com.example.groupProject.repositories.RoleRepository;
import com.example.groupProject.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
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
// @ManyToMany(fetch = FetchType.EAGER)

    @Autowired
    UserRepository ur;

    @Autowired
    RoleRepository rr;

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
        Collection<Role> defaultRole = new ArrayList<>();
        defaultRole.add(rr.findRoleByRolename("Free User"));
        u.setRoleCollection(defaultRole);
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

    @Override
    public String takeMyMoney(String username, int price) {

        User u = ur.findUserByUsername(username);
        int balance = u.getWallet();
        if (balance >= price && price>0) {
            balance = balance - price;
            u.setWallet(balance);
            u.getRoleCollection().clear();
            u.getRoleCollection().add(rr.findRoleByRolename("Premium User"));
            ur.save(u);
            
            return "succesfull transaction";
        } else{
        return "transaction failed, low balance";
        }

    }

    @Override
    public int getMyBalance(String username) {
        int balance = ur.findUserByUsername(username).getWallet();
        return balance;
    }

}
