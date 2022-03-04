package com.example.bookingproject.service.booking;


import com.example.bookingproject.entity.Booking;
import com.example.bookingproject.entity.Room;
import com.example.bookingproject.repository.booking.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;


    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        log.info("Getting all booking");
        return bookingRepository.findAll();
    }


    @Override
    public void saveBooking(Booking booking) {

    }

    @Override
    public void deleteBooking(Long id) {
        log.info("Deleting booking with id = {}", id);
        bookingRepository.delete(getBookingById(id));
    }

    @Override
    public Booking getBookingById(Long id) {
        log.info("Getting booking with id = {}", id);
        return bookingRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
