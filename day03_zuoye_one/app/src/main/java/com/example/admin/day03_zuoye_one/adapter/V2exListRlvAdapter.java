package com.example.admin.day03_zuoye_one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.bean.V2exListBean;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/21.
 */

public class V2exListRlvAdapter extends RecyclerView.Adapter<V2exListRlvAdapter.MyHolder> {
    private static final String TAG = "V2exListRlvAdapter";
    private Context context;
    private ArrayList<V2exListBean> mList;

    public V2exListRlvAdapter(Context context, ArrayList<V2exListBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_v2ex_list, null);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        MyHolder holder1 = (MyHolder) holder;
        V2exListBean bean = mList.get(position);
        Log.d(TAG, "onBindViewHolder: "+bean.antor);
        holder1.mAuthor.setText(bean.antor);
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher);
        Log.d(TAG, "onBindViewHolder: "+bean.img);
        Glide.with(context).load("https:"+bean.img).apply(options).into(holder1.img);
        holder1.mCount.setText(bean.count);
        holder1.mSecondTab.setText(bean.secoudTab);
        holder1.mTime.setText(bean.time);
        holder1.mTitle.setText(bean.title);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView mAuthor;
        private final ImageView img;
        private final TextView mTime;
        private final TextView mTitle;
        private final TextView mSecondTab;
        private final TextView mCount;
        public MyHolder(View itemView) {
            super(itemView);
            mAuthor = itemView.findViewById(R.id.author);
            img = itemView.findViewById(R.id.img);
            mTime = itemView.findViewById(R.id.time);
            mTitle = itemView.findViewById(R.id.title);
            mSecondTab = itemView.findViewById(R.id.secondTab);
            mCount = itemView.findViewById(R.id.count);
        }
    }
}
