package com.example.demo.controller;



import com.example.demo.dto.AdminStaffDto;

import com.example.demo.service.AdminStaffService;

import com.example.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
   @Autowired
   AdminStaffService adminStaffService;

   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseUtil getAllAdminStaff(){ return new ResponseUtil(200,"OK",adminStaffService.getAllAdmin());}

   @ResponseStatus(HttpStatus.CREATED)
   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@ModelAttribute AdminStaffDto Admin) {
       adminStaffService.saveAdmin(Admin);
       return new ResponseUtil(200,"Save",null);
   }

   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@ModelAttribute AdminStaffDto Admin){
       adminStaffService.updateAdmin(Admin);
       return new ResponseUtil(200,"Save",null);
   }
   @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id) {
       adminStaffService.deleteAdmin(id);
      return new ResponseUtil(200,"Deleted",null);
   }

   @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@PathVariable String id) {
       return new ResponseUtil(200,"Ok",adminStaffService.searchAdmin(id));
   }
}
