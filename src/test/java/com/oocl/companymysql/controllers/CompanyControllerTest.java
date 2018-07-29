package com.oocl.companymysql.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.companymysql.entities.Company;
import com.oocl.companymysql.entities.Employee;
import com.oocl.companymysql.services.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CompanyService companyService;

    @Test
    public void should_return_company_when_call_addCompany()throws Exception{
        Company company = new Company("alibaba","20");
        when(companyService.addCompany(any(Company.class))).thenReturn(company);
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(company)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}