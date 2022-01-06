package com.tamaraw.ypebackend.payperiod.utils;

import com.tamaraw.ypebackend.base.exceptions.NotFoundException;
import com.tamaraw.ypebackend.base.utils.Helper;
import com.tamaraw.ypebackend.employees.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class SalaryCalculator {

    @Autowired
    private EmployeeCompensationRepository employeeCompensationRepository;

    @Autowired
    private Helper helper;

    public EmployeePayPeriodDto calculate(EmployeePayPeriod employeePayPeriod) {
        Employee employee = employeePayPeriod.getEmployee();
        EmployeeCompensation employeeCompensation = getEmployeeCompensation(employee);
        EmployeePayPeriodDto dto = new EmployeePayPeriodDto(employeePayPeriod);
        populateCalculatedDto(dto, employeeCompensation);

        return dto;
    }

    private void populateCalculatedDto(EmployeePayPeriodDto dto, EmployeeCompensation employeeCompensation) {
        BigDecimal numberOfDays = dto.getNumberOfDays();
        BigDecimal otHours = dto.getOtHours();
        BigDecimal utHours = dto.getUtHours();
        BigDecimal otSunHolidayHours = dto.getOtSunHolidayHours();
        BigDecimal dailyAllowance = employeeCompensation.getDailyAllowance();
        BigDecimal dailySalary = employeeCompensation.getDailySalary();
        BigDecimal hourlyPay = numberOfDays.intValue() == 0 ?
                BigDecimal.ZERO :
                dailySalary.divide(numberOfDays, 2, RoundingMode.FLOOR);

        dto.setIncome(new EmployeeIncomeDto());
        dto.getIncome().setRegularPay(numberOfDays.multiply(dailySalary).setScale(2, RoundingMode.FLOOR));
        dto.getIncome().setTotalOtPay(otHours.multiply(hourlyPay).multiply(new BigDecimal("1.25")).setScale(2, RoundingMode.FLOOR));
        dto.getIncome().setTotalOtSunHolidayPay(otSunHolidayHours.multiply(hourlyPay).multiply(new BigDecimal("1.30")).setScale(2, RoundingMode.FLOOR));
        dto.getIncome().setTotalUtDeduction(utHours.multiply(hourlyPay).setScale(2, RoundingMode.FLOOR));
        dto.getIncome().setCola(numberOfDays.multiply(dailyAllowance).setScale(2, RoundingMode.FLOOR));
        dto.getIncome().setGrossPay(
                dto.getIncome().getRegularPay()
                        .add(
                                dto.getIncome().getCola())
                        .add(
                                dto.getIncome().getTotalOtPay())
                        .add(
                                dto.getIncome().getTotalOtSunHolidayPay())
                        .subtract(
                                dto.getIncome().getTotalUtDeduction())
        );
    }

    private EmployeeCompensation getEmployeeCompensation(Employee employee) {
        EmployeeCompensation employeeCompensation = employeeCompensationRepository.findEmployeeCompensationByEmployee(employee);
        if (employeeCompensation == null) {
            throw new NotFoundException(helper.getI18Nmessage("default.not.found.of.object.message", "Employee Compensation", employee.getFullName()));
        }

        return employeeCompensation;
    }

}
