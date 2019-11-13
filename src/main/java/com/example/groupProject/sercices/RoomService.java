package com.example.groupProject.sercices;

import com.example.groupProject.model.Room;

public interface RoomService {
    Iterable<Room> getRooms();
    void createRoom(Room room);
    
}
