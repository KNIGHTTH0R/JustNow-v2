package com.rubydev.justnow;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashscreenActivity extends AppCompatActivity {
    static ListNews listNews;
    ArrayList<String> listProvider = new ArrayList<>();

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
                    listProvider.addAll(provider.getProviderList());
                    for (int j = 0; j < listProvider.size(); j++) {
                        Log.i("yogi", listProvider.get(j));
                        loadData(listProvider.get(j));
                    }
                    i = new Intent(SplashscreenActivity.this, MainActivity.class);
                }
                ImageView iv = (ImageView) findViewById(R.id.iv);

                finish();
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

                    for (int j = 0; j < newsDao.getArticles().size(); j++) {
                        Picasso.with(SplashscreenActivity.this)
                                .load(newsDao.getArticles().get(j).getUrlToImage());
                    }

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
