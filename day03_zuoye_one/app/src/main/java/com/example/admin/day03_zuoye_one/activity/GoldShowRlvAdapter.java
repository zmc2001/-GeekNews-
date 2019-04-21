package com.example.admin.day03_zuoye_one.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.bean.GoldBean;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/18.
 */

public class GoldShowRlvAdapter extends RecyclerView.Adapter<GoldShowRlvAdapter.MyHolder> {
    private Context context;
    private ArrayList<GoldBean> mList;

    public GoldShowRlvAdapter(Context context, ArrayList<GoldBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_gold_show, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final GoldBean goldBean = mList.get(position);
        holder.tv.setText(goldBean.title);
        holder.sc.setChecked(goldBean.isCheck);
        holder.sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goldBean.isCheck = isChecked;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private SwitchCompat sc;
        public MyHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_gold_show_tv);
            sc = itemView.findViewById(R.id.item_gold_show_sc);
        }
    }
}
