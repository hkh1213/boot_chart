package com.chartprj.chart.model;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "admin")
public class Admin {

    @Id
    private String id;

    private  String username;

    private String email;

    private GeoJsonPoint location;
}
