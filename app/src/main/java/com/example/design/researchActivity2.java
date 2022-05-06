package com.example.design;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class researchActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button btn_mima2,btn_reg1,Code;
    public EditText PN;
    private int countSeconds = 60;//倒计时秒数
    private EditText mobile_login, yanzhengma;
    private Button getyanzhengma1, login_btn;
    private Context mContext;
    private String usersuccess;
    private String userinfomsg;
    private Handler mCountHandler = new Handler() {
        @Override
        public void publish(LogRecord logRecord) {
        }
        @Override
        public void flush() {
        }
        @Override
        public void close() throws SecurityException {
        }

        public void handleMessage(Message msg) {

            //super.handleMessage(msg);
            if (countSeconds > 0) {
                --countSeconds;
                getyanzhengma1.setText("(" + countSeconds + ")后获取验证码");
               // mCountHandler.sendEmptyMessageDelayed(0, 1000);
            } else {
                countSeconds = 60;
                getyanzhengma1.setText("请重新获取验证码");
            }
        }
    };

    private Object researchActivity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reseach2);
        //验证手机号是否正确
        //测试
        mContext = this;
        setContentView(R.layout.activity_reseach2);
        initView();
        initEvent();
        initData();

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


    private void initEvent() {
        getyanzhengma1.setOnClickListener(this);
        login_btn.setOnClickListener(this);
    }
    private void initData() {
    }
    //获取信息进行登录
    private void initView() {
        btn_mima2=(Button)findViewById(R.id.btn_mima2);
        btn_reg1=(Button)findViewById(R.id.btn_reg1);
        Code=(Button)findViewById((R.id.login_btn));
      //  super.phoneNumber1 = findViewById(R.id.phoneNumber1);
        mobile_login = (EditText) findViewById(R.id.mobile_login);
        getyanzhengma1 = (Button) findViewById(R.id.getyanzhengma1);
        yanzhengma = (EditText) findViewById(R.id.yanzhengma);
        login_btn = (Button) findViewById(R.id.login_btn);
        Code.setOnClickListener(this);
    }
//    private void requestVerifyCode(String mobile) {
//     //   RequestParams requestParams = new RequestParams(“这里是你请求的验证码接口，让后台给你，参数什么的加在后面”);
//        x.http().post(requestParams, new Callback.ProgressCallback<String>() {
//            public void onWaiting() {
//            }
//            public void onStarted() {
//            }
//            public void onLoading(long total, long current, boolean isDownloading) {
//            }
//            public void onSuccess(String result) {
//                try {
//                    JSONObject jsonObject2 = new JSONObject(result);
//                    Log.e("tag", "jsonObject2" + jsonObject2);
//                    String state = jsonObject2.getString("success");
//                    String verifyCode = jsonObject2.getString("msg");
//                    Log.e("tag", "获取验证码==" + verifyCode);
//                    if ("true".equals(state)) {
//                        Toast.makeText(researchActivity2.this, verifyCode, Toast.LENGTH_SHORT).show();
//                        startCountBack();//这里是用来进行请求参数的
//                    } else {
//                        Toast.makeText(researchActivity2.this, verifyCode, Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            public void onError(Throwable ex, boolean isOnCallback) {
//                ex.printStackTrace();
//            }
//            public void onCancelled(CancelledException cex) {
//            }
//            public void onFinished() {
//            }
//        });
//    }
    //使用正则表达式判断电话号码

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                //获取可编辑文本框内容
                EditText PN=(EditText)findViewById(R.id.mobile_login);
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
                  //  login();
                    Code.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(researchActivity2.this, ValidationActivity.class);
//                            phoneNumber1 = findViewById(R.id.phoneNumber1);
////        EditText PN=(EditText)findViewById(R.id.phone_number);
////        String telphone = PN.getText().toString();
//                            //    phoneNumber1.setText(telphone);
//                            EditText et = (EditText)findViewById(R.id.phone_number);//获取edittext组件
//
//                            String cn = et.getText().toString();//获取edittext中填写的内容
//                            phoneNumber1.setText(cn);//在textview中显示
                            startActivity(intent);
                        }
                    });
                    break;

            }
            case R.id.getyanzhengma1:
                if (countSeconds == 60) {
                    String mobile = mobile_login.getText().toString();
                    Log.e("tag", "mobile==" + mobile);
                    getMobiile(mobile);
                } else {
                    Toast.makeText(researchActivity2.this, "不能重复发送验证码", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
    }

//    private void login() {
//        String mobile = mobile_login.getText().toString().trim();
//        String verifyCode = yanzhengma.getText().toString().trim();
//        RequestParams params = new RequestParams(“这里换成你的请求登录的接口”);
//        x.http().post(params, new Callback.ProgressCallback<String>() {
//
//            public void onWaiting() {
//            }
//
//            public void onStarted() {
//            }
//
//            public void onLoading(long total, long current, boolean isDownloading) {
//            }
//
//            public void onSuccess(String result) {
//                try {
//                    JSONObject jsonObject = new JSONObject(result);
//                    Log.e("tag", "登陆的result=" + jsonObject);
//                    String success = jsonObject.optString("success");
//                    String data = jsonObject.optString("data");
//                    String msg=jsonObject.optString("msg");
//                    if ("true".equals(success)) {
//                        Log.e("tag","登陆的data="+data);
//                        JSONObject json = new JSONObject(data);
//                        token = json.optString("token");
//                        userId = json.optString("userId");
//                        //我这里按照我的要求写的，你们也可以适当改动
//                        //获取用户信息的状态
//                        getUserInfo();
//                    }else{
//                        Toast.makeText(researchActivity2.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            public void onError(Throwable ex, boolean isOnCallback) {
//            }
//
//            public void onCancelled(CancelledException cex) {
//            }
//
//            public void onFinished() {
//            }
//        });
//
//    }

    private void getMobiile(String mobile) {
        if ("".equals(mobile)) {
            Log.e("tag", "mobile=" + mobile);
            new AlertDialog.Builder(mContext).setTitle("提示").setMessage("手机号码不能为空").setCancelable(true).show();
        } else if (isMobileNO(mobile) == false) {
            new AlertDialog.Builder(mContext).setTitle("提示").setMessage("请输入正确的手机号码").setCancelable(true).show();
        } else {
            Log.e("tag", "输入了正确的手机号");
          //  requestVerifyCode(mobile);
        }
    }

    //来检查网络的连通性
    public boolean isNetworkReachable() {
        ConnectivityManager mManager =
                (ConnectivityManager)getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = mManager.getActiveNetworkInfo();
        if(current == null) {
            return false;
        }
        return (current.getState() == NetworkInfo.State.CONNECTED);
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






        //获取验证码信息，进行验证码请求

        //获取验证码信息,进行计时操作
        private void startCountBack() {
            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getyanzhengma1.setText(countSeconds + "");
                    //mCountHandler.sendEmptyMessage(0);
                }
            });
        }
    }
