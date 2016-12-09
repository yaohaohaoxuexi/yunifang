package com.hao.t_extends_interface.persenter;

import com.hao.t_extends_interface.view.inter_face.MyView;

/**
 * Created by yaoshuhao on 2016-12-03.
 */

public class BasePersenter<T extends MyView>{

    private T myView;

    public void setMyView(T myView) {
        this.myView = myView;
    }

    public T getMyView() {
        return myView;
    }
}
