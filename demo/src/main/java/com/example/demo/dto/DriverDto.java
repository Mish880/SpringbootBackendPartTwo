package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDto {
    private String did;
    private String dname;
    private String dNIC;
    private String daddress;
    private String dlicence;
    private String dcontact;
}
