/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.sercices;

import com.example.groupProject.model.Userprofile;
import org.springframework.stereotype.Service;

/**
 *
 * @author antonis
 */

public interface UserprofileService {
    
    public String saveUserprofile(Userprofile up);
    
   public Userprofile getUserprofile(String username);
}
