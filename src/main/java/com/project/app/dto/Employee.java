package com.project.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {

    protected Integer id;
    protected String fullName;
    protected String gender;
    protected String phone;
    protected String position;
    protected Double baseSalary;
    private String dateReceived;

    public abstract Double calculateSalary();
}
