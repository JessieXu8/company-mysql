package com.oocl.companymysql.controllers;

import com.oocl.companymysql.entities.Employee;
import com.oocl.companymysql.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Transactional
    @PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployees(@RequestBody Employee newEmployee) {
        return employeeService.addEmployee(newEmployee);
    }

    @Transactional
    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @Transactional
    @GetMapping("/employees/{id}")
    public Employee findEmployeesById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @Transactional
    @GetMapping(path = "/employees/male", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findEmployeesByGender() {
        String gender = "male";
        return employeeService.findEmployeesByGender(gender);
    }

    @Transactional
    @PutMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployees(@PathVariable Long id, @RequestBody Employee newEmployee) {
        return employeeService.updateEmployee(id, newEmployee);
    }

    @Transactional
    @DeleteMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee delEmployees(@PathVariable Long id) {
        return employeeService.delEmployee(id);
    }

//    @Transactional
//    @GetMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Employee> showEmployeesByPage(Pageable pageable){
//        return employeeService.showEmployeesByPage(pageable);
//    }
}
