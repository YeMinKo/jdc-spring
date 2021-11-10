package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringBean1 {

    @Value("#{ 'Wall Street'.toUpperCase() }")
    private String streetName;

    @Value("#{ '${app.department.name}'.toUpperCase() }")
    private String departmentName;

    @Value("#{ ${app.cases.map} }")
    private Map<String, Integer> casesMap;

    // take from other bean
    @Value("#{springBean2.taxId}")
    private int taxId;

    public String getStreetName() {
        return streetName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Map<String, Integer> getCasesMap() {
        return casesMap;
    }

    public int getTaxId() {
        return taxId;
    }
}
