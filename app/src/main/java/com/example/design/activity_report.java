package com.example.design;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.adapter.ReportAdapter;
import com.example.design.bean.Student;

import java.util.List;

public class activity_report extends AppCompatActivity {
    private RecyclerView rvReport;
    private MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        initView();

        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);
        List<Student> studentList = mMySQLiteOpenHelper.queryAllFromDb();

        rvReport.setLayoutManager(new LinearLayoutManager(this));
        ReportAdapter adapter = new ReportAdapter(this, studentList);
        rvReport.setAdapter(adapter);
    }
    private void initView() {
        rvReport = findViewById(R.id.rv_report);
    }
}
