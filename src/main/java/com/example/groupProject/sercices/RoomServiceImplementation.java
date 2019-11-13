package com.example.groupProject.sercices;

import com.example.groupProject.model.Room;
import com.example.groupProject.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImplementation implements RoomService {

    @Autowired
    RoomRepository rr;

    @Override
    public Iterable<Room> getRooms() {
        return rr.findAll();
    }

    @Override
    public void createRoom(Room r) {
         rr.save(r);
    }
}
