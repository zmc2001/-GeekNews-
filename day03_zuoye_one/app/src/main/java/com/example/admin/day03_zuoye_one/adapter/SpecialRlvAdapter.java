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
import com.example.admin.day03_zuoye_one.bean.SpecialBean;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/17.
 */

public class SpecialRlvAdapter extends RecyclerView.Adapter<SpecialRlvAdapter.MyHolder> {
    private Context context;
    private ArrayList<SpecialBean.DataBean> mList;

    public SpecialRlvAdapter(Context context, ArrayList<SpecialBean.DataBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_special, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        SpecialBean.DataBean bean = mList.get(position);
        Glide.with(context).load(bean.getThumbnail()).into(holder.img);
        holder.tv1.setText(bean.getDescription());
        holder.tv2.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv1;
        private TextView tv2;
        public MyHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_special_img);
            tv1 = itemView.findViewById(R.id.item_special_tv1);
            tv2 = itemView.findViewById(R.id.item_special_tv2);
        }
    }
}
