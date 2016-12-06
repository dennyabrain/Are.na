package com.example.abrain.arenaclient.viewchannel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.abrain.arenaclient.R;
import com.example.abrain.arenaclient.networking.ArenaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChannelActivity extends AppCompatActivity {
    private final static String TAG = ChannelActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        ArenaService arenaService = ArenaService.retrofit.create(ArenaService.class);
        Call<List<Block>> call = arenaService.block();
        call.enqueue(new Callback<List<Block>>(){

            @Override
            public void onResponse(Call<List<Block>> call, Response<List<Block>> response) {
                Log.d(TAG, "success");
            }


            @Override
            public void onFailure(Call<List<Block>> call, Throwable t) {
                Log.d(TAG, "exception : "+t.getMessage());
            }
        });
    }
}
