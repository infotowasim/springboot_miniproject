package com.ems.services;

import com.ems.payload.BonusDTO;

public interface BonusService {

    BonusDTO createBonus(long eid, BonusDTO bonusDTO);

}
