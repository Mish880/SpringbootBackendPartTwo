package com.example.demo.repo;

import com.example.demo.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverrRepo extends JpaRepository<Driver, String> {
}
