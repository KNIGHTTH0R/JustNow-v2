package com.rubydev.justnow.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rubydev.justnow.Class.ListNews;
import com.rubydev.justnow.Adapter.NewsAdapter;
import com.rubydev.justnow.News.NewsDao;
import com.rubydev.justnow.Preferences.NewsPref;
import com.rubydev.justnow.Preferences.ProviderPref;
import com.rubydev.justnow.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<NewsDao.ArticlesBean> list = new ArrayList<>();
    private NewsAdapter adapter;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    void setup() {
        rv = (RecyclerView) findViewById(R.id.rv);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rv);

        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);

        ListNews listNews = NewsPref.load(this);
        if (listNews == null) {
            rv.setVisibility(View.GONE);
            NewsPref.clearAll(MainActivity.this);
            ProviderPref.clearAll(MainActivity.this);
        } else {
            list.addAll(listNews.getList());
        }

        adapter = new NewsAdapter(MainActivity.this, list);
        rv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newsProvider:
                Intent i = new Intent(MainActivity.this, FirststartActivity.class);
                startActivity(i);
                finish();
                return true;

            case R.id.reset:
                ProviderPref.clearAll(MainActivity.this);
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
