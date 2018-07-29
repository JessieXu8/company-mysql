package com.oocl.companymysql.controllers;

import com.oocl.companymysql.entities.Company;
import com.oocl.companymysql.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Transactional
    @PostMapping(path = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company addCompany(@RequestBody Company newCompany){
        return companyService.addCompany(newCompany);
    }
}
