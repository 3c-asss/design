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
private Button btn_mima2,btn_reg1,Code;
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
        Code=(Button)findViewById((R.id.Code));
        Code.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Code:
               // String toString=phone_number.getText().toString();
                //获取可编辑文本框内容
                EditText PN=(EditText)findViewById(R.id.phone_number);
                String telphone = PN.getText().toString();
                boolean isPhoneNum = isMobileNO(telphone);

                if (TextUtils.isEmpty(telphone)){
                    Toast.makeText(researchActivity2.this, "联系电话不能为空！",Toast.LENGTH_LONG).show();
                    return;
                }else if (!isPhoneNum){
                    PN.setText("");
                    Toast.makeText(researchActivity2.this, "请输入有效的手机号码！",Toast.LENGTH_LONG).show();
                    return;
                }else {
//                    Code.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intent = new Intent(researchActivity2.this, nav_MainActivity2.class);
//                            startActivity(intent);
//                        }
//                    });
//                    break;
            }
        }
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][3456789]\\d{9}";
        // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

}