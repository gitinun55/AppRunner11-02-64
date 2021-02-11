package com.example.apprunner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ChooseUserDistanceAdapter extends RecyclerView.Adapter<ChooseUserDistanceAdapter.Holder> {

    Context context;
    List<ResultQuery> resultQueries;

    public ChooseUserDistanceAdapter(Context context, List<ResultQuery> resultQueries){
        this.context = context;
        this.resultQueries = resultQueries;
    }

    @NonNull
    @Override
    public ChooseUserDistanceAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_choose_user_distance,parent,false);
        return new ChooseUserDistanceAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseUserDistanceAdapter.Holder holder, int position) {
        final ResultQuery resultQuery = resultQueries.get(position);
        holder.id_user.setText(Integer.toString(resultQuery.getId()));
        holder.FName_user.setText(resultQuery.getFirst_name());
        holder.LName_user.setText(resultQuery.getLast_name());
    }

    @Override
    public int getItemCount() {
        return resultQueries.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView id_user,FName_user,LName_user,status_user_distance;
        Button btn_detail_distance_event;
        public Holder(@NonNull View itemView) {
            super(itemView);
            id_user = (TextView)itemView.findViewById(R.id.id_user);
            FName_user = (TextView)itemView.findViewById(R.id.FName_user);
            LName_user = (TextView)itemView.findViewById(R.id.LName_user);
            status_user_distance = (TextView)itemView.findViewById(R.id.status_user_distance);
        }
    }
}