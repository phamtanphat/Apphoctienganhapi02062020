package com.example.apphoctienganhapi02062020.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
    private static RetrofitAPI retrofitAPI = null;
    private static Retrofit retrofit = null;

    private RetrofitAPI() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://phat0206.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RequestAPI getInstance() {
        if (retrofitAPI == null) {
            retrofitAPI = new RetrofitAPI();
        }
    }
}
