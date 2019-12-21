package com.deepak.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
            }
        });
    }
}
