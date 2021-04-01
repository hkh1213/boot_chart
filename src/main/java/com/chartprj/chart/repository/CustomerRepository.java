package com.chartprj.chart.repository;

import com.chartprj.chart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByFirstname(String firstname);
}