package com.example.demo.repo;

import com.example.demo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, String> {
}
