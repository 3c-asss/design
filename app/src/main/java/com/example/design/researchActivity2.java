package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class researchActivity2 extends AppCompatActivity implements View.OnClickListener {
private Button btn_mima2,btn_reg1,yanzhengma;
private EditText PN;
String telphone;
    private Object researchActivity2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reseach2);
        initView();
        //验证手机号是否正确
        //测试
      //获取可编辑文本框内容
        EditText PN=(EditText)findViewById(R.id.phone_number);

        btn_mima2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(researchActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(researchActivity2.this, registation.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btn_mima2=(Button)findViewById(R.id.btn_mima2);
        btn_reg1=(Button)findViewById(R.id.btn_reg1);
        yanzhengma=(Button)findViewById((R.id.yanzhengma));
        yanzhengma.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yanzhengma:
               // String toString=phone_number.getText().toString();

        }
    }

    //验证手机号

}