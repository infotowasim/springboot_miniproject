package com.ems1.services;

import com.ems1.entities.Employee;
import com.ems1.payload.EmployeeDTO;
import com.ems1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;


    //DTO to ENTITY

    private Employee mapToEntity(EmployeeDTO employeeDTO){

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setMobile(employeeDTO.getMobile());

//        employee.setSalary();
        return employee;
    }


    //ENTITY to DTO
    private EmployeeDTO mapToDTO(Employee employee){

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEid(employee.getEid());
        employeeDTO.setName(employee.getName());
        employeeDTO.setMobile(employee.getMobile());
//        employeeDTO.setSalaryDTO(employee);
        return employeeDTO;
    }


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){

        //DTO to Entity
        Employee employee = mapToEntity(employeeDTO);
//        employee.setSalary();
        Employee newEmployee = employeeRepository.save(employee);

        //ENTITY to DTO
        EmployeeDTO employeeDTO1 = mapToDTO(newEmployee);

        return employeeDTO1;
    }
}
