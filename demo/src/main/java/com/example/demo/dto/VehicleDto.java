package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDto {
    private String vid;
    private String vtype;
    private String vbrand;
    private int passanger;
    private String fualtype;
    private String transmissiontype;
}
