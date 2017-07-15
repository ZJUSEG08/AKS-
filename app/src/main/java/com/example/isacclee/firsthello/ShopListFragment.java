package com.example.isacclee.firsthello;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ShopListFragment extends Fragment implements AdapterView.OnItemClickListener{
    private FragmentManager fManager;
    private List<GoodsStructure> datas;
    private ListView list_shops;

    public ShopListFragment() {
        // Required empty public constructor
    }
//    public OrderListFragment(FragmentManager fManager, ArrayList<Data> datas) {
//        this.fManager = fManager;
//        this.datas = datas;
//    }
    public static ShopListFragment newInstance(FragmentManager fManager, ArrayList<GoodsStructure> datas){
        ShopListFragment f = new ShopListFragment();
        f.fManager = fManager;
        f.datas = datas;
        return f;
    }

    private void initViews(View view){
        list_shops = view.findViewById(R.id.list_shops);
        Bundle bundle = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        list_shops = (ListView) view.findViewById(R.id.list_order);
//        GoodsAdapter goodsAdapter = new GoodsAdapter(datas, getActivity());
//        list_shops.setAdapter(goodsAdapter);
        list_shops.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        FragmentTransaction fTransaction = fManager.beginTransaction();
//        ShopInfoFragment siFragment;
//        siFragment = new ShopInfoFragment();
//        Bundle bd = new Bundle();
////        bd.putString("state", datas.get(position).state);
//        siFragment.setArguments(bd);
//        //获取Activity的控件
//        TextView txt_title = (TextView) getActivity().findViewById(R.id.shops_item_title);
//        txt_title.setText(datas.get(position).getGoodsID());
//        //加上Fragment替换动画
//        fTransaction.setCustomAnimations(R.animator.fragment_slide_left_enter, R.animator.fragment_slide_left_exit);
//        fTransaction.replace(R.id.sl_content, siFragment);
//        //调用addToBackStack将Fragment添加到栈中
//        fTransaction.addToBackStack(null);
//        fTransaction.commit();
    }

}
