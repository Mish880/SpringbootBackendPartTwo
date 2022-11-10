package com.example.demo.service.impl;



import com.example.demo.dto.ReservationDto;
import com.example.demo.entity.Reservation;
import com.example.demo.repo.RentRepo;
import com.example.demo.repo.ReservationRepo;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.PurchaseReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class PurchaseReservationServiceImpl implements PurchaseReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private RentRepo rentRepo;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseReservation(ReservationDto dto) {
        Reservation reservation = mapper.map(dto, Reservation.class);
        if (!reservationRepo.existsById(dto.getResid())) {
            reservationRepo.save(reservation);
          if (dto.getRent().size() <1) throw new RuntimeException("No Vehicles added for the order...!");

             //Update the vehicle
           /* for (Rent rent : reservation.getRent()) {
                Vehicle vehicle = vehicleRepo.findById(rent.getVid()).get();
                vehicleRepo.save(vehicle);
            } */

        } else {
            throw new RuntimeException("Purchase Rent Failed...!, Res ID" + dto.getResid() + "Already Exist..!");
        }
    }

    @Override
    public void deletepurchaseRent(String resid) {
        if (reservationRepo.existsById(resid)) {
            reservationRepo.deleteById(resid);
        } else {
            throw new RuntimeException("Delete Reservation Failed..!, Res ID" + resid +"Not Exist...!");
        }
    }

    @Override
    public void updatepurchaseRent(ReservationDto dto) {
                /*Input the Update for the Rent*/
              }



    @Override
    public ReservationDto searchReservationDto(String resid) {
        if (reservationRepo.existsById(resid)) {
            return mapper.map(reservationRepo.findById(resid), ReservationDto.class);
        } else{
             throw new RuntimeException("Search Reservation Faild...!, Res ID" + resid + "Not Exist..!");
        }
    }

    @Override
    public List<ReservationDto> getAllPurchaseRes() {
        return mapper.map(reservationRepo.findAll(), new TypeToken<List<ReservationDto>>(){

        }.getType());
    }
}
