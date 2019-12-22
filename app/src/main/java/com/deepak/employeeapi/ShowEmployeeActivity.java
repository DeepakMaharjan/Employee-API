package com.deepak.employeeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.deepak.employeeapi.API.EmployeeAPI;
import com.deepak.employeeapi.JSONresponse.JSONresponse;
import com.deepak.employeeapi.URL.URL;
import com.deepak.employeeapi.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowEmployeeActivity extends AppCompatActivity {

    private TextView tvEmployees;

    //private RecyclerView recyclerView;
    //private ArrayList<Employee> data;
    //private ShowDetailsAdapter showDetailsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);

        //recyclerView = findViewById(R.id.recyclerView);

        tvEmployees = findViewById(R.id.tvEmployees);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<List<Employee>> listCall = employeeAPI.getAllEmployees();

        //Asynchronous Call
        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ShowEmployeeActivity.this, "Error code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Employee> employeeList = response.body();

                //JSONresponse jsonResponse = response.body();

                //data = new ArrayList<>(Arrays.asList(employeeList.getEmployees()));
                //showDetailsAdapter = new ShowDetailsAdapter(data);
                //recyclerView.setAdapter(showDetailsAdapter);


                for (Employee emp : employeeList) {

                    String data = "";

                    data += "ID : " +emp.getId() + "\n";
                    data += "Name is :" + emp.getEmployee_name() + "\n";
                    data += "Salary is : " + emp.getEmployee_salary() + "\n";
                    data += "Age is : " + emp.getEmployee_age() + "\n";
                    data += "-------------------------------" + "\n";

                    //employeeList.add(new Employee(data));
                    tvEmployees.append(data);


                    //ShowDetailsAdapter showDetailsAdapter = new ShowDetailsAdapter(this, employeeList);
                    //recyclerView.setAdapter(showDetailsAdapter);
                    //recyclerView.setLayoutManager(new LinearLayoutManager(ShowEmployeeActivity.this, LinearLayoutManager.VERTICAL, false));
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("Msg", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(ShowEmployeeActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//        List<ShowDetails> showDetailsList = new ArrayList<>();
//        showDetailsList.add(new ShowDetails("1", "Deepak Maharjan", "$100.00", "19"));
//        showDetailsList.add(new ShowDetails("2", "Devish Shakya", "$95.00", "18"));
//        showDetailsList.add(new ShowDetails("3", "Mamata Dangol", "$105.00", "20"));
//        showDetailsList.add(new ShowDetails("4", "Saugat Subedi", "$200.00", "19"));
//        showDetailsList.add(new ShowDetails("5", "Anish Kumar Thakur", "$80.00", "25"));
//        showDetailsList.add(new ShowDetails("6", "Dipesh Maharjan", "$250.00", "12"));


//        ShowDetailsAdapter showDetailsAdapter = new ShowDetailsAdapter(this, showDetailsList);
//        recyclerView.setAdapter(showDetailsAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }
}
