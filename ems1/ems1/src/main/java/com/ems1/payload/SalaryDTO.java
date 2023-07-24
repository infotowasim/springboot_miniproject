package com.ems1.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalaryDTO {

    private Long sid;
    private BigDecimal salaryAmount;
}
