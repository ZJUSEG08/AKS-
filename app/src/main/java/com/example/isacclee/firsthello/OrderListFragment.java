package com.example.isacclee.firsthello;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class OrderListFragment extends Fragment implements AdapterView.OnItemClickListener{

    private FragmentManager fManager;
    private ArrayList<OrderStructure> datas;
    private ListView list_orders;

    public OrderListFragment() {
        // Required empty public constructor
    }

    public static OrderListFragment newInstance(FragmentManager fManager, ArrayList<OrderStructure> datas){
        OrderListFragment f = new OrderListFragment();
        f.fManager = fManager;
        f.datas = datas;
        return f;
    }

    private void initViews(View view){
        list_orders = view.findViewById(R.id.list_order);
        Bundle bundle = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        list_orders = (ListView) view.findViewById(R.id.list_order);

        Controller controller = new Controller();
        datas = new ArrayList<OrderStructure>(10);
        String email = "1111@";
        controller.OrderList(email,datas);
        System.out.print(datas);
        MyAdapter myAdapter = new MyAdapter(datas, getActivity());
        list_orders.setAdapter(myAdapter);
        list_orders.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        OrderInfoFragment oiFragment;
        oiFragment = new OrderInfoFragment();
        Bundle bd = new Bundle();

        Controller controller = new Controller();

        bd.putString("name", datas.get(position).goodsID);
        bd.putString("OrderInfo", "订单编号："+datas.get(position).orderID+"\n创建时间:"+datas.get(position).creatingTime+"\n发货时间："+datas.get(position).sendingTime+"\n收货人："+datas.get(position).receiver+"\n收货地址："+datas.get(position).address);

//        bd.putString("price", datas.get(position).price);
        bd.putString("price", "100yuan");
//        bd.putString("ExpressID", datas.get(position).getName());
        bd.putString("ExpressID", "129f");
//        bd.putString("ExpressState", datas.get(position).getName());
        bd.putString("ExpressState", "I'm fine fuck u");

        oiFragment.setArguments(bd);
        //获取Activity的控件
        TextView txt_title = (TextView) getActivity().findViewById(R.id.order_item_title);
        txt_title.setText(datas.get(position).state);
//        加上Fragment替换动画
        fTransaction.setCustomAnimations(R.animator.fragment_slide_left_enter, R.animator.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_content, oiFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }

}
