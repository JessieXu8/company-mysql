package com.oocl.companymysql.repositories;

import com.oocl.companymysql.entities.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void should_get_male_employees_when_call_findByGender(){
        Employee savedemployee = entityManager.persistFlushFind(new Employee("alibaba",20,"male",6000));
        List<Employee> employees = employeeRepository.findByGender("male");
        Assertions.assertThat(employees.size()).isEqualTo(1);
    }

}