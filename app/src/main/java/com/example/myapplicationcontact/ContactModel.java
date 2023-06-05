package com.example.myapplicationcontact;

public class ContactModel {
    int img;
    String name;
    String num;

    public ContactModel(int img, String name, String num) {
        this.name = name;
        this.num = num;
        this.img = img;
    }
    public ContactModel(String name,String num){
        this.name = name;
        this.num = num;
    }
}
