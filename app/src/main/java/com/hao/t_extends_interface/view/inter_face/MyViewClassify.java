package com.hao.t_extends_interface.view.inter_face;

import com.hao.t_extends_interface.view.bean.BeanClassify;

import java.util.ArrayList;

/**
 * Created by yaoshuhao on 2016-12-07.
 */

public interface MyViewClassify extends MyView{

    public void successBrief(ArrayList<BeanClassify.DataBean.GoodsBriefBean> list);

}
