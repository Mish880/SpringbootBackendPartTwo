package com.example.demo.repo;


import com.example.demo.entity.RegCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegCustomerRepo extends JpaRepository<RegCustomer, String> {
}
