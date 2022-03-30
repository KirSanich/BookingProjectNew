package com.example.bookingproject.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "Имя не должно быть пустым!")
    @Length(message ="Длина имени минимум ${validation.name.min} символов")
    private String username;
    private List<BookingDTO> bookingDTOList = new ArrayList<>();
}
