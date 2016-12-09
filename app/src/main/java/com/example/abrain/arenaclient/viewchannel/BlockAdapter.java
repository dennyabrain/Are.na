package com.example.abrain.arenaclient.viewchannel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.abrain.arenaclient.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by abrain on 12/9/16.
 */

public class BlockAdapter extends ArrayAdapter {
    private final String TAG = BlockAdapter.class.getSimpleName();
    private  List<Block> block;

    public BlockAdapter(Context context, int resource, List<Block> objects) {
        super(context, 0, objects);
        block = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_gridview_channel, parent, false);
        }

        //Block block =  (Block)getItem(position);
        if(block.get(position).getImage()==null){
            return convertView;
        }
        else {
            String url = block.get(position).getImage().getDisplay().getUrl();
            ImageView img = (ImageView)convertView.findViewById(R.id.imageView);
            Picasso.with(getContext())
                    .load(url)
                    .fit()
                    .centerCrop()
                    .into(img);
            Log.d(TAG, url);
        }


//        Log.d(TAG, url);
//        //String url = block.get(position+3).getImage().getDisplay().getUrl();
//        ImageView img = (ImageView)convertView.findViewById(R.id.imageView);
//        Picasso.with(getContext()).load(url).into(img);

        return convertView;
    }
}
