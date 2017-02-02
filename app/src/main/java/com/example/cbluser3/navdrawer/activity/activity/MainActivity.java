package com.example.cbluser3.navdrawer.activity.activity;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.cbluser3.navdrawer.R;
import com.example.cbluser3.navdrawer.activity.adapter.DrawerItemAdapter;
import com.example.cbluser3.navdrawer.activity.model.DrawerModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    public DrawerLayout drawerLayout;
    RecyclerView rvRightList;
    RecyclerView rvLeftList;
    List<DrawerModel> drawerModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        rvLeftList=(RecyclerView) findViewById(R.id.lvLeft_drawer);


        drawerModelList.add(new DrawerModel("Home",R.drawable.logo_adidas));
        drawerModelList.add(new DrawerModel("Content",R.drawable.logo_aerie));
        drawerModelList.add(new DrawerModel("Other",R.drawable.logo_alamo));
        drawerModelList.add(new DrawerModel("Contact",R.drawable.logo_aeropostale));

        DrawerItemAdapter adapter=new DrawerItemAdapter(this,drawerModelList);
        rvLeftList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvLeftList.setAdapter(adapter);


        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,0,0)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        else{
            drawerLayout.openDrawer(GravityCompat.END);
        }



        return super.onOptionsItemSelected(item);
    }
}
