package com.deepak.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deepak.employeeapi.API.EmployeeAPI;
import com.deepak.employeeapi.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etSalary, etAge;
    private Button btnRegisterNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etSalary = findViewById(R.id.etSalary);
        etAge = findViewById(R.id.etAge);

        btnRegisterNow = findViewById(R.id.btnRegisterNow);

        btnRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText())){
                    etName.setError("Please enter employee name");
                    return;
                }

                if (TextUtils.isEmpty(etSalary.getText())){
                    etSalary.setError("Please enter salary");
                    return;
                }

                if (TextUtils.isEmpty(etAge.getText())){
                    etAge.setError("Please enter age");
                    return;
                }


                Register();
            }
        });
    }

    public void Register(){
        String name = etName.getText().toString();
        String salary = etSalary.getText().toString();
        int age = Integer.parseInt(etAge.getText().toString());

        EmployeeCUD employeeCUD = new EmployeeCUD(name,salary,age);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<Void> voidCall = employeeAPI.registerEmployee(employeeCUD);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(RegisterActivity.this, "You have successfully registered",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error : "+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
