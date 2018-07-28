package com.oocl.companymysql.services;

import com.oocl.companymysql.entities.Employee;
import com.oocl.companymysql.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
