//package com.oocl.companymysql.repositories;
//
//import com.oocl.companymysql.entities.Company;
//import com.oocl.companymysql.entities.Employee;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class CompanyRepositoryTest {
//    @Autowired
//    private CompanyRepository repository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void should_get_employees_of_company_when_call_findByEmployeesList(){
//        Company savedCompany = entityManager.persistFlushFind(new Company("alibaba","20"));
//
//        Employee employee = new Employee("alibaba1", 20, "female", 6000);
//        savedCompany.getEmployeesList().add(employee);
//        List<Employee> employees = new ArrayList<>();
//        Long id = 1L;
////        employees=repository.findByEmployeesList(id);
//
//        Assertions.assertThat(savedCompany.getEmployeesList()).isEqualTo(employees);
//    }
//}