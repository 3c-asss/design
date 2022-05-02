package com.example.design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class nav_MainActivity2 extends AppCompatActivity {
     ImageView mys ,chazhao;
    //需要适配的数据
    private String[] titles = { "杨老师 19软件1班", "赵老师 19软件1班","杨老师 19软件1班",
            "杨老师 19软件1班", "杨老师 19软件1班","杨老师 19软件1班", "杨老师 19软件1班", "杨老师 19软件1班","杨老师 19软件1班",
            };
    private String[] titles2 = { "网络原理", "java程序设计","移动终端", "网络原理", "java程序设计","移动终端","网络原理", "java程序设计","移动终端",};
    private String[] prices = { "34人", "34人", "34人", "34人", "34人", "34人", "34人", "34人", "34人"
         };
    //图片集合
    private int[] icons = {R.drawable.banjitupian1,R.drawable.banjitupian1220,R.drawable.banjitupian122,R.drawable.banjitupian21,R.drawable.banjitupian1,R.drawable.banjitupian122,R.drawable.banjitupian21,R.drawable.banjitupian1220,R.drawable.banjitupian122};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__main2);

        ListView mListView = findViewById(R.id.lv);
        ImageView mys= findViewById(R.id.mys);
        ImageView chazhao= findViewById(R.id.chazhao);
        MyBaseAdapter adapter = new MyBaseAdapter();
        mListView.setAdapter(adapter);
        chazhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nav_MainActivity2.this, chengyuanActivity.class);
                startActivity(intent);
            }
        });
        mys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nav_MainActivity2.this, lunboActivity2.class);
                startActivity(intent);
            }
        });
    }


    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if(convertView == null){
                convertView = View.inflate(nav_MainActivity2.this, R.layout.notepad_item_layout, null);
                holder = new ViewHolder();
                holder.title = convertView.findViewById(R.id.title);
                holder.tv_kecheng = convertView.findViewById(R.id.tv_kecheng);
                holder.price = convertView.findViewById(R.id.price);
                holder.iv = convertView.findViewById(R.id.iv);

                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.title.setText(titles[position]);
            holder.tv_kecheng.setText(titles2[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);

            return convertView;
        }

        class ViewHolder{
            TextView title;
            TextView tv_kecheng;
            TextView price;
            ImageView iv;
        }
    }
}