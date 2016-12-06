package com.example.abrain.arenaclient.viewchannel;

/**
 * Created by abrain on 12/5/16.
 */

public class Block {
    private String title;
    private String displayUrl;

    public String getTitle(){
        return title;
    }

    public String getDisplayUrl(){
        return displayUrl;
    }

    @Override
    public String toString() {
        return title+","+displayUrl;
    }
}
