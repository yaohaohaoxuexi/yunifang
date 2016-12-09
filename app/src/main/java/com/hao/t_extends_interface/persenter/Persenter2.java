package com.hao.t_extends_interface.persenter;

import com.hao.t_extends_interface.view.inter_face.MyView2;

/**
 * Created by yaoshuhao on 2016-12-03.
 */

public class Persenter2 extends BasePersenter<MyView2>{

    public void loadData(){

        getMyView().ok2("ok2");
    }
}
