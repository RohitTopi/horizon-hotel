package com.example.horizon_hotel.data.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;


@Entity
@Table(name="reservations")
@Data
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="reservation_id")
    private long id;
    @Column(name="room_id")
    private String roomId;

    @Column(name="guest_id")
    private String guestId;

    @Column(name="res_date")
    private Date reservationDate;

    public void setReservationId(long id) {
    }
}
