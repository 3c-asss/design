package com.example.design;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.design.bean.Student;
import com.example.design.utils.ToastUtil;

public class activity_update extends AppCompatActivity {
    private EditText etName,etNumber,etScore;
    private RadioButton rbMan,rbWoman;
    private MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);
    }
    private void initView() {

        etName = findViewById(R.id.et_name);
        etNumber = findViewById(R.id.et_number);
        etScore = findViewById(R.id.et_score);
        rbMan = findViewById(R.id.rb_man);
        rbWoman = findViewById(R.id.rb_woman);

    }
    public void updateOnClick(View view) {
        String name = etName.getText().toString().trim();
        String number = etNumber.getText().toString().trim();
        String score = etScore.getText().toString().trim();
        String gender = "";

        if (rbMan.isChecked()) {
            gender = "男";
        }

        if (rbWoman.isChecked()) {
            gender = "女";
        }

        Student student = new Student();
        student.setName(name);
        student.setNumber(number);
        student.setGender(gender);
        student.setScore(score);

        int rowId = mMySQLiteOpenHelper.updateData(student);
        if (rowId > 0) {
            ToastUtil.toastShort(this, "更新成功！");
        } else {
            ToastUtil.toastShort(this, "没有数据被更新！");
        }
    }
}