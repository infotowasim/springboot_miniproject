package com.ems.services;

import com.ems.entities.Bonus;
import com.ems.entities.Employee;
import com.ems.payload.BonusDTO;
import com.ems.repositories.BonusRepository;
import com.ems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusServiceImpl implements BonusService{

    @Autowired
    private BonusRepository bonusRepository;

    @Autowired
    private EmployeeRepository employeeRepository;



    //DTO to ENTITY
    private Bonus mapToEntity(BonusDTO bonusDTO){

        Bonus bonus = new Bonus();
        bonus.setAmount(bonusDTO.getAmount());
        return bonus;
    }


    //ENTITY to DTO
    private BonusDTO mapToDTO(Bonus bonus){

        BonusDTO bonusDTO1 = new BonusDTO();

        bonusDTO1.setBid(bonus.getBid());
        bonusDTO1.setAmount(bonus.getAmount());

        return bonusDTO1;
    }



    @Override
    public BonusDTO createBonus(long eid, BonusDTO bonusDTO){

        Employee employee = employeeRepository.findById(eid).get();

        //DTO to ENTITY
        Bonus bonus = mapToEntity(bonusDTO);
        bonus.setEmployee(employee); // set the bonus for that employee.
        Bonus newBonus = bonusRepository.save(bonus);

        //ENTITY to DTO
        BonusDTO bonusDTO1 = mapToDTO(newBonus);

        return bonusDTO1;
    }
}
