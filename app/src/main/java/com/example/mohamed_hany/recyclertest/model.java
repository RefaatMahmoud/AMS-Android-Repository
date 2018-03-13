package com.example.mohamed_hany.recyclertest;

/**
 * Created by Mohamed_Hany on 2/27/2018.
 */

public class model {

        private String name;

        private String place;
        private int image;
        private String time;

    public model(String name , int image , String time , String place) {
        this.name = name;
        this.image = image;
        this.place = place;
        this.time = time;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}



