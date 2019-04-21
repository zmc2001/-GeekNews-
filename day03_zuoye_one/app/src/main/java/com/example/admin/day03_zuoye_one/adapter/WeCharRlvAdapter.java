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
import com.example.admin.day03_zuoye_one.bean.WeCharBean;

import java.util.ArrayList;

/**
 * 1808A邢鑫鑫
 * Created by admin on 2019/4/18.
 */

public class WeCharRlvAdapter extends RecyclerView.Adapter<WeCharRlvAdapter.MyHolder> {
    private Context context;
    private ArrayList<WeCharBean.NewslistBean> mList;
    public WeCharRlvAdapter(Context context, ArrayList<WeCharBean.NewslistBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_wechar, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        WeCharBean.NewslistBean bean = mList.get(position);
        Glide.with(context).load(bean.getPicUrl()).into(holder.img);
        holder.tv1.setText(bean.getTitle());
        holder.tv2.setText(bean.getDescription());
        holder.tv3.setText(bean.getCtime());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        public MyHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_wechar_img);
            tv1 = itemView.findViewById(R.id.item_wechar_tv1);
            tv2 = itemView.findViewById(R.id.item_wechar_tv2);
            tv3 = itemView.findViewById(R.id.item_wechar_tv3);
        }
    }
}
