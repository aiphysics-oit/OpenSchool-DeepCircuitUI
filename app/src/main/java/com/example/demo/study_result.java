package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class study_result extends AppCompatActivity {
    neural_network nn;
    /*public double scale(double x){
        //return (double)(x + 9.5)/2;
        return (double) (x / -1.235)+5.0;
    }

    public double scale1(double x){
        //return (double)(x + 9.5)/2;
        return (double) (x / -4.03)+5.0;
    }*/
    public double scale(double x){
        double[][] bias1 = nn.multiply(nn.bias, 0.3);
        nn.print_array_2D(bias1);//OK
        double[][] allMax = new double [4][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                allMax[i][j] = nn.weights[i][j];
            }
        }
        for (int j = 0; j < 3; j++) {
            allMax[3][j] = bias1[0][j];
        }
        nn.print_array_2D(allMax);
        //double[][] allMax1 = nn.multiply(allMax, -1.0);
        //nn.print_array_2D(allMax);
        double max_wb = nn.abs_max(allMax);
        System.out.println(max_wb);
        double scaled_value = (-x * 4.9 / max_wb) + 5.0;
        System.out.println(scaled_value);

        return scaled_value;
    }

    public double scale1(double x){
        double[][] bias1 = nn.multiply(nn.bias, 0.3);
        nn.print_array_2D(bias1);//OK
        double[][] allMax = new double [4][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                allMax[i][j] = nn.weights[i][j];
            }
        }
        for (int j = 0; j < 3; j++) {
            allMax[3][j] = bias1[0][j];
        }
        nn.print_array_2D(allMax);
        //double[][] allMax1 = nn.multiply(allMax, -1.0);
        nn.print_array_2D(allMax);
        double max_wb = nn.abs_max(allMax);
        System.out.println(max_wb);
        double scaled_value = (-x * 0.3 * 4.9 / max_wb) + 5.0;
        System.out.println(scaled_value);

        return scaled_value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_result);
        Intent intent = getIntent();
        nn = (neural_network) intent.getSerializableExtra("nn");
        nn.print_data();
        TextView text_view11 = findViewById(R.id.result_R11);
        text_view11.setSingleLine(false);
        text_view11.setText("R11 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[0][0]))));

        TextView text_view12 = findViewById(R.id.result_R12);
        text_view12.setSingleLine(false);
        text_view12.setText("R21 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[0][1]))));

        TextView text_view13 = findViewById(R.id.result_R13);
        text_view13.setSingleLine(false);
        text_view13.setText("R31 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[0][2]))));

        TextView text_view21 = findViewById(R.id.result_R21);
        text_view21.setSingleLine(false);
        text_view21.setText("R12 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[1][0]))));

        TextView text_view22 = findViewById(R.id.result_R22);
        text_view22.setSingleLine(false);
        text_view22.setText("R22 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[1][1]))));

        TextView text_view23 = findViewById(R.id.result_R23);
        text_view23.setSingleLine(false);
        text_view23.setText("R32 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[1][2]))));

        TextView text_view31 = findViewById(R.id.result_R31);
        text_view31.setSingleLine(false);
        text_view31.setText("R13 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[2][0]))));

        TextView text_view32 = findViewById(R.id.result_R32);
        text_view32.setSingleLine(false);
        text_view32.setText("R23 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[2][1]))));

        TextView text_view33 = findViewById(R.id.result_R33);
        text_view33.setSingleLine(false);
        text_view33.setText("R33 : \n\n\t" + String.valueOf(String.format("%.2f", scale(nn.weights[2][2]))));

        TextView text_bias1 = findViewById(R.id.bias1);
        text_bias1.setSingleLine(false);
        text_bias1.setText("Rb1 : \n\n\t" + String.valueOf(String.format("%.2f", scale1(nn.bias[0][0]))));

        TextView text_bias2 = findViewById(R.id.bias2);
        text_bias2.setSingleLine(false);
        text_bias2.setText("Rb2 : \n\n\t" + String.valueOf(String.format("%.2f", scale1(nn.bias[0][1]))));

        TextView text_bias3 = findViewById(R.id.bias3);
        text_bias3.setSingleLine(false);
        text_bias3.setText("Rb3 : \n\n\t" + String.valueOf(String.format("%.2f", scale1(nn.bias[0][2]))));
    }

    public void finish (View view) {
        Intent intent = new Intent(this,MainActivity.class);//開く画面
        startActivity(intent);
        finish();
    }
}