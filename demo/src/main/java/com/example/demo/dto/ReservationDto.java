package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReservationDto {
  private String resid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate date;
  private GuestCustomerDto guestCustomerDto;
  private RegCustomerDto regCustomerDto;
  List<RentDto> rent;
}

