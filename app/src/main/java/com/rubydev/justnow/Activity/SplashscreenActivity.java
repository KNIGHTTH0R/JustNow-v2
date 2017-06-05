package com.rubydev.justnow.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.rubydev.justnow.Class.ListNews;
import com.rubydev.justnow.News.NewsClient;
import com.rubydev.justnow.News.NewsDao;
import com.rubydev.justnow.Preferences.NewsPref;
import com.rubydev.justnow.Preferences.ProviderPref;
import com.rubydev.justnow.Class.Provider;
import com.rubydev.justnow.R;
import com.rubydev.justnow.News.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashscreenActivity extends AppCompatActivity {
    static ListNews listNews;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                listNews = new ListNews();
                Provider provider = ProviderPref.load(SplashscreenActivity.this);
                if (provider == null) {
                    i = new Intent(SplashscreenActivity.this, FirststartActivity.class);
                } else {
                    loadData(provider.getProvider());
                    i = new Intent(SplashscreenActivity.this, MainActivity.class);
                }
                startActivity(i);
                finish();
            }
        }, 1500);
    }

    public void loadData(String source) {
        NewsClient client = Service.createService(NewsClient.class);
        Call<NewsDao> call = client.getNews("top", source);
        call.enqueue(new Callback<NewsDao>() {
            @Override
            public void onResponse(Call<NewsDao> call, Response<NewsDao> response) {
                if (response.isSuccessful()) {
                    NewsDao newsDao = response.body();
                    listNews.addList(newsDao.getArticles());
                    NewsPref.save(listNews, SplashscreenActivity.this);
                }
            }

            @Override
            public void onFailure(Call<NewsDao> call, Throwable t) {
            }
        });

    }

}
