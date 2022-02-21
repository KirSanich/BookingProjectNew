package com.example.bookingproject.controller;



import com.example.bookingproject.dto.RoomDTO;
import com.example.bookingproject.entity.Room;
import com.example.bookingproject.mapper.RoomMapper;
import com.example.bookingproject.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @Autowired
    public RoomController(RoomService roomService, RoomMapper roomMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoom(@PathVariable Long id)
    {
       Room room = roomService.getRoomById(id);
       RoomDTO roomDTO = roomMapper.fromRoomToRoomDTO(room);
       return new ResponseEntity<>(roomDTO, HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<RoomDTO> saveRoom(@RequestBody RoomDTO roomDTO)
    {
        Room room = roomMapper.fromRoomDTO(roomDTO);
        roomService.saveRoom(room);
        return new ResponseEntity<>(roomDTO,HttpStatus.OK);
    }

}
