package com.tamaraw.ypebackend.employees.model;

import com.tamaraw.ypebackend.base.model.EntityDto;

public class EmployeeDto extends EntityDto {

    private String firstName;
    private String lastName;
    private String employeeNumber;

    private EmployeeCompensationDto employeeCompensation;

    public EmployeeDto(Employee employee) {
        super(employee.getId());
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.employeeNumber = employee.getEmployeeNumber();
    }

    public EmployeeDto(Employee employee, EmployeeCompensation employeeCompensation) {
        this(employee);
        this.employeeCompensation = new EmployeeCompensationDto(employeeCompensation);
    }

    public EmployeeDto() {
        super("");
    }

    public EmployeeCompensationDto getEmployeeCompensation() {
        return employeeCompensation;
    }

    public void setEmployeeCompensation(EmployeeCompensationDto employeeCompensation) {
        this.employeeCompensation = employeeCompensation;
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
}
