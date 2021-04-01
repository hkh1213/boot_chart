package com.chartprj.chart;

import com.chartprj.chart.model.Role;
import com.chartprj.chart.model.User;
import com.chartprj.chart.repository.RoleRepository;
import com.chartprj.chart.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.logging.Logger;


@SpringBootApplication
public class JwtloginApplication implements CommandLineRunner {
    private static final Logger log
            = Logger.getLogger( JwtloginApplication.class.getName() );

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JwtloginApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        log.info("************************************************************");
        log.info("Start printing mongo objects");
        log.info("************************************************************");
        this.roleRepository.save(new Role());

        this.userRepository.save(new User());

        List<Role> primaries = this.roleRepository.findAll();
        for (Role primary : primaries) {
            log.info(primary.toString());
        }

        List<User> secondaries = this.userRepository.findAll();

        for (User secondary : secondaries) {
            log.info(secondary.toString());
        }

        log.info("************************************************************");
        log.info("Ended printing mongo objects");
        log.info("************************************************************");

    }
    }
