package com.example.bookingproject.repository.booking;


import com.example.bookingproject.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookingRepository extends JpaRepository<Booking,Long> {

}
