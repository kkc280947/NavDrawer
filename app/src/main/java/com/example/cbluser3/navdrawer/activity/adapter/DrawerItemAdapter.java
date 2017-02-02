package com.example.cbluser3.navdrawer.activity.adapter;

import android.support.v4.view.GravityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cbluser3.navdrawer.R;
import com.example.cbluser3.navdrawer.activity.activity.MainActivity;
import com.example.cbluser3.navdrawer.activity.fragments.FirstFragment;
import com.example.cbluser3.navdrawer.activity.model.DrawerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 2/2/17.
 */
public class DrawerItemAdapter extends RecyclerView.Adapter<DrawerItemAdapter.RecyclerViewHoler> {

    MainActivity activity;
    List<DrawerModel> drawerModelList=new ArrayList<>();

    public DrawerItemAdapter(MainActivity activity, List<DrawerModel> drawerModelList) {
        this.activity=activity;
        this.drawerModelList=drawerModelList;

    }

    @Override
    public RecyclerViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHoler(LayoutInflater.from(activity).inflate(R.layout.item_drawer,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHoler holder, int position) {
        holder.tvName.setText(drawerModelList.get(position).menu);
        holder.ivBimage.setImageResource(drawerModelList.get(position).menuImage);
    }

    @Override
    public int getItemCount() {
        return drawerModelList.size();
    }

    public class RecyclerViewHoler extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivBimage;

        public RecyclerViewHoler(View itemView) {
            super(itemView);
            ivBimage=(ImageView)itemView.findViewById(R.id.ivBimage);
            tvName=(TextView)itemView.findViewById(R.id.tvName);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                switch (getAdapterPosition()){


                    case 1:
                        FirstFragment fragment1=new FirstFragment();
                        activity.getSupportFragmentManager().beginTransaction().add(R.id.flFrame,fragment1,"").commit();
                        activity.drawerLayout.closeDrawer(GravityCompat.START);

                }
                }
            });
        }
    }
}
