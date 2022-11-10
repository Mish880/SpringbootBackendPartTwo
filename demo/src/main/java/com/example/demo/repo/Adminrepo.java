package com.example.demo.repo;


import com.example.demo.entity.AdminStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Adminrepo extends JpaRepository<AdminStaff, String> {

}
