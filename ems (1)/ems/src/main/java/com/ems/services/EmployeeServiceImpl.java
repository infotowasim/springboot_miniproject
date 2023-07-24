package com.ems.services;

import com.ems.entities.Bonus;
import com.ems.entities.Employee;
import com.ems.payload.BonusDTO;
import com.ems.payload.EmployeeDTO;
import com.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;



    //ENTITY to DTO
    private EmployeeDTO mapToDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEid(employee.getEid());
        employeeDTO.setName(employee.getName());
        employeeDTO.setCity(employee.getCity());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setMobile(employee.getMobile());

        return employeeDTO;




//        List<BonusDTO> bonusDTOS = new ArrayList<>();
//        for (Bonus bonus : employee.getBonuses()){
//            BonusDTO bonusDTO = new BonusDTO();
//            bonusDTO.setBid(bonus.getBid());
//            bonusDTO.setAmount(bonus.getAmount());
//
//            bonusDTOS.add(bonusDTO);
//        }
//        employeeDTO.setBonusDTOList(bonusDTOS);


    }



    private Employee mapToEntity(EmployeeDTO employeeDTO) {

        //DTO to ENTITY
        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setCity(employeeDTO.getCity());
        employee.setEmail(employeeDTO.getEmail());
        employee.setMobile(employeeDTO.getMobile());
        return employee;
    }





    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {


        //DTO to ENTITY
        Employee employee = mapToEntity(employeeDTO);
        Employee newEmployee = employeeRepository.save(employee);

        //ENTITY to DTO
        EmployeeDTO employeeDTO1 = mapToDTO(newEmployee);
        return employeeDTO1;


//        // let's set up the Multiple Bonuses
//        List<Bonus> bonuses = new ArrayList<>();
//        for (BonusDTO bonusDTO : employeeDTO.getBonusDTOList()){
//
//            Bonus bonus = new Bonus();
//            bonus.setAmount(bonusDTO.getAmount());
//            bonus.setEmployee(employee);
//
//            bonuses.add(bonus);
//        }
//
//        employee.setBonuses(bonuses);
//        employee = employeeRepository.save(employee);
//
//        return toDTO(employee);
    }
}
