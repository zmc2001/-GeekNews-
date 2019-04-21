package com.example.admin.day03_zuoye_one.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.V2exVpAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.pressert.V2exP;
import com.example.admin.day03_zuoye_one.v2exfragment.V2exListFragment;
import com.example.admin.day03_zuoye_one.view.V2exV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by admin on 2019/4/3.
 * 1808A邢鑫鑫
 */

public class V2exFragment extends BaseFragment<V2exV, V2exP> implements V2exV {
    private static final String TAG = "V2exFragment";
    @BindView(R.id.v2ex_tab)
    TabLayout v2exTab;
    @BindView(R.id.v2ex_img)
    ImageView v2exImg;
    @BindView(R.id.v2ex_vp)
    ViewPager v2exVp;
    private String url = "https://www.v2ex.com/";

    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitle;
    private ArrayList<String> mType;
    private String mAntor;

    @Override
    protected V2exP initPressert() {
        return new V2exP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2ex;
    }

    @Override
    protected void initView() {
        super.initView();
        mTitle = new ArrayList<>();
        mType = new ArrayList<>();
        mType.add("tech");
        mType.add("creative");
        mType.add("play");
        mType.add("apple");
        mType.add("jobs");
        mType.add("deals");
        mType.add("city");
        mType.add("qna");
        mType.add("hot");
        mType.add("all");
        mType.add("r2");
        initTab();
    }

    private void initTab() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Document document = Jsoup.connect(url).get();
                    //class等于masthead的div标签
                    Element tabs = document.select("div#Tabs").first();
                    Elements allTabls = tabs.select("a[href]");
                    for (Element element : allTabls) {
                        //获取href属性
                        String href = element.attr("href");
                        //获取标签里的文本
                        String linkText = element.text();
                        mTitle.add(linkText);
                    }
                    initFragment(mTitle);


                    //新闻item数据
                    Elements items = document.select("div.cell.item");
                    for (Element item :items) {
                        //图片
                        Element image = item.select("table tr td a > img.avatar").first();
                        String src = image.attr("src");
                        Log.d(TAG, "src: "+src);

                        //评论数量和评论链接地址1808A邢鑫鑫
                        Element comment = item.select("table tbody tr td a.count_livid").first();
                        if (comment != null) {
                            String href = comment.attr("href");
                            String text = comment.text();
                            //Log.d(TAG, "评论: "+",链接:"+href+",数量:"+text);
                        }
                        //标题
                        Element title = item.select("table tbody tr td span.item_title > a").first();
                        String text = title.text();
                        Log.d(TAG, "标题: " + text);

                        //topic_info
                        Element topic = item.select("table tbody tr td span.topic_info").first();
                        Element secondaryTab = topic.select("a.node").first();
                        String secTab = secondaryTab.text();
                        Log.d(TAG, "secTab: " + secTab);

                        String topicText = topic.text();
                        Log.d(TAG, "topicText: " + topicText);

                        Elements people = topic.select("strong > a");
                        if (people.size() > 0) {
                            //作者
                            Element element = people.get(0);
                            mAntor = element.text();
                            Log.d(TAG, "作者: " + element.text());
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void initFragment(final ArrayList<String> title) {
        Log.d(TAG, "initFragment: "+title);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mFragments = new ArrayList<>();
                for (int i = 0; i < title.size(); i++) {
                    V2exListFragment ariticleFragment = V2exListFragment.newInstance(mType.get(i));
                    mFragments.add(ariticleFragment);
                }
                V2exVpAdapter v2exVpAdapter = new V2exVpAdapter(getChildFragmentManager(), mFragments, mTitle);
                v2exVp.setAdapter(v2exVpAdapter);
                v2exTab.setupWithViewPager(v2exVp);
            }
        });
    }
}
