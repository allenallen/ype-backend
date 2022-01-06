package com.tamaraw.ypebackend.employees.model;

import com.tamaraw.ypebackend.base.model.EntityDto;

import java.math.BigDecimal;

public class EmployeeCompensationDto extends EntityDto {

    private EmployeeDto employee;
    private BigDecimal dailySalary;
    private BigDecimal dailyAllowance;
    private boolean hasPhilHealth;
    private boolean hasPagibig;
    private boolean hasSss;
    private EmployeeIncomeDto income;
    private BigDecimal totalDeductions;
    private BigDecimal netPay;

    public EmployeeCompensationDto(EmployeeCompensation employeeCompensation) {
        super(employeeCompensation.getId());
        this.employee = new EmployeeDto(employeeCompensation.getEmployee());
        this.dailyAllowance = employeeCompensation.getDailyAllowance();
        this.dailySalary = employeeCompensation.getDailySalary();
        this.hasPagibig = employeeCompensation.isHasPagibig();
        this.hasPhilHealth = employeeCompensation.isHasPhilHealth();
        this.hasSss = employeeCompensation.isHasSss();
    }


    public EmployeeIncomeDto getIncome() {
        return income;
    }

    public void setIncome(EmployeeIncomeDto income) {
        this.income = income;
    }

    public BigDecimal getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(BigDecimal totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        this.netPay = netPay;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public BigDecimal getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(BigDecimal dailySalary) {
        this.dailySalary = dailySalary;
    }

    public BigDecimal getDailyAllowance() {
        return dailyAllowance;
    }

    public void setDailyAllowance(BigDecimal dailyAllowance) {
        this.dailyAllowance = dailyAllowance;
    }

    public boolean isHasPhilHealth() {
        return hasPhilHealth;
    }

    public void setHasPhilHealth(boolean hasPhilHealth) {
        this.hasPhilHealth = hasPhilHealth;
    }

    public boolean isHasPagibig() {
        return hasPagibig;
    }

    public void setHasPagibig(boolean hasPagibig) {
        this.hasPagibig = hasPagibig;
    }

    public boolean isHasSss() {
        return hasSss;
    }

    public void setHasSss(boolean hasSss) {
        this.hasSss = hasSss;
    }

    public EmployeeCompensationDto() {
        super("");
    }
}
