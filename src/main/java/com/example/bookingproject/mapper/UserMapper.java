package com.example.bookingproject.mapper;




import com.example.bookingproject.dto.BookingDTO;
import com.example.bookingproject.dto.UserDTO;
import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    private final ModelMapper modelMapper;
    private final BookingMapper bookingMapper;

    @Autowired
    public UserMapper(BookingMapper bookingMapper) {
        this.bookingMapper = bookingMapper;
        this.modelMapper = new ModelMapper();
    }


    public UserDTO fromUserToUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        List<Booking> bookingList = user.getBookingList();
        List<BookingDTO> bookDTOList = bookingList.stream().map(bookingMapper::fromBookingToBookingDTO).collect(Collectors.toList());
        userDTO.setBookingDTOList(bookDTOList);
        return userDTO;
    }

    public User fromUserDTOToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO,User.class);
    }

}