package com.tamaraw.ypebackend.employees.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayPeriodRepository extends JpaRepository<EmployeePayPeriod, String> {

    @Query("SELECT employeePayPeriod FROM EmployeePayPeriod employeePayPeriod WHERE employeePayPeriod.employee.id = ?1")
    List<EmployeePayPeriod> findEmployeePayPeriodByEmployee(String employeeId);
}
