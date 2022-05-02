package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class myselfActivity extends AppCompatActivity {
TextView xinxi1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself);
        xinxi1=findViewById(R.id.xinxi1);
        xinxi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myselfActivity.this, xinxi.class);
                startActivity(intent);
            }
        });
    }
}