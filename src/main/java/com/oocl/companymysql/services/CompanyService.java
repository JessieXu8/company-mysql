package com.oocl.companymysql.services;

import com.oocl.companymysql.entities.Company;
import com.oocl.companymysql.entities.Employee;
import com.oocl.companymysql.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Company addCompany(Company newCompany) {
        return companyRepository.save(newCompany);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

    public List<Employee> getEmployeesOfCompanyById(Long id) {
        return companyRepository.findByEmployeesList(id);
    }
}
