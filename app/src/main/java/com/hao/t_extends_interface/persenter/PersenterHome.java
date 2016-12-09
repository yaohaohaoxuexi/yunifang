package com.hao.t_extends_interface.persenter;

import com.hao.t_extends_interface.model.ModelTest;
import com.hao.t_extends_interface.view.bean.BeanHome;
import com.hao.t_extends_interface.view.inter_face.MyViewHome;
import com.hao.t_extends_interface.view.url.HttpUrl;
import com.hao.t_extends_interface.view.utils.JsonUtils;

import java.util.ArrayList;

/**
 * Created by yaoshuhao on 2016-12-03.
 */

public class PersenterHome extends BasePersenter<MyViewHome> implements ModelTest.OnRequestJsonData {

    private ModelTest modelTest;

    public PersenterHome() {
        modelTest = new ModelTest();
    }

    public void loadData() {
        modelTest.getDataFromNet(HttpUrl.HOME_URL);
        modelTest.setOnRequestJsonData(this);
    }

    @Override
    public void requestJsonData(String str) {
        ArrayList<BeanHome.DataBean.Ad1Bean> list = JsonUtils.parseJsonAd1(str);
        getMyView().successAd1(list);
        ArrayList<BeanHome.DataBean.Ad5Bean> list5 = JsonUtils.parseJsonAd5(str);
        getMyView().successAd5(list5);
        ArrayList<BeanHome.DataBean.ActivityInfoBean.ActivityInfoListBean> listYouHui=JsonUtils.parseJsonYouHui(str);
        getMyView().successYouHui(listYouHui);
        ArrayList<BeanHome.DataBean.DefaultGoodsListBean> listDefault = JsonUtils.parseJsonDefault(str);
        getMyView().successDefault(listDefault);
    }
}
