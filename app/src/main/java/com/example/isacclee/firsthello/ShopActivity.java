package com.example.isacclee.firsthello;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    /**
     * 新闻列表请求接口
     */
    public static final String URL = "http://v.juhe.cn/toutiao/index?type=top&key=a1a755458cc22f129942b34904feb820";

    /**
     * ListView对象
     */
    private ListView listView;

    /**
     * 新闻集合对象
     */
    private ArrayList<GoodsStructure> datas;

    /**
     * 自定义的Adapter对象
     */
    private  ShopAdapter adapter;
    public Controller controller = new Controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        listView = (ListView) findViewById(R.id.shops_list);



        datas = controller.GoodsInfo(this);
        Toast.makeText(this,"Goods",Toast.LENGTH_LONG).show();
        Controller controller = new Controller();

        /**
         * 实例化Adapter对象(注意:必须要写在在getDatas() 方法后面,不然datas中没有数据)
         */
        adapter = new ShopAdapter(this, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ShopActivity.this,"第"+datas.get(position).toString()+"个被选中",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShopActivity.this,DeviceConfigureActivity.class);
                intent.putExtra("goodsId",datas.get(position).getGoodsID());
//                setResult(RESULT_OK,intent);
                startActivity(intent);
            }
        });

    }

    protected void OnListItemClick(ListView l, View V, int position,long id){
        Log.v("Click",(String)datas.get(position).getGoodsName());
    }
}