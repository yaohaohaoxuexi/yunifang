package com.hao.t_extends_interface.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.hao.t_extends_interface.persenter.PersenterClassify;
import com.hao.t_extends_interface.view.R;
import com.hao.t_extends_interface.view.adapter.MyGridViewClassifyAdapter;
import com.hao.t_extends_interface.view.adapter.MyGridViewHomeAdapter2;
import com.hao.t_extends_interface.view.bean.BeanClassify;
import com.hao.t_extends_interface.view.inter_face.MyViewClassify;

import java.util.ArrayList;

/**
 * Created by yaoshuhao on 2016-12-06.
 */

public class FragmentClassify extends Fragment implements MyViewClassify{

    private GridView fragment_classify_gridView;
    private PersenterClassify persenterClassify;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_classify,null);
        return view1;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化视图
        initView();
        persenterClassify = new PersenterClassify();
        persenterClassify.setMyView(this);
        //设置数据
        initData();
    }
    //添加数据
    private void initData() {
        persenterClassify.loadData();
    }

    //初始化视图
    private void initView() {
        fragment_classify_gridView = (GridView) getView().findViewById(R.id.fragment_classify_gridView);
    }

    @Override
    public void successBrief(ArrayList<BeanClassify.DataBean.GoodsBriefBean> list) {
        fragment_classify_gridView.setAdapter(new MyGridViewClassifyAdapter(getActivity(),list));
    }
}
