package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Medication;
import com.example.myapplication.Models.User;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Medication> list;

    public MyAdapter(Context context, ArrayList<Medication> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Medication user = list.get(position);
        holder.Firstname.setText(user.getRequesterName());
        holder.ContactNumber.setText(user.getContactNumber());
        holder.Address.setText(user.getAddress());
        holder.Status.setText(user.getStatus());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Firstname,ContactNumber,Address,Status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Firstname=itemView.findViewById(R.id.Name);
            ContactNumber=itemView.findViewById(R.id.con);
            Address=itemView.findViewById(R.id.address);
            Status=itemView.findViewById(R.id.status);
        }
    }
}
