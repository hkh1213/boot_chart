package com.chartprj.chart.repository;

import com.chartprj.chart.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String>
{
}
