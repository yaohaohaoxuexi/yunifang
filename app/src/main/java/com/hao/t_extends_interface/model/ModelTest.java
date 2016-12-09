package com.hao.t_extends_interface.model;

import android.os.Handler;
import android.os.Message;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by yaoshuhao on 2016-12-03.
 */

public class ModelTest {
    private OnRequestJsonData data;
    //请求网络数据
    public void getDataFromNet(String url) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                String string = response.body().string();

                Message message = handler.obtainMessage();
                message.obj = string;

                handler.sendMessage(message);

            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String string = (String) msg.obj;
            data.requestJsonData(string);
        }
    };

    public interface OnRequestJsonData {
        void requestJsonData(String str);
    }

    public void setOnRequestJsonData(OnRequestJsonData data) {
        this.data = data;
    }
}
