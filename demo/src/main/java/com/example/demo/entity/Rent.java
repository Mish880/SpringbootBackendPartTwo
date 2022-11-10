package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@ToString
@IdClass(OrderVehicle_PK.class)
public class Rent {
    @Id
   private String resid;
    @Id
    private String vid;
    private String date;
    private double unitprice;

    //Out-Verse
    @ManyToOne
    @JoinColumn(name = "resid",referencedColumnName = "resid",insertable = false,updatable = false)
    private Reservation reservation;
    //Out-verse
    @ManyToOne
    @JoinColumn(name = "vid",referencedColumnName = "vid",insertable = false,updatable = false)
    private Vehicle vehicle;
}
