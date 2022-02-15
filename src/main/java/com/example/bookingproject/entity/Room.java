package com.example.bookingproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "busy")
    private boolean isReadyForBooking;

    @ManyToMany(mappedBy = "rooms")
    private List<Booking> bookingList = new ArrayList<>();

}
