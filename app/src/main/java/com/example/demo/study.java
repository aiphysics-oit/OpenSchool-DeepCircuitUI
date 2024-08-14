package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class study extends AppCompatActivity {
    neural_network nn;
    private ProgressDialog progressDialog;
    private TextView textView;
    private Button button;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        Intent intent = getIntent();
        nn = (neural_network) intent.getSerializableExtra("nn");
        nn.learn_init();
        nn.print_data();

        //ハンドラを生成
        mHandler = new Handler();

        //main.xmlに設定したコンポーネントをid指定で取得します。
        button = (Button) findViewById(R.id.studyStart);
        textView = (TextView) findViewById(R.id.studyText);

        //ProgressDialogを生成します。
        progressDialog = new ProgressDialog(this);

        //buttonがクリックされた時の処理を登録します。
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonProcess();
            }
        });
    }

    /**
     * buttonがクリックされた時の処理
     */
    public void buttonProcess() {
        //ProgressDialogを表示します。
        progressDialog.show();

        //スレッドを生成して起動します。
        study.MyThread thread = new study.MyThread();
        thread.start();
    }

    class MyThread extends Thread {
        public void run() {
            //時間のかかる処理実行します。今回は仮で10秒停止させています。
            //try {
                for (int j = 0; j < 100; j++) {
                    //10秒停止します。
                    //Thread.sleep(100);

                    final int progress = j;

                    nn.learn(1000);

                    //メインスレッドのメッセージキューにメッセージを登録します。
                    mHandler.post(new Runnable() {
                        //run()の中の処理はメインスレッドで動作されます。
                        public void run() {
                            //画面のtextViewへ"処理が完了しました。"を表示させる。
                            //textView.setText(String.valueOf(progress) + "%");
                            progressDialog.setMessage("実行中です " + String.valueOf(progress) + "%");

                        }
                    });
                }
           // } catch (InterruptedException e) {
            //}

            //メインスレッドのメッセージキューにメッセージを登録します。
            mHandler.post(new Runnable() {
                //run()の中の処理はメインスレッドで動作されます。
                public void run() {
                    //画面のtextViewへ"処理が完了しました。"を表示させる。
                    textView.setText("処理が完了しました。");

                    //ProgressDialogを消去します。
                    progressDialog.dismiss();
                }
            });
        }
    }


//    public void studyStart(View view) {
//        for(int i=0; i<=100;i++) {
//            nn.learn(100);
////            TextView text_study= findViewById(R.id.studyText);
////            text_study.setText("学習中・・・" + String.valueOf(i) + "%");
//        }
//        nn.print_array_2D(nn.y);
//    }

    public void next4(View view) {
        Intent intent = new Intent(this, study_result.class);//開く画面
        intent.putExtra("nn", nn);//入力データをセット
        startActivity(intent);
    }
    //イベントハンドラ
}