package com.example.design.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;
import com.example.design.bean.Student;

import java.util.List;

public class ReportAdapter  extends RecyclerView.Adapter<ReportAdapter.MyViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Student> studentList;

    public ReportAdapter(Context context, List<Student> studentList) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(mLayoutInflater.inflate(R.layout.student_item,
                parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student = new Student();
        student = studentList.get(position);

        holder.tvName.setText(student.getName());
        holder.tvNumber.setText(student.getNumber());
        holder.tvGender.setText(student.getGender());
        holder.tvScore.setText(student.getScore());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvNumber, tvGender, tvScore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number);
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvScore = itemView.findViewById(R.id.tv_score);
        }
    }
}

