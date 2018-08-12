package com.example.bch__8_11.untils;

import com.example.bch__8_11.api.Api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroRx {
    private static OkHttpClient.Builder Okbuilder = new OkHttpClient.Builder();
    private static Retrofit.Builder Rebuilder = new Retrofit.Builder()
            .client(Okbuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(Api.URL);

    public static void setInterceptor(Interceptor interceptor){
        Okbuilder.addInterceptor(interceptor);
    }
    public static <S> S setSerice(Class<S> serice){
        Retrofit build = Rebuilder.build();
        S s = build.create(serice);

        return s;
    }
}
