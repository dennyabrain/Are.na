package com.example.abrain.arenaclient.viewchannel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.abrain.arenaclient.R;
import com.example.abrain.arenaclient.networking.ArenaService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChannelActivity extends AppCompatActivity {
    private final static String TAG = ChannelActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.are.na")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArenaService arenaService = retrofit.create(ArenaService.class);
        Call<Content> call = arenaService.block();
        call.enqueue(new Callback<Content>() {
            @Override
            public void onResponse(Call<Content> call, Response<Content> response) {
                Log.d(TAG, "success");
                Log.d(TAG, response.body().getContent().get(1).getId()+"");
            }

            @Override
            public void onFailure(Call<Content> call, Throwable t) {
                Log.d(TAG, "failed");
            }
        });
    }
}
