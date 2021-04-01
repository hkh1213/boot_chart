package com.chartprj.chart.repository;

import java.util.Optional;

import com.chartprj.chart.model.ERole;
import com.chartprj.chart.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}