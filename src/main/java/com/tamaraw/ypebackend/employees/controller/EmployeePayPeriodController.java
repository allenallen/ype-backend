package com.tamaraw.ypebackend.employees.controller;

import com.tamaraw.ypebackend.base.controller.CrudController;
import com.tamaraw.ypebackend.base.model.ResponseDto;
import com.tamaraw.ypebackend.base.model.ResponseDtoWithObject;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriodDto;
import com.tamaraw.ypebackend.employees.service.EmployeePayPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employeePayPeriod")
public class EmployeePayPeriodController {

    private EmployeePayPeriodService employeePayPeriodService;

    @Autowired
    public EmployeePayPeriodController(EmployeePayPeriodService employeePayPeriodService) {
        this.employeePayPeriodService = employeePayPeriodService;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<ResponseDto> getByEmployee(@PathVariable String id) {
        try {
            return ResponseEntity.ok(new ResponseDtoWithObject(employeePayPeriodService.getAllByEmployee(id), 200, ""));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseDto(500, e.getMessage()));
        }
    }
}
