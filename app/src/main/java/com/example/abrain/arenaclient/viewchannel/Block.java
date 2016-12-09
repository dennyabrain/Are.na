package com.example.abrain.arenaclient.viewchannel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abrain on 12/5/16.
 */

public class Block {
    @SerializedName("id")
    @Expose
    private int id;

    public int getId(){
        return id;
    }
}
