package com.project.app.dto;

import lombok.Data;

@Data
public class Manager extends Employee {

    private Integer _id;
    private Double revenue;
    private Double commissionRate;
    private Double netSalary;

    @Override
    public Double calculateSalary() {
        this.netSalary = baseSalary + (commissionRate * revenue / 100);
        return this.netSalary;
    }
}
