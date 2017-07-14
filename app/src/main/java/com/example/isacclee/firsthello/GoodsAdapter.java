package com.example.isacclee.firsthello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Isacclee on 7/9/17.
 */

public class GoodsAdapter extends BaseAdapter{
    private ArrayList<GoodsStructure> mData;

    private Context mContext;

    public GoodsAdapter(ArrayList<GoodsStructure> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.shops_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.shops_item_title = (TextView) convertView.findViewById(R.id.shops_item_title);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.shops_item_title.setText(mData.get(position).getGoodsName());
        return convertView;
    }
    private class ViewHolder{
        TextView shops_item_title;
    }

}
