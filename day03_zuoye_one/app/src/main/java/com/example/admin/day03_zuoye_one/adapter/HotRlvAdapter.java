package com.example.admin.day03_zuoye_one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.bean.HotBean;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/17.
 */

public class HotRlvAdapter extends RecyclerView.Adapter<HotRlvAdapter.MyHolder> {
    private Context context;
    private ArrayList<HotBean.RecentBean> mList;
    public HotRlvAdapter(Context context, ArrayList<HotBean.RecentBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hot, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        HotBean.RecentBean recentBean = mList.get(position);
        Glide.with(context).load(recentBean.getThumbnail()).into(holder.img);
        holder.tv.setText(recentBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_hot_img);
            tv = itemView.findViewById(R.id.item_hot_tv);
        }
    }
}
