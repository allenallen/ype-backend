package com.tamaraw.ypebackend.employees.model;

import com.tamaraw.ypebackend.base.model.EntityDto;

import java.math.BigDecimal;

public class EmployeePayPeriodDto extends EntityDto {

    private EmployeeDto employee;
    private BigDecimal numberOfDays;
    private BigDecimal otHours;
    private BigDecimal otSunHolidayHours;
    private BigDecimal utHours;
    private EmployeeIncomeDto income;

    public EmployeePayPeriodDto(EmployeePayPeriod employeePayPeriod) {
        super(employeePayPeriod.getId());
        this.employee = new EmployeeDto(employeePayPeriod.getEmployee());
        this.numberOfDays = employeePayPeriod.getNumberOfDays();
        this.otHours = employeePayPeriod.getOtHours();
        this.otSunHolidayHours = employeePayPeriod.getOtSunHolidayHours();
        this.utHours = employeePayPeriod.getUtHours();
    }

    public EmployeePayPeriodDto(String id) {
        super(id);
    }

    public EmployeeIncomeDto getIncome() {
        return income;
    }

    public void setIncome(EmployeeIncomeDto income) {
        this.income = income;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public BigDecimal getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(BigDecimal numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public BigDecimal getOtHours() {
        return otHours;
    }

    public void setOtHours(BigDecimal otHours) {
        this.otHours = otHours;
    }

    public BigDecimal getOtSunHolidayHours() {
        return otSunHolidayHours;
    }

    public void setOtSunHolidayHours(BigDecimal otSunHolidayHours) {
        this.otSunHolidayHours = otSunHolidayHours;
    }

    public BigDecimal getUtHours() {
        return utHours;
    }

    public void setUtHours(BigDecimal utHours) {
        this.utHours = utHours;
    }
}
