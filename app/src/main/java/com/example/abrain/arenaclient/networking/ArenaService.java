package com.example.abrain.arenaclient.networking;

import com.example.abrain.arenaclient.viewchannel.Block;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by abrain on 12/5/16.
 */

public interface ArenaService {

    @GET("v2/channels/modern-love/contents")
    Call<List<Block>> block();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.are.na/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
