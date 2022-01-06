package com.tamaraw.ypebackend.employees.model;

import java.math.BigDecimal;

public class EmployeeIncomeDto {

    private BigDecimal regularPay;
    private BigDecimal cola;
    private BigDecimal totalOtPay;
    private BigDecimal totalOtSunHolidayPay;
    private BigDecimal totalUtDeduction;
    private BigDecimal grossPay;

    public EmployeeIncomeDto() {}

    public BigDecimal getRegularPay() {
        return regularPay;
    }

    public void setRegularPay(BigDecimal regularPay) {
        this.regularPay = regularPay;
    }

    public BigDecimal getCola() {
        return cola;
    }

    public void setCola(BigDecimal cola) {
        this.cola = cola;
    }

    public BigDecimal getTotalOtPay() {
        return totalOtPay;
    }

    public void setTotalOtPay(BigDecimal totalOtPay) {
        this.totalOtPay = totalOtPay;
    }

    public BigDecimal getTotalOtSunHolidayPay() {
        return totalOtSunHolidayPay;
    }

    public void setTotalOtSunHolidayPay(BigDecimal totalOtSunHolidayPay) {
        this.totalOtSunHolidayPay = totalOtSunHolidayPay;
    }

    public BigDecimal getTotalUtDeduction() {
        return totalUtDeduction;
    }

    public void setTotalUtDeduction(BigDecimal totalUtDeduction) {
        this.totalUtDeduction = totalUtDeduction;
    }

    public BigDecimal getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(BigDecimal grossPay) {
        this.grossPay = grossPay;
    }
}
