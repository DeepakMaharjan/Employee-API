package com.deepak.employeeapi.API;

import com.deepak.employeeapi.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {

    //GET data from http://dummy.restapiexample.com/api/v1/employees
    @GET("employees")

    Call<List<Employee>> getAllEmployees();
}
