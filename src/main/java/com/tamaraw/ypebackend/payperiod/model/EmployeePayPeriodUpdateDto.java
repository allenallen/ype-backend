package com.tamaraw.ypebackend.payperiod.model;

import java.math.BigDecimal;

public class EmployeePayPeriodUpdateDto {

    private EmployeePayPeriodType type;

    private String employeePayPeriodId;

    private BigDecimal value;

    public EmployeePayPeriodUpdateDto() {

    }

    public EmployeePayPeriodType getType() {
        return type;
    }

    public void setType(EmployeePayPeriodType type) {
        this.type = type;
    }

    public String getEmployeePayPeriodId() {
        return employeePayPeriodId;
    }

    public void setEmployeePayPeriodId(String employeePayPeriodId) {
        this.employeePayPeriodId = employeePayPeriodId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
