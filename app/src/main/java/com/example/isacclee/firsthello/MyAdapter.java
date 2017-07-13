package com.example.isacclee.firsthello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Isacclee on 7/9/17.
 */

public class MyAdapter extends BaseAdapter{
    private List<OrderStructure> mData;

    private Context mContext;

    public MyAdapter(List<OrderStructure> mData, Context mContext) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.order_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.order_item_title = (TextView) convertView.findViewById(R.id.order_item_title);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.order_item_title.setText(mData.get(position).orderID);
        return convertView;
    }
    private class ViewHolder{
        TextView order_item_title;
    }

}
