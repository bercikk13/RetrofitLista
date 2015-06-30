package com.bercik.retrofitlista.views;

import android.content.Context;
import android.widget.TextView;

import com.bercik.retrofitlista.R;
import com.bercik.retrofitlista.model.Achievement;


public class ArticleView extends  BaseView<Achievement>{
    TextView titleTextView;
    public ArticleView(Context context) {
        super(context);
        inflate(getContext(), R.layout.row, this);
        titleTextView = (TextView) findViewById(R.id.Row);
    }
    @Override
    public void setData(Achievement achievements, int position) {

        titleTextView.setText(achievements.toString());
    }
}
