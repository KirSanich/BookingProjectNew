package com.example.bookingproject.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor

public class UserDTO {

    private Long id;
    @NotNull(message = "Имя не должно быть пустым!")
    @Length(min = 3,max = 20,message = "Длина имени должна быть минимум 3 и не более 20 символов")
    private String username;
    private List<BookingDTO> bookingDTOList = new ArrayList<>();
}
