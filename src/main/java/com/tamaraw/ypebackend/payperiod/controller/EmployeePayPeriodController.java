package com.tamaraw.ypebackend.payperiod.controller;

import com.tamaraw.ypebackend.base.model.ResponseDto;
import com.tamaraw.ypebackend.base.model.ResponseDtoWithObject;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriodDto;
import com.tamaraw.ypebackend.employees.service.EmployeePayPeriodService;
import com.tamaraw.ypebackend.payperiod.model.EmployeePayPeriodUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "payPeriodEmployeePayPeriodController")
@RequestMapping("/api/v1/payperiod/employee")
public class EmployeePayPeriodController {

    @Autowired
    private EmployeePayPeriodService employeePayPeriodService;

    @PostMapping
    public ResponseEntity<ResponseDto> update(@RequestBody EmployeePayPeriodUpdateDto dto) {
        try {
            EmployeePayPeriodDto employeePayPeriodDto = employeePayPeriodService.update(dto);
            return ResponseEntity.ok(new ResponseDtoWithObject(employeePayPeriodDto, 200, ""));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto(500, e.getMessage()));
        }
    }
}
