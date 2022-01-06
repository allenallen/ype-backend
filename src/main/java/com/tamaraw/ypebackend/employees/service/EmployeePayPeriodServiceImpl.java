package com.tamaraw.ypebackend.employees.service;

import com.tamaraw.ypebackend.base.exceptions.NotFoundException;
import com.tamaraw.ypebackend.base.utils.Helper;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriod;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriodDto;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriodRepository;
import com.tamaraw.ypebackend.payperiod.model.EmployeePayPeriodUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeePayPeriodServiceImpl implements EmployeePayPeriodService {

    @Autowired
    private EmployeePayPeriodRepository employeePayPeriodRepository;

    @Autowired
    private Helper helper;

    @Override
    public List<EmployeePayPeriodDto> getAllByEmployee(String employeeId) {
        List<EmployeePayPeriod> employeePayPeriods = employeePayPeriodRepository.findEmployeePayPeriodByEmployee(employeeId);
        return employeePayPeriods.stream().map(EmployeePayPeriodDto::new).collect(Collectors.toList());
    }

    @Override
    public EmployeePayPeriodDto update(EmployeePayPeriodUpdateDto dto) {
        Optional<EmployeePayPeriod> employeePayPeriodOptional = employeePayPeriodRepository.findById(dto.getEmployeePayPeriodId());
        if (employeePayPeriodOptional.isEmpty()) {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", dto.getEmployeePayPeriodId()));
        }

        EmployeePayPeriod employeePayPeriod = employeePayPeriodOptional.get();

        switch (dto.getType()) {
            case DAYS:
                employeePayPeriod.setNumberOfDays(dto.getValue());
                break;
            case OT:
                employeePayPeriod.setOtHours(dto.getValue());
                break;
            case OTHOL:
                employeePayPeriod.setOtSunHolidayHours(dto.getValue());
                break;
            case UT:
                employeePayPeriod.setUtHours(dto.getValue());
                break;
        }

        return new EmployeePayPeriodDto(employeePayPeriodRepository.save(employeePayPeriod));
    }
}
