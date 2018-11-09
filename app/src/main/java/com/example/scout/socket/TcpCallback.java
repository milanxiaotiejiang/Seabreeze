package com.example.scout.socket;

import com.robot.seabreeze.log.Log;

public abstract class TcpCallback extends Callback {


    @Override
    public void onError(Exception e) {
        Log.e("onError");
    }

    @Override
    public void onFail(String msg) {
        Log.e("onFail");
    }

}
