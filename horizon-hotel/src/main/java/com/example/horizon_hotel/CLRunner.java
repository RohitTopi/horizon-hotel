package com.example.horizon_hotel;

/*import com.example.horizon_hotel.data.entity.Guest;
import com.example.horizon_hotel.data.entity.Reservation;
import com.example.horizon_hotel.data.entity.Room;
import com.example.horizon_hotel.data.repository.GuestRepository;
import com.example.horizon_hotel.data.repository.ReservationRepository;
import com.example.horizon_hotel.data.repository.RoomRepository;
import com.example.horizon_hotel.service.RoomReservationService;
import com.example.horizon_hotel.service.model.RoomReservation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;*/

//@Component
public class CLRunner /*implements CommandLineRunner */{

    /*private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationService roomReservationService;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository,
                    RoomReservationService roomReservationService)
    {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository  = reservationRepository;
        this.roomReservationService = roomReservationService;
    }

    @Override
    public void run(String... args) throws Exception {

        *//*System.out.printf("printing all rooms =================");
        List<Room> rooms = this.roomRepository.findAll();
        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);

        rooms.forEach(System.out::println);

        System.out.print("printing all guests =================");
        List<Guest> guests = this.guestRepository.findAll();
        System.out.println(guests);
        guests.forEach(System.out::println);

        System.out.print("printing all reservations =================");
        List<Reservation> reservations = this.reservationRepository.findAll();
        System.out.println(reservations);
        reservations.forEach(System.out::println);
*//*

        List<RoomReservation> reservations = this.roomReservationService.getRoomReservationsForDate("2023-08-28");
        reservations.forEach(reservation -> {
            System.out.printf(String.valueOf(reservation));
        });
    }*/
}
