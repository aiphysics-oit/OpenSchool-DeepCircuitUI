package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void questionSelect1 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        startActivity(intent);//イベントハンドラ
    }

    public void questionSelect2 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        startActivity(intent);//イベントハンドラ
    }

    public void questionSelect3 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        startActivity(intent);//イベントハンドラ
    }

    public void questionSelect4 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        startActivity(intent);//イベントハンドラ
    }
}