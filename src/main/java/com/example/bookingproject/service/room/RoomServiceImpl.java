package com.example.bookingproject.service.room;

import com.example.bookingproject.entity.Room;
import com.example.bookingproject.exception.NotRoomFound;
import com.example.bookingproject.repository.room.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room getRoomById(Long id) {
        log.info("Getting Room with id = {}", id);
        return roomRepository.findById(id).orElseThrow(() -> new NotRoomFound("No exist room with id = " + id));
    }

    @Override
    public void saveRoom(Room room) {
        log.info("Saving room with id = {}", room.getId());
        roomRepository.save(room);
    }
}
