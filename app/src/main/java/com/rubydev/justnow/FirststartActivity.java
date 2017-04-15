package com.rubydev.justnow;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirststartActivity extends AppCompatActivity {
    TextView tvBBCnews, tvBBCsport, tvBI, tvFortune, tvMashable, tvCNN, tvNatgeo, tvTC;
    Button btnFinish;
    List<String> listProvider;
    Intent i;

    ListNews listNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firststart);
        listProvider = new ArrayList<>();
        listNews = new ListNews();

        findViewById();
    }

    void findViewById() {
        tvBBCnews = (TextView) findViewById(R.id.tvBBCnews);
        tvBBCnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBBCnews.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvBBCnews.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvBBCnews.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("bbc-news");
                } else {
                    tvBBCnews.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvBBCnews.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("bbc-news");
                }

                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvBBCsport = (TextView) findViewById(R.id.tvBBCsport);
        tvBBCsport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBBCsport.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvBBCsport.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvBBCsport.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("bbc-sport");
                } else {
                    tvBBCsport.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvBBCsport.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("bbc-sport");
                }

                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvBI = (TextView) findViewById(R.id.tvBI);
        tvBI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBI.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvBI.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvBI.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("business-insider");
                } else {
                    tvBI.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvBI.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("business-insider");
                }
                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvFortune = (TextView) findViewById(R.id.tvFortune);
        tvFortune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvFortune.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvFortune.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvFortune.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("fortune");
                } else {
                    tvFortune.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvFortune.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("fortune");
                }

                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvMashable = (TextView) findViewById(R.id.tvMashable);
        tvMashable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvMashable.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvMashable.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvMashable.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("mashable");
                } else {
                    tvMashable.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvMashable.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("mashable");
                }

                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvCNN = (TextView) findViewById(R.id.tvCNN);
        tvCNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvCNN.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvCNN.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvCNN.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("cnn");
                } else {
                    tvCNN.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvCNN.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("cnn");
                }

                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvNatgeo = (TextView) findViewById(R.id.tvNatgeo);
        tvNatgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvNatgeo.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvNatgeo.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvNatgeo.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("national-geographic");
                } else {
                    tvNatgeo.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvNatgeo.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("national-geographic");
                }

                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvTC = (TextView) findViewById(R.id.tvTechCrunch);
        tvTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvTC.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvTC.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvTC.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    listProvider.add("techcrunch");
                } else {
                    tvTC.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvTC.setBackgroundResource(R.drawable.checkboxbg);
                    listProvider.remove("techcrunch");
                }

                if (listProvider.size() > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Provider provider = new Provider(listProvider);
                ProviderPref.save(provider, FirststartActivity.this);
                for (int j = 0; j < listProvider.size(); j++) {
                    loadData(listProvider.get(j));
                }
                i = new Intent(FirststartActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
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
                    NewsPref.save(listNews, FirststartActivity.this);
                }
            }

            @Override
            public void onFailure(Call<NewsDao> call, Throwable t) {
                startActivity(i);
                finish();
            }
        });

    }
}
