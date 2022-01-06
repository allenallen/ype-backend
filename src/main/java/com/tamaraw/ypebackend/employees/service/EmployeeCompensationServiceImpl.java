package com.tamaraw.ypebackend.employees.service;

import com.tamaraw.ypebackend.base.exceptions.DeleteException;
import com.tamaraw.ypebackend.base.exceptions.NotFoundException;
import com.tamaraw.ypebackend.base.utils.Helper;
import com.tamaraw.ypebackend.employees.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeCompensationServiceImpl implements EmployeeCompensationService {

    @Autowired
    private EmployeeCompensationRepository employeeCompensationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Helper helper;

    @Override
    public EmployeeCompensationDto create(EmployeeCompensationDto employeeCompensationDto) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeCompensationDto.getEmployee().getId());
        if (employeeOptional.isEmpty()) {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", employeeCompensationDto.getEmployee().getId()));
        }

        Employee employee = employeeOptional.get();
        EmployeeCompensation employeeCompensation = EmployeeCompensation.create(employeeCompensationDto, employee);
        employeeCompensation = employeeCompensationRepository.save(employeeCompensation);
        return new EmployeeCompensationDto(employeeCompensation);
    }

    @Override
    public EmployeeCompensationDto update(EmployeeCompensationDto employeeCompensationDto) {
        Optional<EmployeeCompensation> employeeCompensationOptional = employeeCompensationRepository.findById(employeeCompensationDto.getId());
        if (employeeCompensationOptional.isEmpty()) {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", employeeCompensationDto.getId()));
        }

        EmployeeCompensation employeeCompensation = employeeCompensationOptional.get();
        employeeCompensation.updateDetails(employeeCompensationDto);
        employeeCompensation = employeeCompensationRepository.save(employeeCompensation);

        return new EmployeeCompensationDto(employeeCompensation);
    }

    @Override
    public boolean delete(String id) {
        Optional<EmployeeCompensation> employeeCompensationOptional = employeeCompensationRepository.findById(id);
        if (employeeCompensationOptional.isEmpty()) {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", id));
        }

        EmployeeCompensation employeeCompensation = employeeCompensationOptional.get();
        try {
            employeeCompensationRepository.delete(employeeCompensation);
        } catch (Exception e) {
            throw new DeleteException(helper.getI18Nmessage("default.delete.failed.message", id));
        }

        return true;
    }

    @Override
    public List<EmployeeCompensationDto> getAll() {
        return employeeCompensationRepository.findAll().stream().map(EmployeeCompensationDto::new).collect(Collectors.toList());
    }

    @Override
    public EmployeeCompensationDto getOne(String id) {
        Optional<EmployeeCompensation> employeeCompensationOptional = employeeCompensationRepository.findById(id);
        if (employeeCompensationOptional.isEmpty()) {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", id));
        }

        return new EmployeeCompensationDto(employeeCompensationOptional.get());
    }
}
