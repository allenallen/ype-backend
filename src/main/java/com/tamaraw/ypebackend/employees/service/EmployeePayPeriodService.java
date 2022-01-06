package com.tamaraw.ypebackend.employees.service;

import com.tamaraw.ypebackend.base.service.CrudService;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriodDto;
import com.tamaraw.ypebackend.payperiod.model.EmployeePayPeriodUpdateDto;

import java.util.List;

public interface EmployeePayPeriodService {
    List<EmployeePayPeriodDto> getAllByEmployee(String employeeId);
    EmployeePayPeriodDto update(EmployeePayPeriodUpdateDto dto);
}
