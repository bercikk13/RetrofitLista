package com.bercik.retrofitlista.backend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bercik.retrofitlista.views.BaseView;

import java.util.ArrayList;
import java.util.List;


public abstract class MyBaseAdapter<T> extends BaseAdapter {
    List<T> items = new ArrayList<T>();
    Context context;

    public MyBaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseView baseView;
        if (view == null) {
            baseView = createView();
        }else {
            baseView = (BaseView) view;
        }
        baseView.setData( items.get(i),i);
        return baseView;
    }

    public void addItems( List<T>items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public abstract BaseView createView() ;
}