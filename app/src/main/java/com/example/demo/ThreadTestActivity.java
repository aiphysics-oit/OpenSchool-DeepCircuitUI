package com.example.demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ThreadTestActivity extends Activity {

    private ProgressDialog progressDialog;
    private TextView textView;
    private Button button;
    Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        //ハンドラを生成
        mHandler = new Handler();
        //ProgressDialogを生成します。
        progressDialog = new ProgressDialog(this);
        //buttonがクリックされた時の処理を登録します。
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonProcess();
            }
        });
    }

    //buttonがクリックされた時の処理

    private void buttonProcess() {
        //ProgressDialogを表示します。
        progressDialog.show();
        //スレッドを生成して起動します。
        MyThread thread = new MyThread();
        thread.start();
    }

    class MyThread extends Thread {
        public void run() {
            //時間のかかる処理実行します。今回は仮で10秒停止させています。
            try {
                for (int i=0;i<100; i++) {
                    //10秒停止します。
                    Thread.sleep(100);
                    final int progress = i;

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
            } catch (InterruptedException e) {
            }

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
}