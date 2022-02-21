package com.example.bookingproject.controller;


import com.example.bookingproject.dto.BookingDTO;
import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.mapper.BookingMapper;
import com.example.bookingproject.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingController(BookingService bookingService, BookingMapper bookingMapper) {
        this.bookingService = bookingService;
        this.bookingMapper = bookingMapper;
    }

    @GetMapping()
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookingDTOList = bookingService.getAllBooks().stream().map(bookingMapper::fromBookingToBookingDTO).collect(Collectors.toList());
        return new ResponseEntity<>(bookingDTOList, HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<BookingDTO> saveBooking(@RequestBody BookingDTO bookingDTO) {

        Booking booking = bookingMapper.fromBookingDTOToBooking(bookingDTO);
        bookingService.saveBooking(booking);
        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
    }
}
