package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class study_result extends AppCompatActivity {
    neural_network nn;
    public double scale(double x){
        return (int)(x + 9.5)/2;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_result);
        Intent intent = getIntent();
        nn = (neural_network) intent.getSerializableExtra("nn");
        nn.print_data();
        TextView text_view11= findViewById(R.id.result_R11);
        text_view11.setText("R11 :   " + String.valueOf(scale(nn.weights[0][0])));
        TextView text_view12= findViewById(R.id.result_R12);
        text_view12.setText("R12 :   " + String.valueOf(scale(nn.weights[0][1])));
        TextView text_view13= findViewById(R.id.result_R13);
        text_view13.setText("R13 :   " + String.valueOf(scale(nn.weights[0][2])));
        TextView text_view21= findViewById(R.id.result_R21);
        text_view21.setText("R21 :   " + String.valueOf(scale(nn.weights[1][0])));
        TextView text_view22= findViewById(R.id.result_R22);
        text_view22.setText("R22 :   " + String.valueOf(scale(nn.weights[1][1])));
        TextView text_view23= findViewById(R.id.result_R23);
        text_view23.setText("R23 :   " + String.valueOf(scale(nn.weights[1][2])));
        TextView text_view31= findViewById(R.id.result_R31);
        text_view31.setText("R31 :   " + String.valueOf(scale(nn.weights[2][0])));
        TextView text_view32= findViewById(R.id.result_R32);
        text_view32.setText("R32 :   " + String.valueOf(scale(nn.weights[2][1])));
        TextView text_view33= findViewById(R.id.result_R33);
        text_view33.setText("R33 :   " + String.valueOf(scale(nn.weights[2][2])));
        TextView text_bias1= findViewById(R.id.bias1);
        text_bias1.setText("バイアス1 :   " + String.valueOf(scale(nn.bias[0][0])));
        TextView text_bias2= findViewById(R.id.bias2);
        text_bias2.setText("バイアス2 :   " + String.valueOf(scale(nn.bias[0][1])));
        TextView text_bias3= findViewById(R.id.bias3);
        text_bias3.setText("バイアス3 :   " + String.valueOf(scale(nn.bias[0][2])));
    }

    public void finish (View view) {
        Intent intent = new Intent(this,MainActivity.class);//開く画面
        startActivity(intent);
        finish();
    }
}