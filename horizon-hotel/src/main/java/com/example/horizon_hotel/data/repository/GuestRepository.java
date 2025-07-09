package com.example.horizon_hotel.data.repository;

import com.example.horizon_hotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {


}
