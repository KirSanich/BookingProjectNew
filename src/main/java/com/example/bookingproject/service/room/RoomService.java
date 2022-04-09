package com.example.bookingproject.service.room;


import com.example.bookingproject.entity.Room;

import java.time.OffsetDateTime;
import java.util.List;

public interface RoomService {
    List<Room> getEmptyRooms(OffsetDateTime from,OffsetDateTime to);
    Room getRoomById(Long id);
    void saveRoom(Room room);

}
