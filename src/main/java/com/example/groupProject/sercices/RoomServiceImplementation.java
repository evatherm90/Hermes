package com.example.groupProject.sercices;

import com.example.groupProject.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImplementation {

    @Autowired
    RoomRepository rr;
}
