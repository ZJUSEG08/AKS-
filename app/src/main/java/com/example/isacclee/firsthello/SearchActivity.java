package com.example.isacclee.firsthello;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.Thread.sleep;

public class SearchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TextView txt_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        //navigation
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);

        FileCacheUtil fileCacheUtil = new FileCacheUtil();
        String email = fileCacheUtil.getCache(getApplicationContext(),FileCacheUtil.userInfo);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        txt_title = (TextView) header.findViewById(R.id.email_name);
        txt_title.setText(email);

//        while (true) {
//
//            try {
//                sleep(2000);
//                int i = 0;
//                if(i == 1) {
//                    Intent intent = new Intent();
//                    intent.setClass(SearchActivity.this, DeviceConfigureActivity.class);
//                    startActivity(intent);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }



    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.order_icon) {
            Intent intent = new Intent();
            intent.setClass(SearchActivity.this,MainActivity.class );

            startActivity(intent);
        } else if (id == R.id.search_icon) {
            Intent intent = new Intent();
            intent.setClass(SearchActivity.this,SearchActivity.class );

            startActivity(intent);
        } else if (id == R.id.personal_icon) {
            Intent intent = new Intent();
            intent.setClass(SearchActivity.this,PersonInfoActivity.class );

            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
