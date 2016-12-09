package com.example.abrain.arenaclient.viewchannel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abrain on 12/9/16.
 */

public class Content {
    @SerializedName("contents")
    @Expose
    private List<Block> block;

    public List<Block>getContent(){
        return block;
    }
}
