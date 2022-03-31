package com.example.bookingproject.repository.room;


import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
