package com.example.bookingproject.service.room;

import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.Room;
import com.example.bookingproject.entity.User;
import com.example.bookingproject.exception.AlreadyExistUserWithUsernameException;
import com.example.bookingproject.repository.room.RoomRepository;
import com.example.bookingproject.repository.user.UserRepository;
import com.example.bookingproject.service.user.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoomServiceImplTest {

    @MockBean
    private RoomRepository roomRepository;

    @InjectMocks
    @Autowired
    private RoomServiceImpl roomService;
    private List<Room> roomList;
    private Room room1;
    private Room room2;


    @BeforeEach
    void setUp() {
        roomList = new ArrayList<>();
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(Booking.builder().id(1L).fromUTC(OffsetDateTime.now()).toUTC(OffsetDateTime.now().plusHours(2)).build());
        bookingList.add(Booking.builder().fromUTC(OffsetDateTime.now().minusHours(8)).toUTC(OffsetDateTime.now().minusHours(4)).id(2L).build());
        room1 = Room.builder().id(1L).name("Комната обычная").bookingList(bookingList).build();
        roomList.add(room1);

    }

    @AfterEach
    void tearDown() {
        roomList = null;
        room1 = room2 = null;
    }

    @Test
    void getEmptyRooms() {
        Mockito.when(roomService.getEmptyRooms(OffsetDateTime.now().minusHours(3),OffsetDateTime.now().minusHours(1))).thenReturn(roomList);
        Assertions.assertEquals(roomService.getEmptyRooms(OffsetDateTime.now().minusHours(2),OffsetDateTime.now().minusHours(1)),roomList);
    }

    @Test
    void givenIdThenShouldReturnRoomOfThatId() {
        Mockito.when(roomRepository.findById(1L)).thenReturn(Optional.ofNullable(room1));
        Assertions.assertEquals(roomService.getRoomById(1L), room1);
    }

    @Test
    void givenProductToAddShouldReturnAddedProduct() {
        when(roomRepository.save(any())).thenReturn(room1);
        roomService.saveRoom(room1);
        verify(roomRepository, times(1)).save(any());
    }
}