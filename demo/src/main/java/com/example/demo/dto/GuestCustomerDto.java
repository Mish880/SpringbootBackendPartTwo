package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuestCustomerDto {
    private String gueid;
    private String guename;
    private String guewaddress;
    private String gueNIC;
    private String gueemail;
    private String guecontact;
}
