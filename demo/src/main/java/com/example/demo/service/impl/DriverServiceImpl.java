package com.example.demo.service.impl;


import com.example.demo.dto.DriverDto;
import com.example.demo.entity.Driver;
import com.example.demo.repo.DriverrRepo;
import com.example.demo.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

   @Autowired
   private DriverrRepo repo;

   @Autowired
   private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDto dto) {
        if (!repo.existsById(dto.getDid())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("Driver Already Exist...!");
        }

    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Driver ID.. No Such Driver...!");
        }
    }

    @Override
    public void updateDriver(DriverDto dto) {
        if (repo.existsById(dto.getDid())){
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("No Such Driver to Update..! Please check the Id..!");
        }

    }

    @Override
    public DriverDto searchDriver(String id) {
       if (repo.existsById(id)){
           return mapper.map(repo.findById(id).get(),DriverDto.class);
       } else {
           throw new RuntimeException("No Driver For" + id + "...!");
       }
    }

    @Override
    public List<DriverDto> getAllDriver() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDto>>(){

        }.getType());
    }
}
