package com.tamaraw.ypebackend.employees.service;

import com.tamaraw.ypebackend.base.exceptions.DeleteException;
import com.tamaraw.ypebackend.base.exceptions.NotFoundException;
import com.tamaraw.ypebackend.base.exceptions.ServiceException;
import com.tamaraw.ypebackend.base.utils.Helper;
import com.tamaraw.ypebackend.employees.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeCompensationRepository employeeCompensationRepository;
    private final Helper helper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, Helper helper, EmployeeCompensationRepository employeeCompensationRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCompensationRepository = employeeCompensationRepository;
        this.helper = helper;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        try {
            Employee employee = employeeRepository.save(Employee.create(employeeDto));
            EmployeeCompensation employeeCompensation = EmployeeCompensation.createInitial(employee);
            employeeCompensation = employeeCompensationRepository.save(employeeCompensation);
            return new EmployeeDto(employee, employeeCompensation);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(helper.getI18Nmessage("default.failed.message"));
        }
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeDto.getId());

        if (employeeOptional.isEmpty()) {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", employeeDto.getId()));
        }

        Employee employee = employeeOptional.get();
        employee.updateDetails(employeeDto);
        employee = employeeRepository.save(employee);
        return new EmployeeDto(employee);
    }

    @Override
    public boolean delete(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            try {
                employeeRepository.delete(employeeOptional.get());
            } catch (Exception e) {
                throw new DeleteException(helper.getI18Nmessage("default.delete.failed.message", id));
            }
            return true;
        } else {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", id));
        }
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAllSorted();
        return employees.stream().map(employee -> {
            EmployeeCompensation employeeCompensation = employeeCompensationRepository.findEmployeeCompensationByEmployee(employee);
            return new EmployeeDto(employee, employeeCompensation);
        }).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getOne(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            EmployeeCompensation employeeCompensation = employeeCompensationRepository.findEmployeeCompensationByEmployee(employee);
            return new EmployeeDto(employee, employeeCompensation);
        } else {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", id));
        }
    }
}
