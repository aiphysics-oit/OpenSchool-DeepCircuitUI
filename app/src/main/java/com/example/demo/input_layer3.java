package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
public class input_layer3 extends AppCompatActivity {
    neural_network nn;
    int[] answer3 = new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layer3);

        Intent intent = getIntent();
        nn = (neural_network) intent.getSerializableExtra("nn");
        nn.print_data();

        ImageView myImage3= findViewById(R.id.image3);
        myImage3.setImageResource(nn.getImageResources()[2]);

        TextView myQuestion1= findViewById(R.id.question1Text_1);
        myQuestion1.setText(nn.getQuestionResources()[0]);
        TextView myQuestion2= findViewById(R.id.question1Text_2);
        myQuestion2.setText(nn.getQuestionResources()[1]);
        TextView myQuestion3= findViewById(R.id.question1Text_3);
        myQuestion3.setText(nn.getQuestionResources()[2]);
    }
    public void question1y(View view){
        nn.q_all[2][0] = 1;
        answer3[0]=1;
        Button by = findViewById(R.id.Q1Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q1No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question1n(View view){
        nn.q_all[2][0] = 0;
        answer3[0]=1;
        Button by = findViewById(R.id.Q1Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q1No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void question2y(View view){
        nn.q_all[2][1] = 1;
        answer3[1]=1;
        Button by = findViewById(R.id.Q2Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q2No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question2n(View view){
        nn.q_all[2][1] = 0;
        answer3[1]=1;
        Button by = findViewById(R.id.Q2Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q2No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void question3y(View view){
        nn.q_all[2][2] = 1;
        answer3[2]=1;
        Button by = findViewById(R.id.Q3Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q3No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question3n(View view){
        nn.q_all[2][2] = 0;
        answer3[2]=1;
        Button by = findViewById(R.id.Q3Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q3No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void next1_3 (View v) {
        if(answer3[0]==1&&answer3[1]==1&&answer3[2]==1){
            Intent next = new Intent(this, study.class);//開く画面
            next.putExtra("nn", nn);//入力データをセット
            startActivity(next);//イベントハンドラ
        }
    }
}