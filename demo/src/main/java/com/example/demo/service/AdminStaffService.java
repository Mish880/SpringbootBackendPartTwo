package com.example.demo.service;



import com.example.demo.dto.AdminStaffDto;

import java.util.List;

public interface AdminStaffService {
    void saveAdmin(AdminStaffDto dto);

    void deleteAdmin(String dto);

    void updateAdmin(AdminStaffDto dto);

    AdminStaffDto searchAdmin(String id);

    List<AdminStaffDto> getAllAdmin();
}
