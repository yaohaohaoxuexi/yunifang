package com.hao.t_extends_interface.persenter;

import com.hao.t_extends_interface.model.ModelTest;
import com.hao.t_extends_interface.view.bean.BeanClassify;
import com.hao.t_extends_interface.view.inter_face.MyViewClassify;
import com.hao.t_extends_interface.view.inter_face.MyViewHome;
import com.hao.t_extends_interface.view.url.HttpUrl;
import com.hao.t_extends_interface.view.utils.JsonUtils;

import java.util.ArrayList;

/**
 * Created by yaoshuhao on 2016-12-03.
 */

public class PersenterClassify extends BasePersenter<MyViewClassify> implements ModelTest.OnRequestJsonData{

    private ModelTest modelTest;

    public PersenterClassify() {
        modelTest = new ModelTest();
    }

    public void loadData() {

        modelTest.getDataFromNet(HttpUrl.CLASSIFY_URL);
        modelTest.setOnRequestJsonData(this);

    }

    @Override
    public void requestJsonData(String str) {

        ArrayList<BeanClassify.DataBean.GoodsBriefBean> list = JsonUtils.parseJsonBrief(str);
        getMyView().successBrief(list);

    }
}
