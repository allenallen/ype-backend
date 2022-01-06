package com.tamaraw.ypebackend.payperiod.model;

import com.tamaraw.ypebackend.base.model.AuditableEntity;
import com.tamaraw.ypebackend.employees.model.Employee;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriod;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PayPeriod extends AuditableEntity {

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "payPeriod", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<EmployeePayPeriod> employees = new ArrayList<>();

    public static PayPeriod create(PayPeriodDto dto, List<Employee> employees) {
        PayPeriod payPeriod = new PayPeriod();
        payPeriod.setStartDate(dto.getStartDate());
        payPeriod.setEndDate(dto.getEndDate());

        for (Employee employee : employees) {
            EmployeePayPeriod employeePayPeriod = EmployeePayPeriod.create(employee, payPeriod);
            payPeriod.addEmployeePayPeriod(employeePayPeriod);
        }

        return payPeriod;
    }

    protected PayPeriod() {

    }

    public void updateDates(PayPeriodDto payPeriodDto) {
        this.startDate = payPeriodDto.getStartDate();
        this.endDate = payPeriodDto.getEndDate();
    }

    public void addEmployeePayPeriod(EmployeePayPeriod employeePayPeriod) {
        this.employees.add(employeePayPeriod);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<EmployeePayPeriod> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeePayPeriod> employees) {
        this.employees = employees;
    }
}
