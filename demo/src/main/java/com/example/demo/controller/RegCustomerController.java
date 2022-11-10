package com.example.demo.controller;



import com.example.demo.dto.RegCustomerDto;
import com.example.demo.service.RegCustomerService;
import com.example.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RegCustomer")
@CrossOrigin
public class RegCustomerController {

    @Autowired
    RegCustomerService regCustomerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegCustomer() { return new ResponseUtil(200,"ok",regCustomerService.getAllRegCustomer()); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRegCustomer(@ModelAttribute RegCustomerDto RegCustomer){
        regCustomerService.saveRegCustomer( RegCustomer);
        return new ResponseUtil(200,"Save",null);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRegCustomer(@RequestBody RegCustomerDto RegCustomer) {
        regCustomerService.updateRegCustomer(RegCustomer);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRegCustomer(@RequestParam String id) {
        regCustomerService.deleteRegCustomer(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRegCustomer(@PathVariable String id) {
        return new ResponseUtil(200,"ok",regCustomerService.searchRegCustomer(id));
    }
}
