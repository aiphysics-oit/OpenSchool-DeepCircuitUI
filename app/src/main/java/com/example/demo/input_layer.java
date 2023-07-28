package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.Map;

public class input_layer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layer);
    }

    public void question1y(){
        int q1_Q1_1 = 1;
//        System.out.println(q1_Q1_1);
    }
    public void question1n(){
        int q1_Q1_1 = 0;
        System.out.println(q1_Q1_1);
    }
    public int question2y(){ //ここのintは戻り値のデータ型
        int q1_Q2_1 = 1;
        System.out.println(q1_Q2_1);
        return q1_Q2_1;
    }
    public void question2n(){
        int q1_Q2_1 = 0;
        System.out.println(q1_Q2_1);
    }
    public void question3y(){
        int q1_Q3_1 = 1;
        System.out.println(q1_Q3_1);
    }
    public void question3n(){
        int q1_Q3_1 = 0;
        System.out.println(q1_Q3_1);
    }

    public void next1_1 (View v) {
        int[] a = {question2y()};
        Intent intent = new Intent(this,input_layer2.class);//開く画面
        startActivity(intent);//イベントハンドラ

    }
}