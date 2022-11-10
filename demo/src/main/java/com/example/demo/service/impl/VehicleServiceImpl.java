package com.example.demo.service.impl;


import com.example.demo.dto.VehicleDto;
import com.example.demo.entity.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveVehicle(VehicleDto dto) {
        if (!repo.existsById(dto.getVid())) {
            repo.save(mapper.map(dto, Vehicle.class));
        } else {
            throw new RuntimeException("Vehicle Already Exist...!");
        }

    }

    @Override
    public void deleteVehicle(String id) {
       if (repo.existsById(id)) {
           repo.deleteById(id);
       } else{
           throw new RuntimeException("Please check the Vehicle ID., No Such Vehicle...!");
       }
    }

    @Override
    public void updateVehicle(VehicleDto dto) {
       if (repo.existsById(dto.getVid())) {
           repo.save(mapper.map(dto, Vehicle.class));
       }
    }

    @Override
    public VehicleDto searchVehicle(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), VehicleDto.class);
        } else {
            throw new RuntimeException("No Vehicle For"+ id +"...!");
        }
    }

    @Override
    public List<VehicleDto> getAllVehicle() {
       return mapper.map(repo.findAll(), new TypeToken<List<VehicleDto>>(){

       }.getType());
    }
}
