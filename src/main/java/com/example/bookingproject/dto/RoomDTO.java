package com.example.bookingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private Long id;
    @NotBlank(message = "Имя комнаты не должно быть пустым")
    private String name;
    private List<Long> bookings_id = new ArrayList<>();

}
