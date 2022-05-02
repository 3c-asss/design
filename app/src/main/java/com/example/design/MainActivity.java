package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class MainActivity extends AppCompatActivity  {
    private Button btn_code,btn_psd,btn_log,btn_forget, btn_reg;
    private EditText et_password,et_account;
  //  private ImageButton bt_change_mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_code = (Button) findViewById(R.id.btn_code);
        btn_psd = (Button) findViewById(R.id.btn_psd);
        btn_log = (Button) findViewById(R.id.btn_log);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
        Map<String, String> userInfo = SPSave.getUserInfo(this);
        final EditText et_password = (EditText) findViewById(R.id.et_password);
        final ImageButton bt_change_mode = (ImageButton) findViewById(R.id.bt_change_mode);
        //设置密码可见不可见
        bt_change_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_password.getInputType() == 128) {//如果现在是显示密码模式
                    et_password.setInputType(129);//设置为隐藏密码
                    //  bt_change_mode.setText("密码不可见");
                } else {
                    et_password.setInputType(128);//设置为显示密码
                    //  bt_change_mode.setText("密码可见");
                }
                et_password.setSelection(et_password.getText().length());//设置光标的位置到末尾
            }
        });

        //实现跳转至主页面
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, researchActivity2.class);
                startActivity(intent);
            }
        });
        //跳转注册账户
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registation.class);
                startActivity(intent);
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, nav_MainActivity2.class);
                String account = et_account.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                boolean isSaveSuccess = SPSave.saveUserInfo(MainActivity.this, account, password);
                if (account.length() == 0) {
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else if (4 >= account.length()) {
                    Toast.makeText(MainActivity.this, "用户名长度应在4-18字之间", Toast.LENGTH_SHORT).show();
                } else if (account.length() >= 18) {
                    Toast.makeText(MainActivity.this, "用户名长度应在4-18字之间", Toast.LENGTH_SHORT).show();
                } else if (account.length() >= 18) {
                    Toast.makeText(MainActivity.this, "用户名长度应在4-18字之间", Toast.LENGTH_SHORT).show();
                } else if (4 >= password.length()) {
                    Toast.makeText(MainActivity.this, "用户名长度应在4-18字之间", Toast.LENGTH_SHORT).show();
                } else if (password.length() >= 18) {
                    Toast.makeText(MainActivity.this, "用户名长度应在4-18字之间", Toast.LENGTH_SHORT).show();
                } else if (password.length() >= 18) {
                    Toast.makeText(MainActivity.this, "用户名长度应在4-18字之间", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "保存成功!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }

            ;
        });


    }


};