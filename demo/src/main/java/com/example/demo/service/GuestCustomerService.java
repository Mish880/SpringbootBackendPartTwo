package com.example.demo.service;



import com.example.demo.dto.GuestCustomerDto;

import java.util.List;

public interface GuestCustomerService {
    void saveGuestCustomer(GuestCustomerDto dto);

    void deleteGuestCustomer(String id);

    void updateGuestCustomer(GuestCustomerDto dto);

    GuestCustomerDto searchGuestCustomer(String id);

    List<GuestCustomerDto> getAllGuestCustomer();
}
