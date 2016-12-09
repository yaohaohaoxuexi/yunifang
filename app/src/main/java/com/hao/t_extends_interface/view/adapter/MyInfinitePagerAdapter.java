package com.hao.t_extends_interface.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by yaoshuhao on 2016-12-05.
 */

public class MyInfinitePagerAdapter extends PagerAdapter{
    private Context context;
    private ArrayList<View> list;

    public MyInfinitePagerAdapter(Context context, ArrayList<View> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPasition=position%list.size();
        View view = list.get(newPasition);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

}
