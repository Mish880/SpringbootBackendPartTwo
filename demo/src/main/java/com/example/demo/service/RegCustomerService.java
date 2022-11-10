package com.example.demo.service;



import com.example.demo.dto.RegCustomerDto;

import java.util.List;

public interface RegCustomerService {
    void saveRegCustomer(RegCustomerDto dto);

    void deleteRegCustomer(String id);

    void updateRegCustomer(RegCustomerDto dto);

    RegCustomerDto searchRegCustomer(String id);

    List<RegCustomerDto> getAllRegCustomer();
}
