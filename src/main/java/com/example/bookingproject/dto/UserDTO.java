package com.example.bookingproject.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private List<BookingDTO> bookingDTOList = new ArrayList<>();
}
