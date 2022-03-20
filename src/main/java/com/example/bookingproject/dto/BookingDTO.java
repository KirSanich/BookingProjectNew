package com.example.bookingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private Long id;
    @NotNull(message = "Описание не должно быть пустым")
    private String comment;
    private OffsetDateTime fromUTC;
    private OffsetDateTime toUTC;
    @NotNull(message = "У бронирования должен быть клиент")
    private Long user_id;
    @NotNull(message = "Список комнат обязательный!")
    @NotEmpty(message = "Список комнат не должен быть пустым")
    private List<Long> rooms_id;

}
