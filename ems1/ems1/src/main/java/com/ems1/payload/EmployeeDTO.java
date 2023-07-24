package com.ems1.payload;

import lombok.Data;

@Data
public class EmployeeDTO {

    private Long eid;
    private String name;
    private Long mobile;

    private SalaryDTO salaryDTO;
}
