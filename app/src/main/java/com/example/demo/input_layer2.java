package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class input_layer2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layer2);
    }
    public void question1y2(){
        int q1_Q1_2 = 1;
    }
    public void question1n(){
        int q1_Q1_2 = 0;
    }
    public void question2y(){
        int q1_Q2_2 = 1;
    }
    public void question2n(){
        int q1_Q2_2 = 0;
    }
    public void question3y(){
        int q1_Q3_2 = 1;
    }
    public void question3n(){
        int q1_Q3_2 = 0;
    }
    public void next1_2 (View v) {
        Intent intent = new Intent(this,input_layer3.class);//開く画面
        startActivity(intent);//イベントハンドラ
    }
}