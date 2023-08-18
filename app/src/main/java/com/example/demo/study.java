package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class study extends AppCompatActivity {
    neural_network nn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        Intent intent = getIntent();
        nn = (neural_network) intent.getSerializableExtra("nn");
        nn.learn_init();
        nn.print_data();
    }

    public void studyStart(View view) {
        for(int i=0; i<=100;i++) {
            nn.learn(10);
            TextView text_study= findViewById(R.id.studyText);
            text_study.setText("学習中・・・" + String.valueOf(i) + "%");
        }
        nn.print_array_2D(nn.y);
    }

    public void next4 (View view) {
        Intent intent = new Intent(this, study_result.class);//開く画面
        intent.putExtra("nn", nn);//入力データをセット
        startActivity(intent);}
        //イベントハンドラ
}