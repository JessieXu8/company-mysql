package com.oocl.companymysql.controllers;

import com.oocl.companymysql.entities.Company;
import com.oocl.companymysql.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Transactional
    @PostMapping(path = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company addCompany(@RequestBody Company newCompany){
        return companyService.addCompany(newCompany);
    }

    @Transactional
    @GetMapping(path = "/companies",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @Transactional
    @GetMapping(path = "/companies/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Company getCompanyById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }

}
