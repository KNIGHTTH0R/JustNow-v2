package com.rubydev.justnow.News;

import javax.xml.transform.Source;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yogiwisesa on 13/04/17.
 */

public interface NewsClient {
    @GET("articles?apiKey=" + Service.API_KEY)
    Call<NewsDao> getNews(
            @Query("sortBy") String sort,
            @Query("source") String source
    );

    @GET("sources")
    Call<SourceDao> getSource();
}
