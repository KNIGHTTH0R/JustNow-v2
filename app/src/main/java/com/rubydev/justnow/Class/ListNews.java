package com.rubydev.justnow.Class;

import android.util.Log;

import com.rubydev.justnow.News.NewsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yogiwisesa on 15/04/17.
 */

public class ListNews {
    private List<NewsDao.ArticlesBean> list = new ArrayList<>();

    public List<NewsDao.ArticlesBean> getList() {
        return list;
    }

    public void setList(List<NewsDao.ArticlesBean> list) {
        this.list = list;
    }

    public void addList(List<NewsDao.ArticlesBean> list) {

        this.list.addAll(list);
        Log.i("yogi", "ListNews: " + this.list.size());
    }
}
