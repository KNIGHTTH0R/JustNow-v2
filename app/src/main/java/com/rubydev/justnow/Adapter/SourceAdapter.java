package com.rubydev.justnow.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rubydev.justnow.Activity.FirststartActivity;
import com.rubydev.justnow.Activity.MainActivity;
import com.rubydev.justnow.Class.ListNews;
import com.rubydev.justnow.Class.Provider;
import com.rubydev.justnow.News.NewsClient;
import com.rubydev.justnow.News.NewsDao;
import com.rubydev.justnow.News.Service;
import com.rubydev.justnow.News.SourceDao;
import com.rubydev.justnow.Preferences.NewsPref;
import com.rubydev.justnow.Preferences.ProviderPref;
import com.rubydev.justnow.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yogiwisesa on 18/04/17.
 */

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.ViewHolder> {
    private Context context;
    private List<SourceDao.SourcesBean> list = new ArrayList<>();

    public SourceAdapter(Context context, List<SourceDao.SourcesBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SourceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sourceitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvSource.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvSource;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvSource = (TextView) itemView.findViewById(R.id.tvSource);
        }

        @Override
        public void onClick(View view) {
            Provider provider = new Provider(list.get(getAdapterPosition()).getId());
            ProviderPref.save(provider, context);
            loadData(list.get(getAdapterPosition()).getId());
        }
    }

    public void loadData(String source) {
        final ListNews listNews = new ListNews();
        NewsClient client = Service.createService(NewsClient.class);
        Call<NewsDao> call = client.getNews("top", source);
        call.enqueue(new Callback<NewsDao>() {
            @Override
            public void onResponse(Call<NewsDao> call, Response<NewsDao> response) {
                if (response.isSuccessful()) {
                    NewsDao newsDao = response.body();
                    listNews.addList(newsDao.getArticles());
                    NewsPref.save(listNews, context);
                    Intent i = new Intent(context, MainActivity.class);
                    context.startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<NewsDao> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
