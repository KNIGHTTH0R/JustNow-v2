package com.rubydev.justnow.Activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.rubydev.justnow.Adapter.NewsAdapter;
import com.rubydev.justnow.Adapter.SourceAdapter;
import com.rubydev.justnow.Class.ListNews;
import com.rubydev.justnow.News.NewsClient;
import com.rubydev.justnow.News.NewsDao;
import com.rubydev.justnow.News.SourceDao;
import com.rubydev.justnow.Preferences.NewsPref;
import com.rubydev.justnow.Preferences.ProviderPref;
import com.rubydev.justnow.Class.Provider;
import com.rubydev.justnow.R;
import com.rubydev.justnow.News.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirststartActivity extends AppCompatActivity {
    RecyclerView rv;
    EditText edtSearch;
    private SourceAdapter adapter;
    List<SourceDao.SourcesBean> listProvider, listShow;

    ListNews listNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firststart);
        listProvider = new ArrayList<>();
        listNews = new ListNews();
        listShow = new ArrayList<>();

        setTitle("Select a provider...");
        loadProvider();
        rv = (RecyclerView) findViewById(R.id.rv);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager();
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        adapter = new SourceAdapter(this, listShow);
        rv.setAdapter(adapter);

        edtSearch = (EditText) findViewById(R.id.edtSearch);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtSearch.getText().toString().equals("")){
                    listShow.clear();
                    listShow.addAll(listProvider);
                    adapter.notifyItemInserted(listShow.size());
                } else {
                    listShow.clear();
                    for (int j = 0; j < listProvider.size() ; j++) {
                        if (listProvider.get(j).getName().toUpperCase().contains(edtSearch.getText().toString().toUpperCase())){
                            listShow.add(listProvider.get(j));
                            adapter.notifyItemInserted(listShow.size());
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    void loadProvider(){
        NewsClient client = Service.createService(NewsClient.class);
        Call<SourceDao> call = client.getSource();
        call.enqueue(new Callback<SourceDao>() {
            @Override
            public void onResponse(Call<SourceDao> call, Response<SourceDao> response) {
                if (response.isSuccessful()) {
                    SourceDao sourceDao = response.body();
                    listProvider.addAll(sourceDao.getSources());
                    listShow.addAll(sourceDao.getSources());
                    adapter.notifyItemInserted(listShow.size());
                }
            }

            @Override
            public void onFailure(Call<SourceDao> call, Throwable t) {
                Toast.makeText(FirststartActivity.this, "Failed to connect to the internet", Toast.LENGTH_SHORT).show();
            }

        });

    }

}
