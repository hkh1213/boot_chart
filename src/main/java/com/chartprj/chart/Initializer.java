package com.chartprj.chart;


import java.util.ArrayList;
import java.util.Arrays;

import com.chartprj.chart.model.Customer;
import com.chartprj.chart.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
class Initializer implements CommandLineRunner {

    private final CustomerRepository repository;

    public Initializer(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {

        ArrayList<Customer> customers = new ArrayList<>(Arrays.asList(
                new Customer("Jack", "Smith", "374 William S Canning Blvd", 23),
                new Customer("Adam", "Johnson", "Fall River MA 2721. 121 Worcester Rd", 31),
                new Customer("Dana", "Bay", "Framingham MA 1701. 677 Timpany Blvd", 46)));

        System.out.println(customers);

        repository.saveAll(customers);

        repository.findAll().forEach(System.out::println);
    }
}