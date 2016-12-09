package com.hao.t_extends_interface.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hao.t_extends_interface.view.R;
import com.hao.t_extends_interface.view.adapter.MyPagerAdapter;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private ArrayList<View> list;
    private ArrayList<ImageView> list1;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //引导页添加视图
        initView();
        //添加引导页数据
        initData();

        sp = getSharedPreferences("first_enter", MODE_PRIVATE);
        edit = sp.edit();
        if (sp.getBoolean("first4",false)){

            startActivity(new Intent(MainActivity.this,NavigationActivity.class));
            finish();
        }


        //导航页的实现
        viewPager.setAdapter(new MyPagerAdapter(MainActivity.this, list));
        //viewpager的监听切换页面，展示圆点
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                for (int i = 0; i < list1.size(); i++) {
                    list1.get(i).setSelected(false);
                }
                list1.get(position).setSelected(true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        //添加ViewPager的视图数据
        list = new ArrayList<View>();
        list.add(View.inflate(MainActivity.this, R.layout.viewpager1, null));
        list.add(View.inflate(MainActivity.this, R.layout.viewpager2, null));
        list.add(View.inflate(MainActivity.this, R.layout.viewpager3, null));
        list.add(View.inflate(MainActivity.this, R.layout.viewpager4, null));
        list.add(View.inflate(MainActivity.this, R.layout.viewpager5, null));
        //创建圆点的数据，并加入容器中
        list1 = new ArrayList<ImageView>();
        for (int i = 0; i < list.size(); i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.viewpager_shape_selector);
            iv.setPadding(5, 5, 5, 5);
            list1.add(iv);
            linearLayout.addView(iv);
        }
        //第一个圆点默认被选中
        list1.get(0).setSelected(true);
    }

    //初始化视图
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    //最后一张图片中的按钮点击方法
    public void enter(View v) {

        edit.putBoolean("first4",true);
        edit.commit();
        startActivity(new Intent(MainActivity.this, MainActivity1.class));
        finish();
    }
}
