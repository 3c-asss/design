package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class splash_scteen extends AppCompatActivity implements View.OnClickListener {
    private int recLen=5;
    private TextView mTvSkip;
    Timer timer=new Timer();
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scteen);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;

        getWindow().setFlags(flag,flag);
        setContentView(R.layout.activity_splash_scteen);
        initView();
        timer.schedule(task,1000,1000);


        handler=new Handler();
        handler.postDelayed(runnable= new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_scteen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }

    private void initView() {
        mTvSkip=findViewById(R.id.tv_skip);
        mTvSkip.setOnClickListener(this);
    }
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    mTvSkip.setText("跳过"+recLen);
                    if(recLen<0){
                        timer.cancel();
                        mTvSkip.setVisibility(View.GONE);
                    }
                }
            });
        }
    };

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_skip:
                Intent intent=new Intent(splash_scteen.this,MainActivity.class);
                startActivity(intent);
                finish();
                if(runnable!=null){
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }
}