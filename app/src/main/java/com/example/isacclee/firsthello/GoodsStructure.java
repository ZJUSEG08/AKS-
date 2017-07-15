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
    private ArrayList<String> goodsList;


    ArrayList<String> getGoodsList() {
        return goodsList;
    }

    Double getPrice() {
        return price;
    }

    String getDescription() {
        return description;
    }

    String getGoodsID() {
        return goodsID;
    }

    String getGoodsName() {
        return goodsName;
    }

    String getPicture() {
        return picture;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    void setGoodsList(ArrayList<String> goodsList) {
        this.goodsList = goodsList;
    }

    void clearGoodsList(){
        goodsList.clear();
    }

    void addGoodsList(String goodsID){
        goodsList.add(goodsID);
    }

    boolean isEmptyGoodsList(){
        return goodsList == null;
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
