package com.rubydev.justnow.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rubydev.justnow.News.NewsDao;
import com.rubydev.justnow.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yogiwisesa on 13/04/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<NewsDao.ArticlesBean> list = new ArrayList<>();

    public NewsAdapter(Context context, List<NewsDao.ArticlesBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, final int position) {
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvAuthor.setText(list.get(position).getAuthor());

        Picasso picasso = Picasso.with(context);
        picasso.setIndicatorsEnabled(true);
        picasso.load(list.get(position).getUrlToImage())
                //.resize(400,-1)
                .into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle, tvAuthor;
        ImageView ivPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
        }

        @Override
        public void onClick(View view) {
            String url = list.get(getAdapterPosition()).getUrl();
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
            customTabsIntent.launchUrl(context, Uri.parse(url));
        }
    }


}
