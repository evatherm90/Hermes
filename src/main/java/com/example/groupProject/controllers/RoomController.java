package com.example.groupProject.controllers;


import com.example.groupProject.model.Room;
import com.example.groupProject.sercices.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RoomController {

    @Autowired
    RoomService rs;

    @GetMapping("/chatRooms")
    public String getRooms(ModelMap modelMap) {
        Iterable<Room> rooms = rs.getRooms();
        modelMap.addAttribute("room", rooms);
        return "ChatRoom";
    }

    @GetMapping("/newRoom")
    public String createRoom(ModelMap map) {
        Room room = new Room();
        map.addAttribute("newRoom",room);
        return "createRoomForm";
    }

    @PostMapping("/chatRoom")
    public String saveRoom(@Valid ModelMap map , Room room, BindingResult result) {
        if (result.hasErrors()){
            return "createRoomForm";
        }
        rs.createRoom(room);
        map.addAttribute("roomCreated", "newRoom" + room.getRoomname() + "Room Created");
        return "chatRoom";
    }
}
