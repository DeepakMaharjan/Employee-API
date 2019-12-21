package com.deepak.employeeapi;

public class ShowDetails {
    private String employee_id;
    private String employee_name;
    private String employee_salary;
    private String employee_age;

    //Constructor
    public ShowDetails(String employee_id, String employee_name, String employee_salary, String employee_age) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    //Getter and Setter


    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }
}
