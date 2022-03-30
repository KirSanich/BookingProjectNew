package com.example.bookingproject.service.user;

import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.User;
import com.example.bookingproject.exception.AlreadyExistUserWithUsernameException;
import com.example.bookingproject.repository.user.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {


    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    @Autowired
    private UserServiceImpl userService;
    private List<User> userList;
    private User user1;
    private User user2;


    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(Booking.builder().id(1L).build());
        bookingList.add(Booking.builder().id(2L).build());
        user1 = User.builder().id(1L).username("Kirill").bookingList(bookingList).build();
        user2 = User.builder().username("Kate").bookingList(null).build();
        userList.add(user1);
        userList.add(user2);
    }

    @AfterEach
    void tearDown() {
        userList=null;
        user1=user2=null;
    }

    @Test
    public void GivenGetAllUsersShouldReturnListOfAllUsers(){
        userRepository.save(user1);
        userRepository.save(user2);
        when(userRepository.findAll()).thenReturn(userList);
        List<User> usersFromService = userService.getAllUsers();
        Assertions.assertEquals(userList,usersFromService);
        verify(userRepository,times(1)).save(user1);
        verify(userRepository,times(1)).save(user2);
        verify(userRepository,times(1)).findAll();
    }

    @Test
    void givenIdThenShouldReturnUserOfThatId() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        Assertions.assertEquals(userService.getUserById(1L),user1);
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheUser(){
        doNothing().when((userService.getUserById(user1.getId())));
    }

    @Test
    void givenProductToAddShouldReturnAddedProduct() {
            when(userRepository.save(any())).thenReturn(user1);
        try {
            userService.saveUser(user1);
        } catch (AlreadyExistUserWithUsernameException e) {
            userService.saveUser(user1);
        }
        verify(userRepository,times(1)).save(any());
    }
}