package com.tamaraw.ypebackend.employees.model;

import com.tamaraw.ypebackend.base.model.AuditableEntity;
import com.tamaraw.ypebackend.base.model.EntityDto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends AuditableEntity {

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String employeeNumber;

    public static Employee create(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmployeeNumber(dto.getEmployeeNumber());
        return employee;
    }

    public void updateDetails(EmployeeDto dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.employeeNumber = dto.getEmployeeNumber();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    protected Employee() {

    }
}
