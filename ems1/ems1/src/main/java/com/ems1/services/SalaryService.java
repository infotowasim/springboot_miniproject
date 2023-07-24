package com.ems1.services;

import com.ems1.payload.SalaryDTO;

public interface SalaryService {

    public SalaryDTO createSalary(long eid, SalaryDTO salaryDTO);
}
