package com.tamaraw.ypebackend.payperiod.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tamaraw.ypebackend.base.model.EntityDto;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriodDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PayPeriodDto extends EntityDto {

    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate startDate;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate endDate;

    private List<EmployeePayPeriodDto> employees;

    public PayPeriodDto(PayPeriod payPeriod) {
        super(payPeriod.getId());
        this.startDate = payPeriod.getStartDate();
        this.endDate = payPeriod.getEndDate();
    }

    public PayPeriodDto() {
        super("");
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

    public List<EmployeePayPeriodDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeePayPeriodDto> employees) {
        this.employees = employees;
    }
}
