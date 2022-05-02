package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class researchActivity2 extends AppCompatActivity implements View.OnClickListener {
private Button btn_mima2,btn_reg1,yanzhengma;
private EditText phone_number;
    private Object researchActivity2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reseach2);
        initView();
        //验证手机号是否正确
        //测试
        EditText phone_number=(EditText)findViewById(R.id.phone_number);

        String telphone=phone_number.getText().toString();

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

                String telphone=phone_number.getText().toString();
                boolean judge = isMobileNO(telphone);
                if (judge == true) {
                    Intent intent_insert = new Intent();
                    intent_insert.setClass(researchActivity2.this, nav_MainActivity2.class);
                    startActivity(intent_insert);
                } else {
                    Toast.makeText(this, "手机号码错误", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //验证手机号
    public  static boolean isMobileNO (String telphone) {

        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(telphone)){
            return false;
        }
        else return telphone.matches(telRegex);
    }
}