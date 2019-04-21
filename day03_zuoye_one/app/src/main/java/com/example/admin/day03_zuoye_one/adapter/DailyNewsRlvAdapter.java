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
import com.bumptech.glide.request.RequestOptions;
import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.bean.DailyNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by admin on 2019/4/17.
 */

public class DailyNewsRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    RequestOptions requestOptions = new RequestOptions().circleCrop();
    private String mData = "今日要闻";
    private Context context;
    ArrayList<DailyNewsBean.StoriesBean> storiesBeans = new ArrayList<>();
    ArrayList<DailyNewsBean.TopStoriesBean> topStoriesBeans = new ArrayList<>();
    public DailyNewsRlvAdapter(Context context, ArrayList<DailyNewsBean.StoriesBean> storiesBeans, ArrayList<DailyNewsBean.TopStoriesBean> topStoriesBeans) {
        this.context = context;
        this.storiesBeans = storiesBeans;
        this.topStoriesBeans = topStoriesBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_top, null);
            holder = new BannerHolder(inflate);
        }else if (viewType==2){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_time, null);
            holder = new TextHolder(inflate);
        }else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_list, null);
            holder = new ItemHolder(inflate);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();
        if (itemViewType==1){
            BannerHolder bannerHolder = (BannerHolder) holder;
            bannerHolder.banner.setImages(topStoriesBeans)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            DailyNewsBean.TopStoriesBean bean = (DailyNewsBean.TopStoriesBean) path;
                            Glide.with(context).load(bean.getImage()).apply(requestOptions).into(imageView);
                        }
                    })
                    .start();
        }else if (itemViewType==2){
            TextHolder textHolder = (TextHolder) holder;
            textHolder.tv.setText(mData);
        }else {
            int newPoistion = position-1;
            if (topStoriesBeans.size()>0){
                newPoistion -= 1;
            }
            DailyNewsBean.StoriesBean storiesBean = storiesBeans.get(newPoistion);
            ItemHolder itemHolder = (ItemHolder) holder;
            Glide.with(context).load(storiesBean.getImages().get(0)).apply(requestOptions).into(itemHolder.img);
            itemHolder.tv.setText(storiesBean.getTitle());
        }
    }

    public void setData(DailyNewsBean bean) {
        mData = bean.getDate();
        topStoriesBeans.clear();
        if (bean.getTop_stories() != null && bean.getTop_stories().size()>0){
            topStoriesBeans.addAll(bean.getTop_stories());
        }

        storiesBeans.clear();
        if (bean.getStories() != null && bean.getStories().size()>0){
            storiesBeans.addAll(bean.getStories());
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (topStoriesBeans.size()>0){
            return 1+1+storiesBeans.size();
        }else {
            return 1+storiesBeans.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (topStoriesBeans.size()>0){
            if (position == 0){
                return 1;
            }else if (position == 1){
                return 2;
            }else {
                return 3;
            }
        }else {
            if (position == 0){
                return 1;
            }else {
                return 2;
            }
        }
    }

    class BannerHolder extends RecyclerView.ViewHolder {
        private Banner banner;
        public BannerHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class TextHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public TextHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_time);
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        public ItemHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_list_img);
            tv = itemView.findViewById(R.id.item_list_tv);
        }
    }
}
