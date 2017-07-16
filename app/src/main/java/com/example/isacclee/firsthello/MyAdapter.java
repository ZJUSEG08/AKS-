package com.example.isacclee.firsthello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isacclee on 7/9/17.
 */

public class MyAdapter extends BaseAdapter{
    private List<OrderStructure> mData = new ArrayList<OrderStructure>();

    private Context mContext;
    private LayoutInflater layoutInflater;

    public MyAdapter(ArrayList<OrderStructure> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mData.size();

    }
    //TO DO: 可能要改
    @Override
    public OrderStructure getItem(int position) {
        return mData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.order_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.order_item_title = (TextView) convertView.findViewById(R.id.order_item_title);
            viewHolder.date =(TextView)convertView.findViewById(R.id.tv_date);
            viewHolder.pic = (ImageView)convertView.findViewById(R.id.iv_img2);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.order_item_title.setText(mData.get(position).orderID);
        initViews(getItem(position), (ViewHolder) convertView.getTag());

        return convertView;
    }

    private void initViews(OrderStructure data,ViewHolder holder){
        holder.pic.setTag(data.goodsID);
        GoodsStructure goodsStructure = new Controller().GoodsInfo(this.mContext,data.goodsID);
        holder.order_item_title.setText(goodsStructure.getGoodsName());
        holder.date.setText(data.state);
    }
    public class ViewHolder{
        TextView order_item_title;
        TextView date;
        ImageView pic;
    }

}
