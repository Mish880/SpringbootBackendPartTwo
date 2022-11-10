package com.example.demo.service.impl;


import com.example.demo.dto.GuestCustomerDto;
import com.example.demo.entity.GuestCustomer;
import com.example.demo.repo.GuestCustomerRepo;
import com.example.demo.service.GuestCustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class GuestCustomerServiceImpl implements GuestCustomerService {

    @Autowired
    private GuestCustomerRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveGuestCustomer(GuestCustomerDto dto) {
       if (!repo.existsById(dto.getGueid())) {
           repo.save(mapper.map(dto, GuestCustomer.class));
       } else {
           throw new RuntimeException("Guest Customer Exist..!");
       }
    }

    @Override
    public void deleteGuestCustomer(String id) {
       if (repo.existsById(id)) {
           repo.deleteById(id);
       } else {
           throw new RuntimeException("Please check the Guest Customer ID.. No Such Guest Customer..!");
       }
    }

    @Override
    public void updateGuestCustomer(GuestCustomerDto dto) {
       if (repo.existsById(dto.getGueid())) {
           repo.save(mapper.map(dto, GuestCustomer.class));
       } else {
           throw new RuntimeException("No Such GustCustomer To Update..! Please Check the ID..!");
       }
    }

    @Override
    public GuestCustomerDto searchGuestCustomer(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(),GuestCustomerDto.class);
        } else {
            throw new RuntimeException("No GuestCustomer For" + id + "..!");
        }
    }

    @Override
    public List<GuestCustomerDto> getAllGuestCustomer() {
        return mapper.map(repo.findAll(), new TypeToken<List<GuestCustomerDto>>(){

        }.getType());
    }
}
