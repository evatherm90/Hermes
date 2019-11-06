package com.example.groupProject.controllers;


import com.example.groupProject.sercices.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    @Autowired
    RoomService rs;
}
