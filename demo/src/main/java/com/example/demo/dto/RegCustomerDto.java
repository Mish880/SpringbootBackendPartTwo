package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RegCustomerDto {
    private String regid;
    private String regname;
    private String regaddress;
    private String regemail;
    private String regcontact;
    private String regNIC;
}
