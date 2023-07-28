package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class input_layer3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layer3);
    }
    public void question1y3(){
        int q1_Q1_3 = 1;
    }
    public void question1n(){
        int q1_Q1_3 = 0;
    }
    public void question2y(){
        int q1_Q2_3 = 1;
    }
    public void question2n(){
        int q1_Q2_3 = 0;
    }
    public void question3y(){
        int q1_Q3_3 = 1;
    }
    public void question3n(){
        int q1_Q3_3 = 0;
    }
    public void next1_3 (View v) {                                                  //次の画面へ行く
        Intent intent = new Intent(this,study.class);                  //開く画面
        startActivity(intent);                                                      //イベントハンドラ
    }
}