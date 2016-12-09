package com.hao.t_extends_interface.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hao.t_extends_interface.persenter.Persenter2;
import com.hao.t_extends_interface.view.R;
import com.hao.t_extends_interface.view.inter_face.MyView2;

/**
 * Created by yaoshuhao on 2016-12-03.
 */

public class MainAvtivity2 extends AppCompatActivity implements MyView2{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Persenter2 persenter2=new Persenter2();
        persenter2.setMyView(this);

    }

    @Override
    public void ok2(String str) {

    }
}
