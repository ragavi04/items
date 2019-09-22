package com.example.mobile_project;

public class Item {
    private int id;
    private String name;
    private String price;
    private String des;
    private byte[] image;

    public Item(String name, String price, String des, byte[] image, int id) {
        this.name = name;
        this.price = price;
        this.des = des;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
