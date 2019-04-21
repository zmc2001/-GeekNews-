package com.example.admin.day03_zuoye_one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.bean.WomenBean;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/19.
 */

public class WomenRlvAdapter extends RecyclerView.Adapter<WomenRlvAdapter.MyHolder> {
    private Context context;
    private ArrayList<WomenBean.ResultsBean> mList;

    public WomenRlvAdapter(Context context, ArrayList<WomenBean.ResultsBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_gank_women, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        WomenBean.ResultsBean bean = mList.get(position);
        Glide.with(context).load(bean.getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        public MyHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_gank_women_img);
        }
    }
}
