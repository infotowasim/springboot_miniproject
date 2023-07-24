package com.ems1.controller;

import com.ems1.payload.SalaryDTO;
import com.ems1.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;


    // http://localhost:8080/api/employee/1/salary

    @PostMapping("/{eid}/salary")
    public ResponseEntity<SalaryDTO> createSalary(@PathVariable("eid") long eid, @RequestBody SalaryDTO salaryDTO){
        SalaryDTO salaryDTO1 = salaryService.createSalary(eid, salaryDTO);
        return new ResponseEntity<>(salaryDTO1, HttpStatus.CREATED);
    }

}
