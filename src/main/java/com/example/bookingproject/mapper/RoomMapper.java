package com.example.bookingproject.mapper;



import com.example.bookingproject.dto.RoomDTO;
import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.Room;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomMapper {


    private final ModelMapper modelMapper;

    @Autowired
    public RoomMapper() {
        this.modelMapper = new ModelMapper();
    }


    public RoomDTO fromRoomToRoomDTO(Room room) {
        RoomDTO roomDTO = modelMapper.map(room, RoomDTO.class);
        Long id = room.getId();
        boolean status = room.isReadyForBooking();
        List<Booking> bookingList = room.getBookingList();
        return new RoomDTO(id, status, bookingList.stream().map(Booking::getId).collect(Collectors.toList()));
    }

    public Room fromRoomDTO(RoomDTO roomDTO) {
        Room room = modelMapper.map(roomDTO, Room.class);
        Long id = room.getId();
        boolean status = room.isReadyForBooking();
        List<Booking> bookingList = room.getBookingList();
        return new Room(id, status, bookingList);

    }

}