package com.hao.t_extends_interface.view.utils;

import com.google.gson.Gson;
import com.hao.t_extends_interface.view.bean.BeanClassify;
import com.hao.t_extends_interface.view.bean.BeanHome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoshuhao on 2016-12-05.
 */

public class JsonUtils {

    //解析无限轮播图片数据
    public static ArrayList<BeanHome.DataBean.Ad1Bean> parseJsonAd1(String json){
        Gson gson=new Gson();
        BeanHome beanHome = gson.fromJson(json, BeanHome.class);
        ArrayList<BeanHome.DataBean.Ad1Bean> list = (ArrayList<BeanHome.DataBean.Ad1Bean>) beanHome.getData().getAd1();
        return list;
    }
    //解析首页中GridView的数据，每日签到
    public static ArrayList<BeanHome.DataBean.Ad5Bean> parseJsonAd5(String json){
        Gson gson=new Gson();
        BeanHome beanHome = gson.fromJson(json, BeanHome.class);
        ArrayList<BeanHome.DataBean.Ad5Bean> list = (ArrayList<BeanHome.DataBean.Ad5Bean>) beanHome.getData().getAd5();
        return list;
    }
    //优惠活动中的图片数据
    public static ArrayList<BeanHome.DataBean.ActivityInfoBean.ActivityInfoListBean> parseJsonYouHui(String json){
        Gson gson=new Gson();
        BeanHome beanHome = gson.fromJson(json, BeanHome.class);
        ArrayList<BeanHome.DataBean.ActivityInfoBean.ActivityInfoListBean> list = (ArrayList<BeanHome.DataBean.ActivityInfoBean.ActivityInfoListBean>) beanHome.getData().getActivityInfo().getActivityInfoList();
        return list;
    }
    //首页中最下面的数据信息
    public static ArrayList<BeanHome.DataBean.DefaultGoodsListBean> parseJsonDefault(String json){
        Gson gson=new Gson();
        BeanHome beanHome = gson.fromJson(json, BeanHome.class);
        ArrayList<BeanHome.DataBean.DefaultGoodsListBean> list = (ArrayList<BeanHome.DataBean.DefaultGoodsListBean>) beanHome.getData().getDefaultGoodsList();
        return list;
    }
    //分类页面的最下面 的数据信息
    public static ArrayList<BeanClassify.DataBean.GoodsBriefBean> parseJsonBrief(String json){
        Gson gson=new Gson();
        BeanClassify beanClassify = gson.fromJson(json, BeanClassify.class);
        ArrayList<BeanClassify.DataBean.GoodsBriefBean> list = (ArrayList<BeanClassify.DataBean.GoodsBriefBean>) beanClassify.getData().getGoodsBrief();
        return list;
    }
}
