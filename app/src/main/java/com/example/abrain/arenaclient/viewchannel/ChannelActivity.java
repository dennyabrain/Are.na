package com.example.abrain.arenaclient.viewchannel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.abrain.arenaclient.R;
import com.example.abrain.arenaclient.networking.ArenaService;
import com.squareup.picasso.Picasso;

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

    private GridView gridView;
    private BlockAdapter adapter;

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

        gridView = (GridView)findViewById(R.id.gridview);


        ArenaService arenaService = retrofit.create(ArenaService.class);
        Call<Content> call = arenaService.block();
        call.enqueue(new Callback<Content>() {
            @Override
            public void onResponse(Call<Content> call, Response<Content> response) {
                Log.d(TAG, "success");
                Log.d(TAG, response.body().getContent().get(3).getImage().getDisplay().getUrl() +"");
                String url = response.body().getContent().get(3).getImage().getDisplay().getUrl();
                //Picasso.with(getApplicationContext()).load(url).into(imageView[0]);
                adapter = new BlockAdapter(getApplicationContext(), 0, response.body().getContent());
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Content> call, Throwable t) {
                Log.d(TAG, "failed");
            }
        });
    }
}
