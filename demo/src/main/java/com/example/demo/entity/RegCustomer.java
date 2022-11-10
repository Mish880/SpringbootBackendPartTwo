package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@ToString
public class RegCustomer {
    @Id
    private String regid;
    private String regname;
    private String regaddress;
    private String regemail;
    private String regcontact;
    private String regNIC;

}
