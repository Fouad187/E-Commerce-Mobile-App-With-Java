package com.example.administrator.afinal;

public class productdata {
    String name;
    String color;
    String price;
    byte[] image;

    public productdata() {
    }

    public productdata(String name, String color, String price, byte[] image) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
