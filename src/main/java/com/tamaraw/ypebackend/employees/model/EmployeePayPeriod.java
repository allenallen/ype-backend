package com.tamaraw.ypebackend.employees.model;

import com.tamaraw.ypebackend.base.model.AuditableEntity;
import com.tamaraw.ypebackend.payperiod.model.PayPeriod;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class EmployeePayPeriod extends AuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private PayPeriod payPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    private BigDecimal numberOfDays = BigDecimal.ZERO;
    private BigDecimal otHours = BigDecimal.ZERO;
    private BigDecimal otSunHolidayHours = BigDecimal.ZERO;
    private BigDecimal utHours = BigDecimal.ZERO;

    public static EmployeePayPeriod create(Employee employee, PayPeriod payPeriod) {
        EmployeePayPeriod employeePayPeriod = new EmployeePayPeriod();
        employeePayPeriod.setEmployee(employee);
        employeePayPeriod.setPayPeriod(payPeriod);
        return employeePayPeriod;
    }

    protected EmployeePayPeriod() {}

    public PayPeriod getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(PayPeriod payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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
