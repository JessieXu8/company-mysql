package com.oocl.companymysql.services;

import com.oocl.companymysql.entities.Company;
import com.oocl.companymysql.entities.Employee;
import com.oocl.companymysql.repositories.CompanyRepository;
import com.oocl.companymysql.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Company addCompany(Company newCompany) {
        newCompany.getEmployeesList().stream().forEach(employee -> {
            employee.setCompany(newCompany);
        });
        return companyRepository.save(newCompany);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

    public List<Employee> getEmployeesOfCompanyById(Long id) {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            if (employee.getCompany().getId().equals(id)){
                employees.add(employee);
            }
        });
        return employees;
    }

    public List<Company> showCompaniesByPage(Pageable pageable) {
        Page<Company> companiesList = companyRepository.findAll(pageable);
        return companiesList.getContent();
    }
}
