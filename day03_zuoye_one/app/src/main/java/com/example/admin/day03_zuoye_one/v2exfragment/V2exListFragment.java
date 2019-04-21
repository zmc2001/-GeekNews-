package com.example.admin.day03_zuoye_one.v2exfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.adapter.V2exListRlvAdapter;
import com.example.admin.day03_zuoye_one.base.BaseFragment;
import com.example.admin.day03_zuoye_one.bean.V2exListBean;
import com.example.admin.day03_zuoye_one.pressert.EmptyP;
import com.example.admin.day03_zuoye_one.view.EmptyV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;

public class V2exListFragment extends BaseFragment<EmptyV, EmptyP> implements EmptyV {

    private static final String TAG = "V2exListFragment";
    @BindView(R.id.v2ex_list_rlv)
    RecyclerView v2exListRlv;
    private String mLink;
    private ArrayList<V2exListBean> mList1;
    private ArrayList<V2exListBean> mList2;
    private V2exListRlvAdapter mV2exListRlvAdapter;

    @Override
    protected EmptyP initPressert() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2ex_list;
    }

    @Override
    protected void initView() {
        super.initView();
        getData();
        mList1 = new ArrayList<>();
        mList2 = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        v2exListRlv.setLayoutManager(linearLayoutManager);
        mV2exListRlvAdapter = new V2exListRlvAdapter(getActivity(), mList1);
        v2exListRlv.setAdapter(mV2exListRlvAdapter);
    }

    private void getData() {
        Bundle arguments = getArguments();
        mLink = arguments.getString("type");
    }

    private String url = "https://www.v2ex.com/?tab=";

    @Override
    protected void initData() {
        super.initData();
        new Thread(new Runnable() {

            private String mTopic;
            private String mCount;
            private String mTitle;
            private String mImg;

            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(url + mLink).get();
                    if (document != null) {
                        Elements elements = document.select("div.cell.item");
                        for (Element element : elements) {
                            Elements imgs = element.select("table tr td img.avatar");
                            if (imgs.size() > 0) {
                                mImg = imgs.get(0).attr("src");
                            }
                            Elements titles = element.select("table tr td span.item_title");
                            if (titles.size() > 0) {
                                mTitle = titles.get(0).text();
                            }
                            Elements counts = element.select("table tr td a.count_livid");
                            if (counts.size() > 0) {
                                mCount = counts.get(0).text();
                            }
                            Elements topics = element.select("table tr td span.topic_info");
                            if (topics.size() > 0) {
                                mTopic = topics.get(0).text();
                                String[] split = mTopic.split(" • ");
                                if (split.length > 2) {
                                    V2exListBean v2ex_ariticle_bean = new V2exListBean(mImg, split[1], split[2], split[0], mTitle, mCount);
                                    mList2.add(v2ex_ariticle_bean);
                                    Log.d(TAG, "run: " + v2ex_ariticle_bean.toString());
                                }
                            }
                            Log.d(TAG, "run: " + mTopic);
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mList1.addAll(mList2);
                                mV2exListRlvAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        mV2exListRlvAdapter.notifyDataSetChanged();
    }

    public static V2exListFragment newInstance(String type) {
        V2exListFragment ariticleFragment = new V2exListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        ariticleFragment.setArguments(bundle);
        return ariticleFragment;
    }
}
