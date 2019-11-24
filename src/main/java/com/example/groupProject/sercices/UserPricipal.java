/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.Role;
import com.example.groupProject.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author antonis
 */
public class UserPricipal implements UserDetails {

    private User user;

    public UserPricipal(User user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List< SimpleGrantedAuthority> roleList = new ArrayList<>();
        Collection<Role> roles = user.getRoleCollection();

        for (Role role : roles) {
            roleList.add(new SimpleGrantedAuthority(role.getRolename()));
            System.out.println("adding Role" + role.getRolename());
        }

        return roleList;
    }

    @Override
    public String getPassword() {
        return user.getUserpassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
