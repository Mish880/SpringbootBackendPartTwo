package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString


public class Reservation {

    @Id
    private String resid;
    private LocalDate date;
    private int noofdays;
    private String pickupdate;

    //Out=verse in guestcustomer
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "Guestid", referencedColumnName = "Gueid", insertable = false, updatable = false)
    private GuestCustomer guestCustomer;

    //Out=verse in regcustomer
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "registrationid", referencedColumnName = "regid", insertable = false, updatable = false)
    private RegCustomer regCustomer;

    /*@OneToMany(mappedBy = "Rents",cascade = CascadeType.ALL)
    private List<Rent> rentList;*/


}
