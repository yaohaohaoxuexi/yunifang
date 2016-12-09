package com.hao.t_extends_interface.view.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
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
 * 首页 最下方 的数据适配
 * Created by yaoshuhao on 2016-12-06.
 */

public class MyGridViewHomeAdapter2 extends BaseAdapter {
    private Context context;
    private ArrayList<BeanHome.DataBean.DefaultGoodsListBean> list;

    public MyGridViewHomeAdapter2(Context context, ArrayList<BeanHome.DataBean.DefaultGoodsListBean> list) {
        this.context = context;
        this.list = list;
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
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_home_gridview2, null);
        }
        ImageView gridview2_imageview1 = (ImageView) view.findViewById(R.id.fragment_home_gridview2_imageview1);
        ImageView gridview2_imageview2 = (ImageView) view.findViewById(R.id.fragment_home_gridview2_imageview2);
        TextView gridview2_textview1 = (TextView) view.findViewById(R.id.fragment_home_gridview2_textview1);
        TextView gridview2_textview2 = (TextView) view.findViewById(R.id.fragment_home_gridview2_textview2);
        TextView gridview2_textview3 = (TextView) view.findViewById(R.id.fragment_home_gridview2_textview3);
        TextView gridview2_textview4 = (TextView) view.findViewById(R.id.fragment_home_gridview2_textview4);
        gridview2_textview1.setText(list.get(i).getEfficacy());
        gridview2_textview2.setText(list.get(i).getGoods_name());
        gridview2_textview3.setText("￥"+list.get(i).getShop_price() );
        gridview2_textview4.setText("￥"+list.get(i).getMarket_price() );
        gridview2_textview4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Picasso.with(context).load(list.get(i).getWatermarkUrl()).into(gridview2_imageview1);
        Picasso.with(context).load(list.get(i).getGoods_img()).into(gridview2_imageview2);
        return view;
    }
}
