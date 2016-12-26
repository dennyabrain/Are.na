package com.example.abrain.arenaclient.networking;

import com.example.abrain.arenaclient.viewchannel.Block;
import com.example.abrain.arenaclient.viewchannel.Content;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by abrain on 12/5/16.
 */

public interface ArenaService {

    @GET("v2/channels/ttlandscape/contents")
    Call<Content> block();

    //ttlandscape
    //art-on-the-internet
}
