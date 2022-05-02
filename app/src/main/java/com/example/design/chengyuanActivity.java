package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class chengyuanActivity extends AppCompatActivity implements View.OnClickListener{
    Button   btnQueryData;
    ImageView   btnDeleteData,btnUpdateData,btnInsertData, btnReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengyuan);
        initView();
    }

    private void initView() {

        btnInsertData = findViewById(R.id.btn_insertData);
        btnQueryData = findViewById(R.id.btn_queryData);
        btnUpdateData = findViewById(R.id.btn_updateData);
        btnDeleteData = findViewById(R.id.btn_deleteData);
        btnReport = findViewById(R.id.btn_report);

        btnInsertData.setOnClickListener(this);
        btnQueryData.setOnClickListener(this);
        btnUpdateData.setOnClickListener(this);
        btnDeleteData.setOnClickListener(this);
        btnReport.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_insertData:
                Intent intent_insert = new Intent();
                intent_insert.setClass(chengyuanActivity.this, activity_insert.class);
                startActivity(intent_insert);
                break;
            case R.id.btn_queryData:
                Intent intent_query = new Intent();
                intent_query.setClass(chengyuanActivity.this, activity_query.class);
                startActivity(intent_query);
                break;
            case R.id.btn_updateData:
                Intent intent_update = new Intent();
                intent_update.setClass(chengyuanActivity.this, activity_update.class);
                startActivity(intent_update);
                break;
            case R.id.btn_deleteData:
                Intent intent_delete = new Intent();
                intent_delete.setClass(chengyuanActivity.this, activity_delete.class);
                startActivity(intent_delete);
                break;
            case R.id.btn_report:
                Intent intent_report = new Intent();
                intent_report.setClass(chengyuanActivity.this, activity_report.class);
                startActivity(intent_report);
                break;
        }
    }
}