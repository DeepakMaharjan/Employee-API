package com.deepak.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateDeleteActivity extends AppCompatActivity {


    EditText etUDEmpNo;
    Button btnUDSearchNow;

    EditText etUDName, etUDSalary, etUDAge;
    Button btnUDUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        etUDEmpNo = findViewById(R.id.etUDEmpNo);
        btnUDSearchNow = findViewById(R.id.btnUDSearchNow);

        etUDName = findViewById(R.id.etUDName);
        etUDSalary = findViewById(R.id.etUDSalary);
        etUDAge = findViewById(R.id.etUDAge);
        btnUDUpdate = findViewById(R.id.btnUDUpdate);
    }
}
