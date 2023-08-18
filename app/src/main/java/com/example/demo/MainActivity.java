package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int[][] image = new int[3][4];
    neural_network nn = new neural_network();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void questionSelect1 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        nn.question_number = 1;
        intent.putExtra("nn", nn);//入力データをセット
        startActivity(intent);//イベントハンドラ

    }

    public void questionSelect2 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        nn.question_number = 2;
        intent.putExtra("nn", nn);//入力データをセット
        startActivity(intent);//イベントハンドラ
    }

    public void questionSelect3 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        nn.question_number = 3;
        intent.putExtra("nn", nn);//入力データをセット
        startActivity(intent);//イベントハンドラ
    }

    public void questionSelect4 (View v) {
        Intent intent = new Intent(this,input_layer.class);//開く画面
        nn.question_number = 4;
        intent.putExtra("nn", nn);//入力データをセット
        startActivity(intent);//イベントハンドラ
    }

    public void test (View v) {
        Intent intent = new Intent(this, ThreadTestActivity.class);
        startActivity(intent);//イベントハンドラ
    }
}