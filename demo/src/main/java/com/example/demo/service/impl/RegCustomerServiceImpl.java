package com.example.demo.service.impl;


import com.example.demo.dto.RegCustomerDto;
import com.example.demo.entity.RegCustomer;
import com.example.demo.repo.RegCustomerRepo;
import com.example.demo.service.RegCustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RegCustomerServiceImpl implements RegCustomerService {

    @Autowired
    private RegCustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveRegCustomer(RegCustomerDto dto) {
        if (!repo.existsById(dto.getRegid())) {
            repo.save(mapper.map(dto, RegCustomer.class));
        } else {
            throw new RuntimeException("reg Customer Already Exist..!");
        }

    }

    @Override
    public void deleteRegCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the regCustomer ID.. No Such RegCustomer..!");
        }
    }

    @Override
    public void updateRegCustomer(RegCustomerDto dto) {
      if (repo.existsById(dto.getRegid())) {
          repo.save(mapper.map(dto, RegCustomer.class));
      } else {
          throw new RuntimeException("No Such Reg Customer To update..! Please Check the ID..!");
      }
    }

    @Override
    public RegCustomerDto searchRegCustomer(String id) {
       if (repo.existsById(id)) {
           return mapper.map(repo.findById(id).get(), RegCustomerDto.class);
       } else {
           throw new RuntimeException("No RegCustomer For" + id + "..!");
       }
    }

    @Override
    public List<RegCustomerDto> getAllRegCustomer() {
        return mapper.map(repo.findAll(),new TypeToken<List<RegCustomerDto>>(){

        }.getType());
    }
}
