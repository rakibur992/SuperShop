package com.example.supershop;

public class DBdata {
    private String imgUrl;
    private int quantity;

    public DBdata(){

    }
    public DBdata(String Url){
        imgUrl=Url;
    }
    public DBdata(String Url,int qty){
        imgUrl=Url;
        quantity=qty;

    }
    public String getUrl(){
        return imgUrl;
    }
    public int getQty(){
        return quantity;
    }

}
