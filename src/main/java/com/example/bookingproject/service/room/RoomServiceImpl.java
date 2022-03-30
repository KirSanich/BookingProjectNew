package com.example.bookingproject.service.room;

import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.Room;
import com.example.bookingproject.exception.NotRoomFound;
import com.example.bookingproject.repository.room.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getEmptyRooms(OffsetDateTime from, OffsetDateTime to) {

        // id всех комнат
        var allRooms = roomRepository.findAll().stream().map(Room::getId).collect(Collectors.toList());
        // вытаскиваю id всех комнат, которые заняты в данный промежуток
        var list = roomRepository.findAll()
                .stream()
                .map(Room::getBookingList)
                .flatMap(Collection::stream)
                .filter(booking -> booking.getToUTC().isBefore(from) && booking.getToUTC().isAfter(to))
                .map(Booking::getRooms)
                .flatMap(Collection::stream)
                .map(Room::getId)
                .collect(Collectors.toList());
        allRooms.removeAll(list);
        return allRooms
                .stream()
                .map(roomRepository::getById)
                .collect(Collectors.toList());
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
