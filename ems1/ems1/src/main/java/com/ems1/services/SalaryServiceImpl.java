package com.ems1.services;

import com.ems1.entities.Employee;
import com.ems1.entities.Salary;
import com.ems1.payload.SalaryDTO;
import com.ems1.repositories.EmployeeRepository;
import com.ems1.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService{


    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    //DTO to ENTITY
    private Salary mapToEntity(SalaryDTO salaryDTO){
        Salary salary = new Salary();
        salary.setSalaryAmount(salaryDTO.getSalaryAmount());
        return salary;
    }


    // ENTITY to DTO
    private SalaryDTO mapToDTO(Salary salary){
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setSid(salary.getSid());
        salaryDTO.setSalaryAmount(salary.getSalaryAmount());
        return salaryDTO;
    }


    @Override
    public SalaryDTO createSalary(long eid, SalaryDTO salaryDTO){

        Employee employee = employeeRepository.findById(eid).get();

        //DTO to ENTITY
        Salary salary = mapToEntity(salaryDTO);
        salary.setEmployee(employee);
        Salary newSalary = salaryRepository.save(salary);

        //ENTITY to DTO
        SalaryDTO salaryDTO1 = mapToDTO(newSalary);
        return salaryDTO1;
    }
}
