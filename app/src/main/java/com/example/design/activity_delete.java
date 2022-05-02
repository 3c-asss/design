package com.example.design;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.design.utils.ToastUtil;

public class activity_delete extends AppCompatActivity {
    private EditText etName;
    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        initView();
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);
    }
    private void initView() {
        etName = findViewById(R.id.et_name);

    }

    public void deleteOnClick(View view) {
        Log.i("DeleteActivity", "start deleteOnClick method");
        String name = etName.getText().toString().trim();

        int rows = mMySQLiteOpenHelper.deleteDataFromDbByName(name);

        if(rows > 0) {
            ToastUtil.toastShort(this,"删除成功， 删除了" + rows + "行");
        }else {
            ToastUtil.toastShort(this,"删除失败");
        }
        Log.i("DeleteActivity", "end deleteOnClick method");
    }
}