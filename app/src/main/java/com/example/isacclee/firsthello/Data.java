package com.example.isacclee.firsthello;

/**
 * Created by Isacclee on 7/9/17.
 */

public class Data {
    private String goods_title;
    private String order_state;
    private int order_count;
    private int order_id;
    public Data(){}
    public Data(String goods_title, String order_state, int order_count,int order_id) {
        this.goods_title = goods_title;
        this.order_count = order_count;
        this.order_id = order_id;
        this.order_state = order_state;
    }
    public String getGoods_title() {
        return goods_title;
    }
    public String getOrder_state() {
        return order_state;
    }
//    public void setNew_title(String new_title) {
//        this.new_title = new_title;
//    }
//    public void setNew_content(String new_content) {
//        this.new_content = new_content;
//    }
}
