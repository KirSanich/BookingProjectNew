package com.example.bookingproject.service.room;


import com.example.bookingproject.entity.Room;

public interface RoomService {
    Room getRoomById(Long id);
    void saveRoom(Room room);
}
