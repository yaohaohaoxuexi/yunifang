package com.hao.t_extends_interface.view.inter_face;

import com.hao.t_extends_interface.view.bean.BeanHome;

import java.util.ArrayList;

/**
 * Created by yaoshuhao on 2016-12-03.
 */

public interface MyViewHome extends MyView{

    public void successAd1(ArrayList<BeanHome.DataBean.Ad1Bean> list);
    public void successAd5(ArrayList<BeanHome.DataBean.Ad5Bean> list);
    public void successYouHui(ArrayList<BeanHome.DataBean.ActivityInfoBean.ActivityInfoListBean> list);
    public void successDefault(ArrayList<BeanHome.DataBean.DefaultGoodsListBean> list);
}
