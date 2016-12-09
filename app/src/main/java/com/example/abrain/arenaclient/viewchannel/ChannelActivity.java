package com.example.abrain.arenaclient.viewchannel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private ImageView[] imageView;

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

        imageView = new ImageView[10];

        imageView[0] = (ImageView)(findViewById(R.id.imageView0));
        imageView[1] = (ImageView)(findViewById(R.id.imageView1));
        imageView[2] = (ImageView)(findViewById(R.id.imageView2));
        imageView[3] = (ImageView)(findViewById(R.id.imageView3));
        imageView[4] = (ImageView)(findViewById(R.id.imageView4));
        imageView[5] = (ImageView)(findViewById(R.id.imageView5));
        imageView[6] = (ImageView)(findViewById(R.id.imageView6));
        imageView[7] = (ImageView)(findViewById(R.id.imageView7));
        imageView[8] = (ImageView)(findViewById(R.id.imageView8));
        imageView[9] = (ImageView)(findViewById(R.id.imageView9));


        //imageView = (ImageView)findViewById(R.id.imageView);

        ArenaService arenaService = retrofit.create(ArenaService.class);
        Call<Content> call = arenaService.block();
        call.enqueue(new Callback<Content>() {
            @Override
            public void onResponse(Call<Content> call, Response<Content> response) {
                Log.d(TAG, "success");
                Log.d(TAG, response.body().getContent().get(3).getImage().getDisplay().getUrl() +"");
                String url = response.body().getContent().get(3).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[0]);

                url = response.body().getContent().get(4).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[1]);

                url = response.body().getContent().get(5).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[2]);

                url = response.body().getContent().get(6).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[3]);

                url = response.body().getContent().get(7).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[4]);

                url = response.body().getContent().get(8).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[5]);

                url = response.body().getContent().get(9).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[6]);

                url = response.body().getContent().get(10).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[7]);

                url = response.body().getContent().get(11).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[8]);

                url = response.body().getContent().get(12).getImage().getDisplay().getUrl();
                Picasso.with(getApplicationContext()).load(url).into(imageView[9]);
            }

            @Override
            public void onFailure(Call<Content> call, Throwable t) {
                Log.d(TAG, "failed");
            }
        });
    }
}
