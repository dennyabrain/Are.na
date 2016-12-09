package com.example.abrain.arenaclient.viewchannel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abrain on 12/9/16.
 */

public class Image {
    @SerializedName("display")
    @Expose
    private Url display;

    public Url getDisplay(){
        return display;
    }
}
