package com.deepak.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.deepak.employeeapi.API.EmployeeAPI;
import com.deepak.employeeapi.URL.URL;
import com.deepak.employeeapi.model.Employee;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearchId;
    private Button btnSearchNow;
    private TextView tvSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearchId = findViewById(R.id.etSearchId);
        btnSearchNow = findViewById(R.id.btnSearchNow);
        tvSearchResult = findViewById(R.id.tvSearchResult);

        btnSearchNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etSearchId.getText())){
                    etSearchId.setError("Please enter employee Id");
                    return;
                }

                loadData();
            }
        });

    }

    private void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(etSearchId.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {

                Toast.makeText(SearchActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();

                String content = "";

                content += "Id : " + response.body().getId() + "\n";
                content += "Name : " + response.body().getEmployee_name() + "\n";
                content += "Age : " + response.body().getEmployee_age() + "\n";
                content += "Salary : " + response.body().getEmployee_salary() + "\n";

                tvSearchResult.setText(content);


            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Error ", Toast.LENGTH_LONG).show();

            }
        });
    }
}
