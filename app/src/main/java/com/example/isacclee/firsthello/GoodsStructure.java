package com.example.isacclee.firsthello;

import java.util.ArrayList;

/**
 * Created by Swallow on 2017/7/11.
 * Just structure.
 */

class GoodsStructure {
    private String goodsID;
    private String goodsName;
    private String description;
    private Double price;
    private String picture;
    private static ArrayList<String> goodsList;

    static ArrayList<String> getGoodsList() {
        return goodsList;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getPicture() {
        return picture;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public static void setGoodsList(ArrayList<String> goodsList) {
        GoodsStructure.goodsList = goodsList;
    }

    static void clearGoodsList(){
        GoodsStructure.goodsList.clear();
    }

    static void addGoodsList(String goodsID){
        GoodsStructure.goodsList.add(goodsID);
    }

    void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    void setPicture(String picture) {
        this.picture = picture;
    }

    void setPrice(Double price) {
        this.price = price;
    }
}
