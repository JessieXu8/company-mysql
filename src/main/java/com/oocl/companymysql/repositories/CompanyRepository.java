package com.oocl.companymysql.repositories;

import com.oocl.companymysql.entities.Company;
import com.oocl.companymysql.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
