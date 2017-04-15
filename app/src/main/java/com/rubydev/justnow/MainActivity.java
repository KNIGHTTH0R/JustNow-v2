package com.rubydev.justnow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
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
    TextView tvHeader;
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

    void setup() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvHeader = (TextView) findViewById(R.id.tvHeader);
        ivCollaps = (ImageView) findViewById(R.id.ivCollaps);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));

        rv = (RecyclerView) findViewById(R.id.rv);

        layoutManager = new StaggeredGridLayoutManager(2, 1);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);

        ListNews listNews = NewsPref.load(this);
        if (listNews == null) {
            //Selesaiin, ivHeader ganti ke gambar gagal loading
        } else {
            list.addAll(listNews.getList());

            Log.i("yogi", "Jumlah list MainActivity: " + list.size());
            Picasso picasso = Picasso.with(MainActivity.this);
            picasso.setIndicatorsEnabled(true);
            picasso.load(list.get(0).getUrlToImage()).into(ivCollaps);

            tvHeader.setText(list.get(0).getTitle());
            list.remove(0);
        }



        adapter = new NewsAdapter(MainActivity.this, list);
        rv.setAdapter(adapter);
    }
}
