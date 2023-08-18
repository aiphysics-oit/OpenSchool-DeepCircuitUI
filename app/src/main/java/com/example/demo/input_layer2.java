package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class input_layer2 extends AppCompatActivity {
    neural_network nn;
    int[] answer2 = new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layer2);

        Intent intent = getIntent();
        nn = (neural_network) intent.getSerializableExtra("nn");
        nn.print_data();

        ImageView myImage2= findViewById(R.id.image2);
        myImage2.setImageResource(nn.getImageResources()[1]);

        TextView myQuestion1= findViewById(R.id.question1Text_1);
        myQuestion1.setText(nn.getQuestionResources()[0]);
        TextView myQuestion2= findViewById(R.id.question1Text_2);
        myQuestion2.setText(nn.getQuestionResources()[1]);
        TextView myQuestion3= findViewById(R.id.question1Text_3);
        myQuestion3.setText(nn.getQuestionResources()[2]);
    }
    public void question1y(View view){
        nn.q_all[1][0] = 1;
        answer2[0]=1;
        Button by = findViewById(R.id.Q1Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q1No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question1n(View view){
        nn.q_all[1][0] = 0;
        answer2[0]=1;
        Button by = findViewById(R.id.Q1Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q1No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void question2y(View view){
        nn.q_all[1][1] = 1;
        answer2[1]=1;
        Button by = findViewById(R.id.Q2Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q2No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question2n(View view){
        nn.q_all[1][1] = 0;
        answer2[1]=1;
        Button by = findViewById(R.id.Q2Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q2No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void question3y(View view){
        nn.q_all[1][2] = 1;
        answer2[2]=1;
        Button by = findViewById(R.id.Q3Yes);
        by.setBackgroundColor(Color.rgb(0, 0x54,0x38));
        Button bn = findViewById(R.id.Q3No);
        bn.setBackgroundColor(Color.rgb(0, 0x99,0x77));
    }
    public void question3n(View view){
        nn.q_all[1][2] = 0;
        answer2[2]=1;
        Button by = findViewById(R.id.Q3Yes);
        by.setBackgroundColor(Color.rgb(0, 0x99,0x77));
        Button bn = findViewById(R.id.Q3No);
        bn.setBackgroundColor(Color.rgb(0, 0x54,0x38));
    }
    public void next1_2 (View v) {
        if (answer2[0]==1&&answer2[1]==1&&answer2[2]==1){
            Intent next = new Intent(this, input_layer3.class);//開く画面
            next.putExtra("nn", nn);//入力データをセット
            startActivity(next);//イベントハンドラ
        }
    }
}