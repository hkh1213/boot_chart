package com.chartprj.chart.payload.request;

import java.util.Set;

public class SignUpRequest {
    JwtRequest request=new JwtRequest();
    public String getUsername() {
        return request.getUsername();
    }

    public String getPassword() {
        return request.getUsername();

    }
    public String getEmail() {
        return request.getEmail();

    }

    public Set<String> getRoles() {
        return request.getRoles();
    }

}
