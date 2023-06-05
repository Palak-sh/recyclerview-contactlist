package com.example.myapplicationcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyApplicationcontact2 extends AppCompatActivity {
    ImageView img1;
    TextView tv1,tv2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_applicationcontact2);
        img1 = (ImageView)findViewById(R.id.imageView2);
        tv1 = (TextView)findViewById(R.id.textView);
        tv2= (TextView)findViewById(R.id.textView2);
        img1.setImageResource(getIntent().getIntExtra("img",0));
        tv1.setText(getIntent().getStringExtra("name"));
        tv2.setText(getIntent().getStringExtra("num"));


    }
}