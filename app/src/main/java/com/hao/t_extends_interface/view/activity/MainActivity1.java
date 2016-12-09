package com.hao.t_extends_interface.view.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hao.t_extends_interface.view.R;
import com.hao.t_extends_interface.view.fragment.FragmentClassify;
import com.hao.t_extends_interface.view.fragment.FragmentHome;
import com.hao.t_extends_interface.view.fragment.FragmentShopping;
import com.hao.t_extends_interface.view.fragment.FragmentUser;

public class MainActivity1 extends FragmentActivity {

    private ImageView image_tab_home;
    private ImageView image_tab_classify;
    private ImageView image_tab_shopping;
    private ImageView image_tab_user;
    private TextView text_tab_home;
    private TextView text_tab_classify;
    private TextView text_tab_shopping;
    private TextView text_tab_user;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //初始化视图
        initViews();
        image_tab_home.setSelected(true);
        text_tab_home.setTextColor(Color.RED);
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.main1_linearLayout,new FragmentHome()).commit();
    }

    private void initViews() {
        image_tab_home = (ImageView) findViewById(R.id.image_tab_home);
        image_tab_classify = (ImageView) findViewById(R.id.image_tab_classify);
        image_tab_shopping = (ImageView) findViewById(R.id.image_tab_shopping);
        image_tab_user = (ImageView) findViewById(R.id.image_tab_user);
        text_tab_home = (TextView) findViewById(R.id.text_tab_home);
        text_tab_classify = (TextView) findViewById(R.id.text_tab_classify);
        text_tab_shopping = (TextView) findViewById(R.id.text_tab_shopping);
        text_tab_user = (TextView) findViewById(R.id.text_tab_user);
    }

    public void home(View v){
        image_tab_home.setSelected(true);
        image_tab_classify.setSelected(false);
        image_tab_shopping.setSelected(false);
        image_tab_user.setSelected(false);
        text_tab_home.setTextColor(Color.RED);
        text_tab_classify.setTextColor(Color.BLACK);
        text_tab_shopping.setTextColor(Color.BLACK);
        text_tab_user.setTextColor(Color.BLACK);

        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.main1_linearLayout,new FragmentHome()).commit();

    }
    public void classify(View v){
        image_tab_home.setSelected(false);
        image_tab_classify.setSelected(true);
        image_tab_shopping.setSelected(false);
        image_tab_user.setSelected(false);
        text_tab_home.setTextColor(Color.BLACK);
        text_tab_classify.setTextColor(Color.RED);
        text_tab_shopping.setTextColor(Color.BLACK);
        text_tab_user.setTextColor(Color.BLACK);


        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.main1_linearLayout,new FragmentClassify()).commit();
    }
    public void shopping(View v){
        image_tab_home.setSelected(false);
        image_tab_classify.setSelected(false);
        image_tab_shopping.setSelected(true);
        image_tab_user.setSelected(false);
        text_tab_home.setTextColor(Color.BLACK);
        text_tab_classify.setTextColor(Color.BLACK);
        text_tab_shopping.setTextColor(Color.RED);
        text_tab_user.setTextColor(Color.BLACK);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.main1_linearLayout,new FragmentShopping()).commit();
    }
    public void user(View v){
        image_tab_home.setSelected(false);
        image_tab_classify.setSelected(false);
        image_tab_shopping.setSelected(false);
        image_tab_user.setSelected(true);
        text_tab_home.setTextColor(Color.BLACK);
        text_tab_classify.setTextColor(Color.BLACK);
        text_tab_shopping.setTextColor(Color.BLACK);
        text_tab_user.setTextColor(Color.RED);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.main1_linearLayout,new FragmentUser()).commit();
    }



}
