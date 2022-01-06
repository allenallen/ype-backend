package com.tamaraw.ypebackend.employees.controller;

import com.tamaraw.ypebackend.base.controller.CrudController;
import com.tamaraw.ypebackend.base.model.ResponseDto;
import com.tamaraw.ypebackend.base.model.ResponseDtoWithObject;
import com.tamaraw.ypebackend.base.service.CrudService;
import com.tamaraw.ypebackend.base.utils.Helper;
import com.tamaraw.ypebackend.employees.model.Employee;
import com.tamaraw.ypebackend.employees.model.EmployeeCompensationDto;
import com.tamaraw.ypebackend.employees.model.EmployeeDto;
import com.tamaraw.ypebackend.employees.service.EmployeeCompensationService;
import com.tamaraw.ypebackend.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController extends CrudController<EmployeeDto> {

    private final EmployeeService employeeService;
    private final EmployeeCompensationService employeeCompensationService;
    private final Helper helper;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              EmployeeCompensationService employeeCompensationService,
                              Helper helper) {
        this.employeeService = employeeService;
        this.employeeCompensationService = employeeCompensationService;
        this.helper = helper;
        super.setCrudService(employeeService);
    }

    @PostMapping("/compensation")
    public ResponseEntity<ResponseDto> updateCompensation(@RequestBody EmployeeCompensationDto employeeCompensation) {
        try {
            return ResponseEntity.ok(new ResponseDtoWithObject(employeeCompensationService.update(employeeCompensation),
                    200, helper.getI18Nmessage("default.update.success.message")));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseDto(500, e.getMessage()));
        }
    }

}
