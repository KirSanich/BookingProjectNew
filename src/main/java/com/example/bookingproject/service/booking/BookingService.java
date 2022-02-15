package com.example.bookingproject.service.booking;






import com.example.bookingproject.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooks();
    void saveBooking(Booking booking);
    void deleteBooking(Long id);
    Booking getBookingById(Long id);
}
