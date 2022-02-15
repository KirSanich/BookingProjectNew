package com.example.bookingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private Long id;
    private boolean isReadyForBooking;
    private List<Long> bookings_id = new ArrayList<>();

}
