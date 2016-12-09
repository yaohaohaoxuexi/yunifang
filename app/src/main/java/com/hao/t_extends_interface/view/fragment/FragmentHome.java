package com.hao.t_extends_interface.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hao.t_extends_interface.persenter.PersenterHome;
import com.hao.t_extends_interface.view.R;
import com.hao.t_extends_interface.view.adapter.MyGridViewHomeAdapter;
import com.hao.t_extends_interface.view.adapter.MyGridViewHomeAdapter2;
import com.hao.t_extends_interface.view.adapter.MyInfinitePagerAdapter;
import com.hao.t_extends_interface.view.bean.BeanHome;
import com.hao.t_extends_interface.view.inter_face.MyViewHome;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by yaoshuhao on 2016-12-05.
 */

public class FragmentHome extends Fragment implements MyViewHome {

    private ViewPager viewPager;
    private LinearLayout fragment_home_linearLayout;
    private PersenterHome persenterHome;
    private ArrayList<View> list1;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            infinite();
        }
    };
    private ArrayList<ImageView> list2;
    private GridView fragment_home_gridView;
    private ViewPager fragment_home_viewpager3;
    private GridView fragment_home_gridView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //初始化视图
        initView();
        persenterHome = new PersenterHome();
        persenterHome.setMyView(this);
        //设置无限轮播图片
        initData();
        //handler发送消息，实现无限轮播
        infinite();


    }

    private void initView() {
        viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        fragment_home_linearLayout = (LinearLayout) getView().findViewById(R.id.fragment_home_linearLayout);
        fragment_home_gridView = (GridView) getView().findViewById(R.id.fragment_home_gridView);
        fragment_home_viewpager3 = (ViewPager) getView().findViewById(R.id.fragment_home_viewpager3);
        fragment_home_gridView2 = (GridView) getView().findViewById(R.id.fragment_home_gridView2);
    }

    private void initData() {
        persenterHome.loadData();
    }

    @Override
    public void successAd1(ArrayList<BeanHome.DataBean.Ad1Bean> list) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ImageView iv = new ImageView(getActivity());
            Picasso.with(getActivity()).load(list.get(i).getImage()).into(iv);
            list1.add(iv);
            ImageView iv2 = new ImageView(getActivity());
            iv2.setImageResource(R.drawable.viewpager_infinite_shape_selector);
            iv2.setPadding(8, 8, 8, 8);
            list2.add(iv2);
            fragment_home_linearLayout.addView(iv2);
        }
        list2.get(0).setSelected(true);
        viewPager.setAdapter(new MyInfinitePagerAdapter(getActivity(), list1));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < list1.size(); i++) {
                    list2.get(i).setSelected(false);
                }
                int newPosition = position % list1.size();
                list2.get(newPosition).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //ViewPager触摸监听
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    //按下，停止滚动
                    case MotionEvent.ACTION_DOWN:
                        mHandler.removeCallbacksAndMessages(null);
                        break;
                    //松开，继续滚动
                    case MotionEvent.ACTION_UP:
                        infinite();
                        break;
                }
                return false;
            }
        });
    }

    //无限轮播发送消息
    public void infinite(){
        mHandler.sendEmptyMessageDelayed(0,3000);
    }
    //视图销毁的时候，销毁handler
    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void successAd5(ArrayList<BeanHome.DataBean.Ad5Bean> list) {
        fragment_home_gridView.setAdapter(new MyGridViewHomeAdapter(getActivity(),list));
    }

    @Override
    public void successYouHui(ArrayList<BeanHome.DataBean.ActivityInfoBean.ActivityInfoListBean> list) {
        ArrayList<View> list3=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ImageView iv3=new ImageView(getActivity());
            Picasso.with(getActivity()).load(list.get(i).getActivityImg()).into(iv3);
            list3.add(iv3);
        }
        fragment_home_viewpager3.setAdapter(new MyInfinitePagerAdapter(getActivity(),list3));
    }

    @Override
    public void successDefault(ArrayList<BeanHome.DataBean.DefaultGoodsListBean> list) {
        fragment_home_gridView2.setAdapter(new MyGridViewHomeAdapter2(getActivity(),list));
    }


}
