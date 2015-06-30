package com.bercik.retrofitlista;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.bercik.retrofitlista.backend.ArticleRepository;
import com.bercik.retrofitlista.backend.MyBaseAdapter;
import com.bercik.retrofitlista.model.Achievement;
import com.bercik.retrofitlista.model.Profile;
import com.bercik.retrofitlista.views.ArticleView;
import com.bercik.retrofitlista.views.BaseView;

import retrofit.RetrofitError;


public class MyActivity extends ActionBarActivity {

    private ListView listView;
    private MyBaseAdapter<Achievement> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter = new MyBaseAdapter<Achievement>(this) {
            @Override
            public BaseView createView() {
                return new ArticleView(MyActivity.this);
            }
        });

        ArticleRepository.getArticle(new ArticleRepository.OnResponse<Profile>() {
            @Override
            public void OnSuccess(Profile response) {

                adapter.addItems(response.getAchievements().getAchievements());
            }

            @Override
            public void OnError(RetrofitError retrofitError) {
                Toast.makeText(MyActivity.this, retrofitError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}