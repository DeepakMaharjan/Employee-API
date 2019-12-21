package com.deepak.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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
            }
        });

    }
}
