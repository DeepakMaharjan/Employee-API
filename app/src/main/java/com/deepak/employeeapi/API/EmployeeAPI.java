package com.deepak.employeeapi.API;

import com.deepak.employeeapi.EmployeeCUD;
import com.deepak.employeeapi.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EmployeeAPI {

    //GET data from http://dummy.restapiexample.com/api/v1/employees
    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    //GET search data from http://http://dummy.restapiexample.com/api/v1/employee/1
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empId);

    //POST data for register http://dummy.restapiexample.com/api/v1/create
    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);
}
