/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.repositories;

import com.example.groupProject.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author antonis
 */
public interface UserRepository extends CrudRepository<User, Integer>  {
    
    
}