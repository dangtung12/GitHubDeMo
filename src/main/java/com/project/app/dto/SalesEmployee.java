package com.project.app.dto;

import lombok.Data;


@Data
public class SalesEmployee extends Employee {

    private Integer _id;
    private Integer otHours;
    private Integer hourWork;
    private Double netSalary;
    private final static Double OT_SALARY = Double.valueOf(30000);

    @Override
    public Double calculateSalary() {
        this.netSalary = (baseSalary * hourWork) + (otHours * OT_SALARY);
        return this.netSalary;
    }

}
