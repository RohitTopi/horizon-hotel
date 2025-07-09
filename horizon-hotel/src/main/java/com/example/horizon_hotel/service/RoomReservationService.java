package com.example.horizon_hotel.service;

import ch.qos.logback.core.util.StringUtil;
import com.example.horizon_hotel.data.entity.Guest;
import com.example.horizon_hotel.data.entity.Reservation;
import com.example.horizon_hotel.data.entity.Room;
import com.example.horizon_hotel.data.repository.GuestRepository;
import com.example.horizon_hotel.data.repository.ReservationRepository;
import com.example.horizon_hotel.data.repository.RoomRepository;
import com.example.horizon_hotel.service.model.RoomReservation;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomReservationService(  GuestRepository guestRepository, RoomRepository roomRepository,
     ReservationRepository reservationRepository)
    {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String reservationDate)
    {
        Date date = null;
        if(!StringUtil.isNullOrEmpty(reservationDate))
        {
            date = Date.valueOf(reservationDate);
        }
        else{
            date = new Date(new java.util.Date().getTime());
        }

        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        List<Room> rooms = roomRepository.findAll();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(roomReservation.getRoomId(), roomReservation);
        });

        List<Reservation> reservations = this.reservationRepository.findAllByReservationDate(date);
        for (Reservation reservation : reservations) {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
            reservation.setReservationId(reservation.getId());
            reservation.setReservationDate(reservation.getReservationDate());
            Optional<Guest> guest = this.guestRepository.findById(reservation.getId());
            roomReservation.setGuestId(guest.get().getId());
            roomReservation.setFirstName(guest.get().getFirstName());
            roomReservation.setLastName(guest.get().getLastName());
        }

        return roomReservationMap.values().stream().toList();
    }

}
