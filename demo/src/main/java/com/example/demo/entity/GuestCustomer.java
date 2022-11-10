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
public class GuestCustomer {
    @Id
    private String gueid;
    private String guename;
    private String guewaddress;
    private String gueNIC;
    private String gueemail;
    private String guecontact;

}
