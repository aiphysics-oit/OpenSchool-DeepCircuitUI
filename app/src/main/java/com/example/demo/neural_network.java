package com.example.demo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class neural_network implements Serializable {
    int[][] q_all = new int[3][3];
    double[][] weights;
    double[][] bias;
    int question_number;

    //データセット
    double[][] X = {{0, 0, 0},
            {0, 0, 1},
            {0, 1, 0},
            {0, 1, 1},
            {1, 0, 0},
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 1}};
    //教師データ
    double[][] y = {{0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};

    public neural_network() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                q_all[i][j] = -1;
        }
    }

    //値を出力する
    public void print_data() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(q_all[i]));
        }
    }
    //2次元配列のプリント
    public void print_array_2D(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
    //シグモイド関数
    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    //シグモイド関数の導関数
    public double sigmoid_derivative(double x) {
        return x * (1 - x);
    }

    //シグモイド関数の配列
    public double[][] sigmoid_derivative_array(double[][] a) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = sigmoid_derivative(a[i][j]);
            }
        }
        return c;
    }

    //内積
    public double[][] dot(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            System.out.println("error: Aの列数とｂ行数が一致しません");
        }
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < b[0].length; k++) {
                c[i][k] = 0.0;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b[0].length; k++) {
                    c[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        return c;
    }

    //積
    public double[][] prod(double[][] a, double[][] b) {
        if (a.length != b.length) {
            System.out.println("error: Aの行数とｂ行数が一致しません");
        }
        if (a[0].length != b[0].length) {
            System.out.println("error: Aの列数とｂ列数が一致しません");
        }
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] * b[i][j];
            }
        }
        return c;
    }

    //商
    public double[][] div(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b[0].length; k++) {
                    c[i][k] = a[i][j] / b[j][k];
                }
            }
        }
        return c;
    }

    //和
    public double[][] add(double[][] a, double[][] b) {
        if (a.length != b.length) {
            System.out.println("error: Aの行数とｂ行数が一致しません");
        }
        if (a[0].length != b[0].length) {
            System.out.println("error: Aの列数とｂ列数が一致しません");
        }
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    //差
    public double[][] sub(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    //行列の転置
    public double[][] transpose(double[][] a) {
        double[][] c = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[j][i] = a[i][j];
            }
        }
        return c;
    }

    //行列と定数の積
    public double[][] multiply(double[][] a, double b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] * b;
            }
        }
        return c;
    }

    //行列と定数の商
    public double[][] multiply2(double[][] a, double b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] / b;
            }
        }
        return c;
    }

    //+=
    public void add_equal(double[][] a, double[][] b) {
        if (a.length != b.length) {
            System.out.println("error: Aの行数とｂ行数が一致しません");
            print_array_2D(a);
            print_array_2D(b);
        }
        if (a[0].length != b[0].length) {
            System.out.println("error: Aの列数とｂ列数が一致しません");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] += b[i][j];
            }
        }
    }

    public double[][] sum(double[][] a) {
        //double[][] b = new double[a.length][1];
        double[][] b = new double[1][a[0].length];
        for (int j = 0; j < a[0].length; j++) {
            b[0][j] = 0.0;
            for (int i = 0; i < a.length; i++) {
                b[0][j] += a[i][j];
            }
        }
        return b;
    }
    //学習
    public void learn_init() {
        //教師データ作成
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    int index = 4 * i + 2 * j + k;
                    y[index][0]=1;
                    y[index][1]=1;
                    y[index][2]=1;
                    if (q_all[0][0] == i && q_all[0][1] == j && q_all[0][2] == k) {
                        y[index][0] = 0;
                    }
                    if (q_all[1][0] == i && q_all[1][1] == j && q_all[1][2] == k) {
                        y[index][1] = 0;
                    }
                    if (q_all[2][0] == i && q_all[2][1] == j && q_all[2][2] == k) {
                        y[index][2] = 0;
                    }
                }
            }
        }
        //重みとバイアスの初期化
        System.out.println("重みとバイアスの初期化");
        Random random = new Random(42);
        int input_layer_size = 3;
        int output_layer_size = 3;
        weights = new double[input_layer_size][output_layer_size];
        bias = new double[1][output_layer_size];
        System.out.println("重みとバイアスの初期化2");
        for (int i = 0; i < input_layer_size; i++) {
            for (int j = 0; j < input_layer_size; j++) {
                weights[i][j] = random.nextGaussian();
                bias[0][j] = random.nextGaussian();
            }
        }
        System.out.println("重みとバイアスの初期化3");

        print_array_2D(weights);
        print_array_2D(bias);
    }

    public void learn(int epochs) {
        //ハイパーパラメータ
        double learning_rate = 0.1;
        //学習
        System.out.println("学習");
        for (int epoch = 0; epoch < epochs; epoch++) {
            //フォワードプロパゲーション
            double[][] input_layer = new double[X.length][X[0].length];
            for (int i = 0; i < X.length; i++) {
                for (int j = 0; j < X[0].length; j++) {
                    input_layer[i][j] = X[i][j];
                }
            }
            System.out.println("学習インプットレイヤー" + String.valueOf(epoch));
            print_array_2D(input_layer);

            double[][] weighted_sum = dot(input_layer, weights);
            for (int i = 0; i < weighted_sum.length; i++) {
                for (int j = 0; j < weighted_sum[0].length; j++) {
                    weighted_sum[i][j] += bias[0][j];
                }
            }
            System.out.println("学習weighted_sum" + String.valueOf(epoch));

            print_array_2D(weighted_sum);
            double[][] output_layer = new double[weighted_sum.length][weighted_sum[0].length];

            for (int i = 0; i < weighted_sum.length; i++) {
                for (int j = 0; j < weighted_sum[0].length; j++) {
                    output_layer[i][j] = sigmoid(weighted_sum[i][j]);
                }
            }
            System.out.println("学習outプットレイヤー" + String.valueOf(epoch));
            print_array_2D(output_layer);
            //誤差計算
            double[][] error = sub(y, output_layer);
            System.out.println("学習error" + String.valueOf(epoch));
            print_array_2D(error);
            //バックプロパゲーション
            double[][] output_delta = prod(error, sigmoid_derivative_array(output_layer));
            System.out.println("学習outプットdelta" + String.valueOf(epoch));
            print_array_2D(output_delta);
            add_equal(weights, multiply(dot(transpose(input_layer), output_delta), learning_rate));
            System.out.println("学習weight" + String.valueOf(epoch));
            print_array_2D(weights);
            add_equal(bias, multiply(sum(output_delta), learning_rate));
            System.out.println("学習bias" + String.valueOf(epoch));
            print_array_2D(bias);
        }
//                if (epochs == 999) {
//                    System.out.println("bias:");
//                    System.out.println(multiply2(multiply(bias, 1000), 1000));
//                    System.out.println("weights:");
//                    System.out.println(multiply2(multiply(weights, 1000), 1000));
//                    System.out.println("Rb:");
//                    System.out.println(multiply2(multiply(multiply2(multiply(bias, 1000), 1000), 5), 2));
//                    System.out.println("Rw:");
//                    System.out.println(multiply2(multiply(multiply2(multiply(weights, 1000), 1000), 5), 2));
//                }

        //テスト
        //double[][] test_input = X;
        //double[][] test_output = sigmoid_derivative_array(add(dot(test_input,weights2),bias2));

        //出力
        //System.out.println("入力データ");
        //System.out.println(X);
        //System.out.println("予想");
        //System.out.println("");
        //System.out.println("正解");
        //System.out.println("");
        //System.out.println("正答率");
    }
    //写真入れ替え
    public int[] getImageResources(){
        int[] images = new int[3];
        if (question_number == 1) {
            images[0] = (R.drawable.apple);
            images[1] = (R.drawable.banana);
            images[2] = (R.drawable.pain);
        }
        else if (question_number == 2) {
            images[0] = (R.drawable.q1a1);
            images[1] = (R.drawable.q1a2);
            images[2] = (R.drawable.q1a3);
        }
        else if (question_number == 3) {
            images[0] = (R.drawable.q2a1);
            images[1] = (R.drawable.q2a2);
            images[2] = (R.drawable.q2a4);
        }
        else if (question_number == 4) {
            images[0] = (R.drawable.q4a1);
            images[1] = (R.drawable.q4a2);
            images[2] = (R.drawable.q4a3);
        }
        return images;
    }
    //問題入れ替え
    public int[] getQuestionResources(){
        int[] questions = new int[3];
        if (question_number == 1) {
            questions[0] = (R.string.Q1_1);
            questions[1] = (R.string.Q1_2);
            questions[2] = (R.string.Q1_3);
        }
        else if (question_number == 2) {
            questions[0] = (R.string.Q2_1);
            questions[1] = (R.string.Q2_2);
            questions[2] = (R.string.Q2_3);
        }
        else if (question_number == 3) {
            questions[0] = (R.string.Q3_1);
            questions[1] = (R.string.Q3_2);
            questions[2] = (R.string.Q3_3);
        }
        else if (question_number == 4) {
            questions[0] = (R.string.Q4_1);
            questions[1] = (R.string.Q4_2);
            questions[2] = (R.string.Q4_3);
        }
        return questions;
    }

}
