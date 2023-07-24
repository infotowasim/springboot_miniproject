package com.ems.controller;

import com.ems.payload.BonusDTO;
import com.ems.repositories.BonusRepository;
import com.ems.services.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class BonusController {

    @Autowired
    private BonusService bonusService;


    // http://localhost:8080/api/employee/1/bonus

    @PostMapping("/{eid}/bonus")
    public ResponseEntity<BonusDTO> createBonus(@PathVariable ("eid") long eid, @RequestBody BonusDTO bonusDTO){
        BonusDTO bonusDTO1 = bonusService.createBonus(eid, bonusDTO);
        return new ResponseEntity<>(bonusDTO1, HttpStatus.CREATED);
    }
}
