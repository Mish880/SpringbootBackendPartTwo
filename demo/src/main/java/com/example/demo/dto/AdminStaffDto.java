package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class AdminStaffDto {
    private String Aid;
    private String Aname;
    private String Aaddress;
    private String AContact;
}

