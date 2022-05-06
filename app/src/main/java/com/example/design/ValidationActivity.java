package com.example.design;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ValidationActivity extends AppCompatActivity {
    private EditText num_in1_et, num_in2_et, num_in3_et, num_in4_et,et;
    public TextView phoneNumber1;

    private String userinfomsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
        num_in1_et = findViewById(R.id.num_in1_et);
        num_in2_et = findViewById(R.id.num_in2_et);
        num_in3_et = findViewById(R.id.num_in3_et);
        num_in4_et = findViewById(R.id.num_in4_et);
        phoneNumber1 = findViewById(R.id.phoneNumber1);


//        EditText PN=(EditText)findViewById(R.id.phone_number);
//        String telphone = PN.getText().toString();
    //phoneNumber1.setText(telphone);
       // EditText et = (EditText)findViewById(R.id.phone_number);//获取edittext组件

      //  String cn = et.getText().toString();//获取edittext中填写的内容
       // phoneNumber1.setText(cn);//在textview中显示
        //addTextChangedListener设置监听文本变化，有输入跳转到下一个输入框
        num_in1_et.addTextChangedListener(new TextChangeLister(num_in1_et,num_in2_et));

        //setOnKeyListener设置监听键盘删除操作，删除完之后跳转到上一个输入框
        num_in2_et.setOnKeyListener(new MyOnKeyListenr(num_in1_et, num_in2_et));

        num_in2_et.addTextChangedListener(new TextChangeLister(num_in2_et,num_in3_et));

        num_in3_et.setOnKeyListener(new MyOnKeyListenr(num_in2_et, num_in3_et));
        num_in3_et.addTextChangedListener(new TextChangeLister(num_in3_et,num_in4_et));

        num_in4_et.setOnKeyListener(new MyOnKeyListenr(num_in3_et, num_in4_et));
    }

}
//自定义文本变化监听类
class TextChangeLister implements TextWatcher {
    private EditText thisEt,newxtEt;
    public TextChangeLister(EditText thisEt,EditText newxtEt){
        this.thisEt=thisEt;
        this.newxtEt=newxtEt;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //text 输入框中改变后的字符串信息
        //start 输入框中改变后的字符串的起始位置
        //before 输入框中改变前的字符串的位置 默认为0
        //count 输入框中改变后的一共输入字符串的数量
        if(before==0&&count==1){
            thisEt.clearFocus();
            newxtEt.requestFocus();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

//自定义键盘监听
class MyOnKeyListenr implements View.OnKeyListener {
    private EditText upDt, thisDt;

    public MyOnKeyListenr(@Nullable EditText upDt, @Nullable EditText thisDt) {
        this.upDt = upDt;
        this.thisDt = thisDt;

    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Log.i("键盘监控", "view:" + view + "   i:" + i + "   keyEvent:" + keyEvent.toString());
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DEL) {  //如果上一个输入框不为空
            if (upDt != null && thisDt.getText().toString().isEmpty()) {
                thisDt.clearFocus();
                upDt.requestFocus();
            }
            return false;
        }
        return false;
    }


}