package com.oocl.companymysql.controllers;

import com.oocl.companymysql.entities.Employee;
import com.oocl.companymysql.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee newEmployee){
        return employeeService.addEmployee(newEmployee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeesById(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }
}
