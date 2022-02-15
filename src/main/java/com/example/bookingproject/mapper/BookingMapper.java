package com.example.bookingproject.mapper;


import com.example.bookingproject.dto.BookingDTO;
import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.Room;
import com.example.bookingproject.entity.User;
import com.example.bookingproject.service.room.RoomService;
import com.example.bookingproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {


    private final UserService userService;
    private final RoomService roomService;


    @Autowired
    public BookingMapper(UserService userService, RoomService roomService) {
        this.userService = userService;
        this.roomService = roomService;
    }


    public BookingDTO fromBookingToBookingDTO(Booking booking) {
        Long id = booking.getId();
        String comment = booking.getComment();
        OffsetDateTime fromUTC = booking.getFromUTC();
        OffsetDateTime toUTC = booking.getToUTC();
        List<Room> roomList = booking.getRooms();
        User user = userService.getUserById(id);
        return new BookingDTO(id,comment,fromUTC,toUTC, user.getId(),roomList.stream().map(Room::getId).collect(Collectors.toList()));

    }

    public Booking fromBookingDTOToBooking(BookingDTO bookingDTO)
    {
      Long id = bookingDTO.getId();
      String comment = bookingDTO.getComment();
      OffsetDateTime fromUTC = bookingDTO.getFromUTC();
      OffsetDateTime toUTC = bookingDTO.getToUTC();
      User user = userService.getUserById(bookingDTO.getUser_id());
      List<Room> rooms= bookingDTO
              .getRooms_id()
              .stream()
              .map(roomService::getRoomById)
              .collect(Collectors.toList());
      return new Booking(id,comment,fromUTC,toUTC,user,rooms);
    }


}

