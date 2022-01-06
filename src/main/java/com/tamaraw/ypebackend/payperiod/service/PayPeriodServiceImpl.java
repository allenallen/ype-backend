package com.tamaraw.ypebackend.payperiod.service;

import com.tamaraw.ypebackend.base.exceptions.DeleteException;
import com.tamaraw.ypebackend.base.exceptions.NotFoundException;
import com.tamaraw.ypebackend.base.utils.Helper;
import com.tamaraw.ypebackend.employees.model.Employee;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriod;
import com.tamaraw.ypebackend.employees.model.EmployeePayPeriodDto;
import com.tamaraw.ypebackend.employees.model.EmployeeRepository;
import com.tamaraw.ypebackend.payperiod.model.PayPeriod;
import com.tamaraw.ypebackend.payperiod.model.PayPeriodDto;
import com.tamaraw.ypebackend.payperiod.model.PayPeriodRepository;
import com.tamaraw.ypebackend.payperiod.utils.SalaryCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PayPeriodServiceImpl implements PayPeriodService {

    @Autowired
    private PayPeriodRepository payPeriodRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Helper helper;

    @Autowired
    private SalaryCalculator salaryCalculator;

    @Override
    public PayPeriodDto create(PayPeriodDto payPeriodDto) {
        List<Employee> employees = employeeRepository.findAll();
        PayPeriod payPeriod = payPeriodRepository.save(PayPeriod.create(payPeriodDto, employees));
        return new PayPeriodDto(payPeriod);
    }

    @Override
    public PayPeriodDto update(PayPeriodDto payPeriodDto) {
        Optional<PayPeriod> payPeriodOptional = payPeriodRepository.findById(payPeriodDto.getId());
        if (payPeriodOptional.isPresent()) {
            PayPeriod payPeriod = payPeriodOptional.get();
            payPeriod.updateDates(payPeriodDto);
            payPeriod = payPeriodRepository.save(payPeriod);
            return new PayPeriodDto(payPeriod);
        } else {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", payPeriodDto.getId()));
        }
    }

    @Override
    public boolean delete(String id) {
        Optional<PayPeriod> payPeriodOptional = payPeriodRepository.findById(id);
        if (payPeriodOptional.isPresent()) {
            PayPeriod payPeriod = payPeriodOptional.get();
            try {
                payPeriodRepository.delete(payPeriod);
            } catch (Exception e) {
                throw new DeleteException(helper.getI18Nmessage("default.delete.failed.message", id));
            }
            return true;
        } else {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", id));
        }
    }

    @Override
    public List<PayPeriodDto> getAll() {
        List<PayPeriod> payPeriods = payPeriodRepository.findAll();
        return payPeriods.stream().map(PayPeriodDto::new).collect(Collectors.toList());
    }

    @Override
    public PayPeriodDto getOne(String id) {
        Optional<PayPeriod> payPeriodOptional = payPeriodRepository.findById(id);
        if (payPeriodOptional.isPresent()) {
            PayPeriod payPeriod = payPeriodOptional.get();
            PayPeriodDto payPeriodDto = new PayPeriodDto(payPeriod);
            payPeriodDto.setEmployees(new ArrayList<>());

            for (EmployeePayPeriod employeePayPeriod : payPeriod.getEmployees()) {
                payPeriodDto.getEmployees().add(salaryCalculator.calculate(employeePayPeriod));
            }

            return payPeriodDto;
        } else {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.message", id));
        }
    }
}
