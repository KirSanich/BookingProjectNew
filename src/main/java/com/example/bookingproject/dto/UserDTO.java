package com.example.bookingproject.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "Имя не должно быть пустым!")
    private String username;
    @NotNull(message = "Должен быть список букингов")
    @NotEmpty(message = "Список букингов не должен быть пустым")
    private List<BookingDTO> bookingDTOList = new ArrayList<>();
}
