package com.example.bookingproject.entity;


import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "fromUTC")
    private OffsetDateTime fromUTC;

    @Column(name = "toUTC")
    private OffsetDateTime toUTC;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "booking_room",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms = new ArrayList<>();


}
