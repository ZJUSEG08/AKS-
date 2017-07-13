package com.example.isacclee.firsthello;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<GoodsStructure> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Controller controller = new Controller();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mContext = ShopActivity.this;
        fManager = getFragmentManager();
        bindViews();

//        OrderListFragment olFragment = new OrderListFragment(fManager, datas);
        ShopListFragment slFragment = ShopListFragment.newInstance(fManager, datas);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_content, slFragment);//这里搞不好会找不到这个类,Mark 一下
        ft.commit();
    }
    private void bindViews() {
        txt_title = (TextView) findViewById(R.id.order_item_title);
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (fManager.getBackStackEntryCount() == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            fManager.popBackStack();
            txt_title.setText("商城列表");
        }
    }
}
