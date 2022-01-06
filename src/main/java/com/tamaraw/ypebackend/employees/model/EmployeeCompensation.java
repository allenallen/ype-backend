package com.tamaraw.ypebackend.employees.model;

import com.tamaraw.ypebackend.base.model.AuditableEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class EmployeeCompensation extends AuditableEntity {

    @OneToOne(cascade = CascadeType.REMOVE)
    private Employee employee;

    private BigDecimal dailySalary = BigDecimal.ZERO;

    private BigDecimal dailyAllowance = BigDecimal.ZERO;

    @Column(columnDefinition = "boolean default false")
    private boolean hasPhilHealth;

    @Column(columnDefinition = "boolean default false")
    private boolean hasPagibig;

    @Column(columnDefinition = "boolean default false")
    private boolean hasSss;

    public void updateDetails(EmployeeCompensationDto dto) {
        this.dailyAllowance = dto.getDailyAllowance();
        this.dailySalary = dto.getDailySalary();
        this.hasPagibig = dto.isHasPagibig();
        this.hasSss = dto.isHasSss();
        this.hasPhilHealth = dto.isHasPhilHealth();
    }

    public static EmployeeCompensation create(EmployeeCompensationDto employeeCompensationDto, Employee employee) {
        EmployeeCompensation employeeCompensation = new EmployeeCompensation();
        employeeCompensation.setEmployee(employee);
        employeeCompensation.setDailyAllowance(employeeCompensationDto.getDailyAllowance());
        employeeCompensation.setDailySalary(employeeCompensationDto.getDailySalary());
        employeeCompensation.setHasPagibig(employeeCompensationDto.isHasPagibig());
        employeeCompensation.setHasPhilHealth(employeeCompensationDto.isHasPhilHealth());
        employeeCompensation.setHasSss(employeeCompensation.isHasSss());
        return employeeCompensation;
    }

    public static EmployeeCompensation createInitial(Employee employee) {
        EmployeeCompensation employeeCompensation = new EmployeeCompensation();
        employeeCompensation.setEmployee(employee);
        return employeeCompensation;
    }

    protected EmployeeCompensation() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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
}
