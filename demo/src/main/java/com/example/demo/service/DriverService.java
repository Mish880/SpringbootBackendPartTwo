package com.example.demo.service;



import com.example.demo.dto.DriverDto;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDto dto);

    void deleteDriver(String dto);

    void updateDriver(DriverDto dto);

    DriverDto searchDriver(String id);

    List<DriverDto> getAllDriver();
}
