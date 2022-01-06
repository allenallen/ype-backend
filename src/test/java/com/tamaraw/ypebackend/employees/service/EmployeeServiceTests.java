//package com.tamaraw.ypebackend.employees.service;
//
//import com.tamaraw.ypebackend.base.exceptions.NotFoundException;
//import com.tamaraw.ypebackend.employees.model.Employee;
//import com.tamaraw.ypebackend.employees.model.EmployeeRepository;
//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//
//import java.util.Optional;
//
//@RunWith(JUnit4.class)
//public class EmployeeServiceTests {
//
//    private EmployeeServiceImpl employeeService;
//    private EmployeeRepository employeeRepository;
//
//    @Before
//    public void init() {
//        EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
//        this.employeeRepository = employeeRepository;
//        this.employeeService = new EmployeeServiceImpl(employeeRepository);
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void getOne_throwNotFoundError() {
//        Mockito.when(employeeRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
//        employeeService.getOne("");
//    }
//
//    @Test
//    public void getOne_NotFound_CorrectMessage() {
//        Mockito.when(employeeRepository.findById("mockId")).thenReturn(Optional.empty());
//        try {
//            employeeService.getOne("mockId");
//        } catch (NotFoundException e) {
//            Assert.assertThat(e.getMessage(), Matchers.equalTo("Employee with id mockId not found"));
//        }
//    }
//}
