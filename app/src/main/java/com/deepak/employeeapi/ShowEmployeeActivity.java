package com.deepak.employeeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowEmployeeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);

        recyclerView = findViewById(R.id.recyclerView);

        List<ShowDetails> showDetailsList = new ArrayList<>();
        showDetailsList.add(new ShowDetails("1", "Deepak Maharjan", "$100.00", "19"));
        showDetailsList.add(new ShowDetails("2", "Devish Shakya", "$95.00", "18"));
        showDetailsList.add(new ShowDetails("3", "Mamata Dangol", "$105.00", "20"));
        showDetailsList.add(new ShowDetails("4", "Saugat Subedi", "$200.00", "19"));
        showDetailsList.add(new ShowDetails("5", "Anish Kumar Thakur", "$80.00", "25"));

        ShowDetailsAdapter showDetailsAdapter = new ShowDetailsAdapter(this, showDetailsList);
        recyclerView.setAdapter(showDetailsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }
}
