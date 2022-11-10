package com.example.demo.controller;



import com.example.demo.dto.GuestCustomerDto;
import com.example.demo.service.GuestCustomerService;
import com.example.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GuestCustomer")
@CrossOrigin
public class GuestCustomerController {

    @Autowired
    GuestCustomerService guestCustomerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGuestCustomers() { return new ResponseUtil(200,"ok",guestCustomerService.getAllGuestCustomer()); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveGuestCustomer(@ModelAttribute GuestCustomerDto GuestCustomer){
        guestCustomerService.saveGuestCustomer( GuestCustomer);
        return new ResponseUtil(200,"Save",null);

    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateGuestCustomer(@RequestBody GuestCustomerDto GuestCustomer) {
        guestCustomerService.updateGuestCustomer(GuestCustomer);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteGuestCustomer(@RequestParam String id) {
        guestCustomerService.deleteGuestCustomer(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchGuestCustomer(@PathVariable String id) {
        return new ResponseUtil(200,"ok",guestCustomerService.searchGuestCustomer(id));
    }

}
