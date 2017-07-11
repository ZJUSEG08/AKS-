package com.example.isacclee.firsthello;

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

    private class newGoods{
        public String goodsID;
    }
    private static newGoods[] goodsList;

    static newGoods[] getGoodsList() {
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

    public static void setGoodsList(newGoods[] goodsList) {
        GoodsStructure.goodsList = goodsList;
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
