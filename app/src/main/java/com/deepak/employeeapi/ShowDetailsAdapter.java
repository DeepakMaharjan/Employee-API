package com.deepak.employeeapi;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deepak.employeeapi.model.Employee;

import java.util.List;

import retrofit2.Callback;

public class ShowDetailsAdapter extends RecyclerView.Adapter<ShowDetailsAdapter.ShowDetailsHolder>{

    Callback mContext;
    List<Employee> employeeList;

    public ShowDetailsAdapter(Callback mContext, List<Employee> employeeList) {
        this.mContext = mContext;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ShowDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_details, parent,false);
        return new ShowDetailsHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ShowDetailsHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.tvShowEId.setText(employee.getId());
        holder.tvShowEName.setText(employee.getEmployee_name());
        holder.tvShowESalary.setText(employee.getEmployee_salary());
        holder.tvShowEAge.setText(employee.getEmployee_age());

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ShowDetailsHolder extends RecyclerView.ViewHolder{

    TextView tvShowEId, tvShowEName, tvShowESalary, tvShowEAge;


        public ShowDetailsHolder(@NonNull View itemView) {
            super(itemView);
            tvShowEId = itemView.findViewById(R.id.tvShowEId);
            tvShowEName = itemView.findViewById(R.id.tvShowEName);
            tvShowESalary = itemView.findViewById(R.id.tvShowESalary);
            tvShowEAge = itemView.findViewById(R.id.tvShowEAge);
        }
    }
}
