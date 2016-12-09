package com.hao.t_extends_interface.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hao.t_extends_interface.view.R;

import java.util.Timer;
import java.util.TimerTask;


public class NavigationActivity extends AppCompatActivity {


    private ImageView iv_navigation;
    private TextView tv_timetext;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        //初始化视图
        initView();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            int i = 3;

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        iv_navigation.setVisibility(View.INVISIBLE);
                        if (i <= 3 && i > 0) {
                            tv_timetext.setText("跳过" + i + "S");
                        } else if (i == 0) {
                            startActivity(new Intent(NavigationActivity.this, MainActivity1.class));
                            timer.cancel();
                            finish();
                        }
                        i--;
                    }
                });

            }

        }, 3000, 1000);


    }

    private void initView() {
        iv_navigation = (ImageView) findViewById(R.id.iv_navigation);
        tv_timetext = (TextView) findViewById(R.id.tv_timetext);
    }
    public void enter(View v){
        timer.cancel();
        startActivity(new Intent(NavigationActivity.this, MainActivity1.class));
        finish();
    }
}
