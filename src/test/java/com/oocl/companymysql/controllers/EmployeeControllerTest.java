package com.oocl.companymysql.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.companymysql.entities.Employee;
import com.oocl.companymysql.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void should_ReturnEmployeeDetails_when_call_getEmployee() throws Exception {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("alibaba1", 20, "male", 6000);
        employees.add(employee);
        given(employeeService.getEmployees()).willReturn(employees);

        mockMvc.perform(get("/employees")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("alibaba1"))
                .andExpect(jsonPath("$[0].age").value(20))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(6000));
    }

    @Test
    public void should_return_employee_when_call_addEmployee()throws Exception{
        Employee employee = new Employee("bob",20,"male",5000);
        when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(employee)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    public void should_return_employee_when_call_findEmployeesById() throws Exception{
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("alibaba1", 20, "male", 6000);
        employees.add(employee);
        given(employeeService.findEmployeeById(any())).willReturn(employee);

        mockMvc.perform(get("/employees/1"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("alibaba1"))
                .andExpect(jsonPath("age").value(20))
                .andExpect(jsonPath("gender").value("male"))
                .andExpect(jsonPath("salary").value(6000));
    }
    
    @Test
    public void should_return_employees_when_call_findByGender()throws Exception{
        ArrayList<Employee> employees1 = new ArrayList<>();
        ArrayList<Employee> employees2 = new ArrayList<>();
        Employee employee1 = new Employee("alibaba1", 20, "female", 6000);
        employees1.add(employee1);
        Employee employee2 = new Employee("alibaba2", 20, "male", 6000);
        employees1.add(employee2);
        employees2.add(employee2);
        given(employeeService.findEmployeesByGender(any())).willReturn(employees2);

        mockMvc.perform(get("/employees/male"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("alibaba2"))
                .andExpect(jsonPath("$[0].age").value(20))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(6000));
    }

    @Test
    public void should_return_employee_when_call_delEmployee() throws Exception{
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("alibaba1", 20, "male", 6000);
        employees.add(employee);
        given(employeeService.delEmployee(any())).willReturn(employee);

        mockMvc.perform(delete("/employees/1")).andExpect(status().isOk())
                .andExpect(jsonPath("name").value("alibaba1"))
                .andExpect(jsonPath("age").value(20))
                .andExpect(jsonPath("gender").value("male"))
                .andExpect(jsonPath("salary").value(6000));
    }
    
//    @Test
//    public void should_return_employees_by_page_when_call_showEmployeesByPage() throws Exception{
//        ArrayList<Employee> employees = new ArrayList<>();
//        Employee employee = new Employee("alibaba1", 20, "male", 6000);
//        employees.add(employee);
//        Pageable pageable = new PageRequest(0,3);
//        given(employeeService.showEmployeesByPage(any())).willReturn(employees);
//
//        mockMvc.perform(get("/employees/pageable")).andExpect(status().isOk())
//                .andExpect(jsonPath("name").value("alibaba1"))
//                .andExpect(jsonPath("age").value(20))
//                .andExpect(jsonPath("gender").value("male"))
//                .andExpect(jsonPath("salary").value(6000));
//    }
}
