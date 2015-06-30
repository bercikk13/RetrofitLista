package com.bercik.retrofitlista.views;

import android.content.Context;
import android.widget.RelativeLayout;


public abstract class BaseView <T> extends RelativeLayout implements SetData<T>{
    public BaseView(Context context) {
        super(context);
    }
}