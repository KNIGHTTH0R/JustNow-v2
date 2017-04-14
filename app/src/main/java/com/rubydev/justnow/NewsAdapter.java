package com.rubydev.justnow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, NewsReader.class);
                i.putExtra("newsreader", list.get(v))
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, final int position) {
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvDesc.setText(list.get(position).getDescription());
        holder.tvAuthor.setText(list.get(position).getAuthor());

        Picasso.with(context)
                .load(list.get(position).getUrlToImage())
                //.resize(400,-1)
                .into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc, tvAuthor;
        ImageView ivPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
        }
    }


}
