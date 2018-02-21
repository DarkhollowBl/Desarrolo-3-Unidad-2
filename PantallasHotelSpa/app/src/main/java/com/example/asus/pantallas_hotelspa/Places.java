package com.example.asus.pantallas_hotelspa;

/**
 * Created by Daniel on 08/02/2018.
 */

public class Places {
    private int imageId;
    private String name;
    private String location;
    private String type;

    public Places(int imageId, String name, String location, String type){
        this.imageId=imageId;
        this.name=name;
        this.location=location;
        this.type=type;
    }
    public Places(){
        this(R.mipmap.ic_launcher_round, "unamed", "unlocated", "untyped");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }
}
