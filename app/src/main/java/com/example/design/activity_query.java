package com.example.design;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.adapter.ReportAdapter;
import com.example.design.bean.Student;
import com.example.design.utils.ToastUtil;

import java.util.List;

public class activity_query extends AppCompatActivity {
    EditText etName;
    TextView tvResult;
    RecyclerView rvQuery;
    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        logInfo("into onCreate method");

        initView();
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);

        logInfo("end onCreate method");
    }
    private void initView() {
        etName = findViewById(R.id.et_name);
        tvResult = findViewById(R.id.tv_result);
        rvQuery = findViewById(R.id.rv_query);
    }

    private void queryList(List<Student> studentList){
        rvQuery.setLayoutManager(new LinearLayoutManager(this));
        ReportAdapter adapter = new ReportAdapter(this, studentList);
        rvQuery.setAdapter(adapter);
    }

    public void queryOnClick(View view) {
        logInfo("into queryOnClick method");
        String name = etName.getText().toString().trim();
        logInfo("name:" + name);
        if (TextUtils.isEmpty(name)){
            List<Student> students = mMySQLiteOpenHelper.queryAllFromDb();
            if (!students.isEmpty()){
                showData(students);
                queryList(students);
                return;
            }else {
                ToastUtil.toastShort(this, "没有查询到数据");
            }
        }else {
            List<Student> students = mMySQLiteOpenHelper.queryFromDbByName(name);
            if (!students.isEmpty()){
                showData(students);
                queryList(students);
                return;
            }else {
                ToastUtil.toastShort(this, "没有查询到数据");
            }
        }
        logInfo("end queryOnClick method");
    }

    private void showData(List<Student> students) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Student stu:students){
            stringBuilder.append("姓名：");
            stringBuilder.append(stu.getName());
            stringBuilder.append("，学号：");
            stringBuilder.append(stu.getNumber());
            stringBuilder.append(",性别：");
            stringBuilder.append(stu.getGender());
            stringBuilder.append(",分数：");
            stringBuilder.append(stu.getScore() + "\n");
        }
        tvResult.setText(stringBuilder.toString());
    }

    private void logInfo(String info){
        Log.i("QueryActivity", info);
    }
}