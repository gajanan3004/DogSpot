package com.example.dogspot;

public class PetDataModel {

    String name,des,price;
    int image_path;
    String link;

    public PetDataModel(String nam, String description, String pri, int image,String link){
        this.name = nam;
        this.des = description;
        this.price = pri;
        this.image_path = image;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage_path() {
        return image_path;
    }

    public void setImage_path(int image_path) {
        this.image_path = image_path;
    }
}
