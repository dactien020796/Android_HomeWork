package com.example.dactien.homework_2;

/**
 * Created by DacTien on 3/31/2018.
 */

public class Dish {
    private String name;
    private int icon;
    private int high_image;
    private int image_tutorial;

    public Dish(String name, int icon, int high_image, int image_tutorial) {
        this.name = name;
        this.icon = icon;
        this.high_image = high_image;
        this.image_tutorial = image_tutorial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getHigh_image() {
        return high_image;
    }

    public void setHigh_image(int high_image) {
        this.high_image = high_image;
    }

    public int getImage_tutorial() {
        return image_tutorial;
    }

    public void setImage_tutorial(int image_tutorial) {
        this.image_tutorial = image_tutorial;
    }
}
