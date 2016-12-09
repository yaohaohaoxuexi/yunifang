package com.hao.t_extends_interface.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hao.t_extends_interface.view.R;
import com.hao.t_extends_interface.view.bean.BeanHome;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * 首页 每日签到 的数据适配
 * Created by yaoshuhao on 2016-12-06.
 */

public class MyGridViewHomeAdapter extends BaseAdapter{
    private  Context context;
    private ArrayList<BeanHome.DataBean.Ad5Bean> list;
    public MyGridViewHomeAdapter(Context context, ArrayList<BeanHome.DataBean.Ad5Bean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.fragment_home_gridview,null);
        }
        ImageView gridview_imageview = (ImageView) view.findViewById(R.id.fragment_home_gridview_imageview);
        TextView gridview_textview = (TextView) view.findViewById(R.id.fragment_home_gridview_textview);
        gridview_textview.setText(list.get(i).getTitle());
        Picasso.with(context).load(list.get(i).getImage()).into(gridview_imageview);
        return view;
    }
}
