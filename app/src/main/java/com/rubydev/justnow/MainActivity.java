package com.rubydev.justnow;

import android.app.ProgressDialog;
import android.media.Image;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    ImageView ivCollaps;
    String titleReal;
    AppBarLayout appbar;
    private List<NewsDao.ArticlesBean> list = new ArrayList<>();
    private NewsAdapter adapter;
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isVisible = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbar.setTitle("Just Now");
                    isVisible = true;
                } else if (isVisible) {
                    toolbar.setTitle(titleReal);
                    isVisible = false;
                }
            }
        });

        rv = (RecyclerView) findViewById(R.id.rv);

        layoutManager = new StaggeredGridLayoutManager(2, 1);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);


        adapter = new NewsAdapter(MainActivity.this, list);
        rv.setAdapter(adapter);

        loadData("cnn");
        loadData("cnbc");


    }

    public void loadData(String source) {
        NewsClient client = Service.createService(NewsClient.class);
        Call<NewsDao> call = client.getNews("top", source);
        call.enqueue(new Callback<NewsDao>() {
            @Override
            public void onResponse(Call<NewsDao> call, Response<NewsDao> response) {
                if (response.isSuccessful()) {
                    NewsDao newsDao = response.body();
                    list.addAll(newsDao.getArticles());
                    ivCollaps = (ImageView) findViewById(R.id.ivCollaps);
                    Picasso.with(MainActivity.this)
                            .load(list.get(1).getUrlToImage())
                            .into(ivCollaps);
                    titleReal = list.get(1).getTitle();
                    adapter.notifyItemInserted(list.size());

                }
            }

            @Override
            public void onFailure(Call<NewsDao> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
