package com.tamaraw.ypebackend.employees.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeCompensationRepository extends JpaRepository<EmployeeCompensation, String> {

    EmployeeCompensation findEmployeeCompensationByEmployee(Employee employee);

}
