package com.example.demo.service.impl;


import com.example.demo.dto.AdminStaffDto;
import com.example.demo.entity.AdminStaff;
import com.example.demo.repo.Adminrepo;
import com.example.demo.service.AdminStaffService;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminStaffServiceImpl implements AdminStaffService {

     @Autowired
     private Adminrepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveAdmin(AdminStaffDto dto) {
        if(!repo.existsById(dto.getAid())){
            repo.save(mapper.map(dto, AdminStaff.class));
        } else {
            throw new RuntimeException("Admin is Already Exist...!");
        }

    }

    @Override
    public void deleteAdmin(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        } else{
            throw new RuntimeException("Please check the Admin ID.. No Such Admin...! ");
        }
    }

    @Override
    public void updateAdmin(AdminStaffDto dto) {
       if (repo.existsById(dto.getAid())) {
           repo.save(mapper.map(dto, AdminStaff.class));
       } else {
           throw new RuntimeException("No Such Admin to update..! Pleace check the ID...!");
       }
    }

    @Override
    public AdminStaffDto searchAdmin(String id) {
       if (repo.existsById(id)){
           return mapper.map(repo.findById(id).get(),AdminStaffDto.class);
       } else{
            throw new RuntimeException("No AdminStaff For" + id + "..!");
       }
    }

    @Override
    public List<AdminStaffDto> getAllAdmin() {
        return mapper.map(repo.findAll(),new TypeToken<List<AdminStaffDto>>(){
        }.getType());
    }
}
