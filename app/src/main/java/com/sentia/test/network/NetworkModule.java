package com.sentia.test.network;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by don.chummar on 22/3/18.
 */

public class NetworkModule {

    private static NetworkModule instance;
    private static SentiaApi appService = null;

    public static void init(Context context){
        if (instance == null) {
            synchronized (NetworkModule.class) {
                if (instance == null) {
                    instance = new NetworkModule(context);
                }
            }
        }
    }

    private NetworkModule(Context context) {
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient;

        okHttpClient = builder.cache(cache)
                .build();


        appService = new Retrofit.Builder()
                .baseUrl(SentiaApiUrl.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(SentiaApi.class);
    }

    public static SentiaApi getNetworkClient() {
        return appService;
    }

}
