package com.example.isacclee.firsthello;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<OrderStructure> datas = null;
    private FragmentManager fManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Controller controller = new Controller();
        OrderStructure orderStructure = new OrderStructure();
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

        String email = new String("LGD");
//        email = getEmail();
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.inflateHeaderView(R.layout.nav_header_main);

        txt_title = (TextView) header.findViewById(R.id.email_name);
        txt_title.setText(email);


        //list part
        mContext = MainActivity.this;
        fManager = getFragmentManager();
        bindViews();



        int count = controller.OrderList(email,datas);
//        OrderListFragment olFragment = new OrderListFragment(fManager, datas);
        OrderListFragment olFragment = OrderListFragment.newInstance(fManager, datas);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_content, olFragment);
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
        } else {
            super.onBackPressed();
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
