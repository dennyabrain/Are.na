package com.example.abrain.arenaclient.viewchannel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abrain on 12/9/16.
 */

public class Url {
    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl(){
        return url;
    }
}

