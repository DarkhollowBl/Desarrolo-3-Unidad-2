package com.example.asus.pantallas_hotelspa;

/**
 * Created by Daniel on 08/02/2018.
 */

public class Services {
    private int imageId;
    private String name;
    private String info;
    private String location;
    private String type;

    public Services(int imageId, String name, String info, String location, String type){
        this.imageId=imageId;
        this.name=name;
        this.info=info;
        this.location=location;
        this.type=type;
    }

    public Services(){
        this(R.mipmap.ic_launcher_round, "unamed","Info", "unlocated", "untyped");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {return info;}

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }
}
