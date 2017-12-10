package com.sw0039.twenty.chapters02.actionbars;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.sw0039.twenty.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 进度条
 */
public class ProgressBarTest extends Activity {


    // 该程序模拟填充长度为100的数组
    private int[] data = new int[100];
    int hasData = 0;
    // 记录ProgressBar的完成进度
    int status = 0;
    ProgressBar bar, bar2;
    // 创建一个负责更新的进度的Handler
    Handler mHandler = new Handler() {
        @Override

        public void handleMessage(Message msg) {
            // 表明消息是由该程序发送的
            if (msg.what == 0x111) {
                bar.setProgress(status);
                bar2.setProgress(status);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_progressbar);
        ButterKnife.bind(this);
        bar = (ProgressBar) findViewById(R.id.bar);
        bar2 = (ProgressBar) findViewById(R.id.bar2);
        // 启动线程来执行任务
        new Thread() {
            public void run() {
                while (status < 100) {
                    // 获取耗时操作的完成百分比
                    status = doWork();
                    // 发送消息
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }

    // 模拟一个耗时的操作
    public int doWork() {
        // 为数组元素赋值
        data[hasData++] = (int) (Math.random() * 100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }

//    @OnClick({R.id.start_btn, R.id.stop_btn})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.start_btn:
//                start(startStopProgressbar);
//                break;
//            case R.id.stop_btn:
//                stop(startStopProgressbar);
//                break;
//        }
//    }

//    public void start(ProgressBar progressBar) {
//        // pBar.setIndeterminate(true);
//        progressBar.setIndeterminateDrawable(getResources().getDrawable(
//                R.drawable.progressbar_global));
//        progressBar.setProgressDrawable(getResources().getDrawable(
//                R.drawable.progressbar_global));
//    }
//
//    public void stop(ProgressBar progressBar) {
//        progressBar.setIndeterminateDrawable(getResources().getDrawable(
//                R.drawable.page_loading_bar));
//        progressBar.setProgressDrawable(getResources().getDrawable(
//                R.drawable.page_loading_bar));
//    }
}
