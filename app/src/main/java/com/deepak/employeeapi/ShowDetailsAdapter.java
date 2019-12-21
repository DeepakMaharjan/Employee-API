package com.deepak.employeeapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShowDetailsAdapter extends RecyclerView.Adapter<ShowDetailsAdapter.ShowDetailsHolder>{

    Context mContext;
    List<ShowDetails> showDetailsList;

    public ShowDetailsAdapter(Context mContext, List<ShowDetails> showDetailsList) {
        this.mContext = mContext;
        this.showDetailsList = showDetailsList;
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
        ShowDetails showDetails = showDetailsList.get(position);
        holder.tvShowEId.setText(showDetails.getEmployee_id());
        holder.tvShowEName.setText(showDetails.getEmployee_name());
        holder.tvShowESalary.setText(showDetails.getEmployee_salary());
        holder.tvShowEAge.setText(showDetails.getEmployee_age());

    }

    @Override
    public int getItemCount() {
        return showDetailsList.size();
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
