package com.example.bookingproject.repository.room;


import com.example.bookingproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
