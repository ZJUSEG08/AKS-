package com.example.isacclee.firsthello;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    public static ArrayList<OrderStructure> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;
    private ListView listView;
    public MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Controller controller = new Controller();
        //set view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //navigation
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //email part
        String email = new String("1111@");
        FileCacheUtil fileCacheUtil = new FileCacheUtil();
//        String email = fileCacheUtil.getCache(getApplicationContext(),FileCacheUtil.userInfo);
//        String email =
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.inflateHeaderView(R.layout.nav_header_main);
        txt_title = (TextView) header.findViewById(R.id.email_name);
        txt_title.setText(email);


        //list part
        listView =(ListView)findViewById(R.id.order_list);
        datas = new ArrayList<OrderStructure>();
//        for (int i =0 ; i < 5; i++){
//            OrderStructure orderStructure = new OrderStructure();
//            orderStructure.creatingTime = ("1997年");
//            orderStructure.goodsID = "500";
//            datas.add(orderStructure);
//        }
//        Toast.makeText(this,"Order",Toast.LENGTH_LONG).show();
//        controller.OrderList(email,datas);
        OrderStructure orderStructure = new OrderStructure();
        orderStructure.creatingTime="2017-07-16.00.01.25";
        orderStructure.goodsID ="00001";
        orderStructure.number =1;
        orderStructure.statesList=new OrderStructure.States[1];
        orderStructure.state = "???";
        orderStructure.numOfStates = 1;
        orderStructure.address="ZJU";
        orderStructure.orderID="0000112341";
        orderStructure.receiver= "LYJ";
        orderStructure.sendingTime = "2017-07-16.20.50.40";
        orderStructure.expressID="12341234";
        orderStructure.supplier="顺风快递";
        datas.add(orderStructure);

        OrderStructure orderStructure2 = new OrderStructure();
        orderStructure2.creatingTime="2017-07-16";
        orderStructure2.goodsID ="00002";
        datas.add(orderStructure2);
        adapter = new MyAdapter(datas,this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(),OrderDetailActivity.class);
                intent.putExtra("data_position",position);
                view.getContext().startActivity(intent);

            }
        });
    }

    private void bindViews() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.order_item,null);
        View view2 = LayoutInflater.from(mContext).inflate(R.layout.content_main,null);
        txt_title = (TextView) view.findViewById(R.id.order_item_title);//order_item . xml
//        fl_content = (FrameLayout) view2.findViewById(R.id.fl_content);//content_main.xml

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
            txt_title.setText("订单列表");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.order_icon) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MainActivity.class );

            startActivity(intent);
        } else if (id == R.id.search_icon) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,SearchActivity.class );

            startActivity(intent);
        } else if (id == R.id.personal_icon) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,PersonInfoActivity.class );

            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
