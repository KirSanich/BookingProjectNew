package com.example.bookingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private Long id;
    private String comment;
    private OffsetDateTime fromUTC;
    private OffsetDateTime toUTC;
    private Long user_id;
    private List<Long> rooms_id;

}
