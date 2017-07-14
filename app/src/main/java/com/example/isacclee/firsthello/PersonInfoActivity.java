package com.example.isacclee.firsthello;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonInfoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TextView txt_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
//navigation
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view3);
        navigationView.setNavigationItemSelectedListener(this);

        FileCacheUtil fileCacheUtil = new FileCacheUtil();
        String email = fileCacheUtil.getCache(getApplicationContext(),FileCacheUtil.userInfo);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.inflateHeaderView(R.layout.nav_header_main);
        txt_title = (TextView) header.findViewById(R.id.email_name);
        txt_title.setText(email);

        Button mEditInfoButton = (Button) findViewById(R.id.button2);
        mEditInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JumpToEdit();
            }
        });
        Button mPayInButton = (Button) findViewById(R.id.button3);
        mPayInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        Button mContackButton = (Button) findViewById(R.id.button4);
        mContackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });
        Button mLogOutButton = (Button) findViewById(R.id.button5);
        mLogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JumpToLogin();
            }
        });
    }
    protected void dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(PersonInfoActivity.this);
        builder.setMessage("关注微信31239594联系客服");
        builder.setTitle("客服");
        builder.setPositiveButton("明白", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
            }
        });
        builder.create().show();
    }

    protected void JumpToLogin(){
        Intent intent = new Intent();
        intent.setClass(PersonInfoActivity.this,LoginActivity.class);

        FileCacheUtil fileCacheUtil = new FileCacheUtil();
        fileCacheUtil.setCache("null",getApplicationContext(),FileCacheUtil.userInfo,MODE_PRIVATE);
        startActivity(intent);
    }
    protected void JumpToEdit(){
        Intent intent = new Intent();
        intent.setClass(PersonInfoActivity.this,EditPersonActivity.class);

        startActivity(intent);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.order_icon) {
            Intent intent = new Intent();
            intent.setClass(PersonInfoActivity.this,MainActivity.class );

            startActivity(intent);
        } else if (id == R.id.search_icon) {
            Intent intent = new Intent();
            intent.setClass(PersonInfoActivity.this,SearchActivity.class );

            startActivity(intent);
        } else if (id == R.id.personal_icon) {
            Intent intent = new Intent();
            intent.setClass(PersonInfoActivity.this,PersonInfoActivity.class );

            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
