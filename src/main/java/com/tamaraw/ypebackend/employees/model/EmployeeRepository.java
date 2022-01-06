package com.tamaraw.ypebackend.employees.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("SELECT employee FROM Employee employee SORT BY employee.getCreatedAt()")
    List<Employee> findAllSorted();
}
