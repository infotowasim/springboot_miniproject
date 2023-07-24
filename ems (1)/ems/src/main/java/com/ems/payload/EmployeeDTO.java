package com.ems.payload;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    private Long eid;
    private String name;
    private String city;
    private String email;
    private String mobile;

//    private List<BonusDTO> bonusDTOList;
 }
