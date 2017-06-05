package com.rubydev.justnow.News;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yogiwisesa on 13/04/17.
 */

public class Service {
    public static final String API_KEY = "109cafd7e6a94b0cae047707712c8c25";
    public static final String BASE_URL = "https://newsapi.org/v1/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
