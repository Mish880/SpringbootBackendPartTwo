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
public class Vehicle {
    @Id
     private String vid;
     private String vtype;
     private String vbrand;
     private int passanger;
     private String fualtype;
     private String transmissiontype;

     
}
