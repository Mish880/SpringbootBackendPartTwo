package com.example.demo.repo;

import com.example.demo.entity.GuestCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestCustomerRepo extends JpaRepository<GuestCustomer, String> {
}
