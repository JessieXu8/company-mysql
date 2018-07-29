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

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findEmployeesByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {
        employeeRepository.findById(id).get();
        return employeeRepository.save(newEmployee);
    }

    public Employee delEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return employee;
    }
}
