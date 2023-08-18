package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class input_layer extends AppCompatActivity {
    neural_network nn;
    int [] answer1 = new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layer);
        Intent intent = getIntent();
        nn = (neural_network) intent.getSerializableExtra("nn");

        ImageView myImage1= findViewById(R.id.image1);
        myImage1.setImageResource(nn.getImageResources()[0]);

        TextView myQuestion1= findViewById(R.id.question1Text_1);
        myQuestion1.setText(nn.getQuestionResources()[0]);
        TextView myQuestion2= findViewById(R.id.question1Text_2);
        myQuestion2.setText(nn.getQuestionResources()[1]);
        TextView myQuestion3= findViewById(R.id.question1Text_3);
        myQuestion3.setText(nn.getQuestionResources()[2]);
    }
    public void question1y(View view){
        nn.q_all[0][0] = 1;
        answer1[0]=1;
        Button by = findViewById(R.id.Q1Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q1No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }

    public void question1n(View view){
        nn.q_all[0][0] = 0;
        answer1[0]=1;
        Button by = findViewById(R.id.Q1Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q1No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }

    public void question2y(View view){
        nn.q_all[0][1] = 1;
        answer1[1]=1;
        Button by = findViewById(R.id.Q2Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q2No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question2n(View view){
        nn.q_all[0][1] = 0;
        answer1[1]=1;
        Button by = findViewById(R.id.Q2Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q2No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void question3y(View view){
        nn.q_all[0][2] = 1;
        answer1[2]=1;
        Button by = findViewById(R.id.Q3Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q3No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question3n(View view){
        nn.q_all[0][2] = 0;
        answer1[2]=1;
        Button by = findViewById(R.id.Q3Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q3No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void next1_1 (View view) {
        if(answer1[0]==1&&answer1[1]==1&&answer1[2]==1) {
            Intent next = new Intent(this, input_layer2.class);//開く画面
            next.putExtra("nn", nn);//入力データをセット
            startActivity(next);//イベントハンドラ
        }
    }
}