package com.example.admin.day03_zuoye_one.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.admin.day03_zuoye_one.R;
import com.example.admin.day03_zuoye_one.base.BaseActivity;
import com.example.admin.day03_zuoye_one.fragment.AboutFragment;
import com.example.admin.day03_zuoye_one.fragment.CollectFragment;
import com.example.admin.day03_zuoye_one.fragment.GankFragment;
import com.example.admin.day03_zuoye_one.fragment.GoldFragment;
import com.example.admin.day03_zuoye_one.fragment.SettingFragment;
import com.example.admin.day03_zuoye_one.fragment.V2exFragment;
import com.example.admin.day03_zuoye_one.fragment.WeChatFragment;
import com.example.admin.day03_zuoye_one.fragment.ZhiHuFragment;
import com.example.admin.day03_zuoye_one.pressert.MainP;
import com.example.admin.day03_zuoye_one.view.MainV;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;

//1808A邢鑫鑫
public class MainActivity extends BaseActivity<MainV,MainP> implements MainV {
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.nav)
    NavigationView nav;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.search_view)
    MaterialSearchView search_view;

    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;
    private FragmentManager manager;
    private int position;
    private MenuItem mOptionsitem;

    @Override
    protected MainP initPressert() {
        return new MainP();
    }

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();

        tb.setTitle("");
        tb.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(tb);

        nav.setItemIconTintList(null);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, dl, tb, R.string.cg, R.string.sb);
        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        initFragments();
        initTitls();
        addZhiHuFragment();

        search_view.setVoiceSearch(true); //or false
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void addZhiHuFragment() {
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.fl,fragments.get(0));
        ft.commit();
        tb.setTitle(titles.get(0));
    }

    private void initTitls() {
        titles = new ArrayList<>();
        titles.add(R.string.zhihu);
        titles.add(R.string.wechat);
        titles.add(R.string.gank);
        titles.add(R.string.gold);
        titles.add(R.string.v2ex);
        titles.add(R.string.collect);
        titles.add(R.string.settings);
        titles.add(R.string.about);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiHuFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new V2exFragment());
        fragments.add(new CollectFragment());
        fragments.add(new SettingFragment());
        fragments.add(new AboutFragment());
    }

    @Override
    protected void initListener() {
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId != R.id.info_title && itemId != R.id.options_title ){
                    item.setChecked(true);
                    switch (itemId){
                        case R.id.zhihu:
                            switchFragments(0);
                            tb.setTitle(titles.get(0));
                            break;
                        case R.id.wechat:
                            switchFragments(1);
                            tb.setTitle(titles.get(1));
                            break;
                        case R.id.gank:
                            switchFragments(2);
                            tb.setTitle(titles.get(2));
                            break;
                        case R.id.gold:
                            switchFragments(3);
                            tb.setTitle(titles.get(3));
                            break;
                        case R.id.v2ex:
                            switchFragments(4);
                            tb.setTitle(titles.get(4));
                            break;
                        case R.id.collect:
                            switchFragments(5);
                            tb.setTitle(titles.get(5));
                            break;
                        case R.id.settings:
                            switchFragments(6);
                            tb.setTitle(titles.get(6));
                            break;
                        case R.id.about:
                            switchFragments(7);
                            tb.setTitle(titles.get(7));
                            break;
                    }
                    dl.closeDrawer(nav);
                }
                return false;
            }
        });

        search_view.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        search_view.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
    }

    private void switchFragments(int i) {
        Fragment fragment = fragments.get(i);
        FragmentTransaction ff = manager.beginTransaction();
        if (!fragment.isAdded()){
            ff.add(R.id.fl,fragment);
        }

        ff.hide(fragments.get(position));
        ff.show(fragment);
        ff.commit();
        position=i;

        if (i == 1 || i == 2){
            mOptionsitem.setVisible(true);
        }else {
            mOptionsitem.setVisible(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optoins_menu, menu);

        mOptionsitem = menu.findItem(R.id.action_search);
        mOptionsitem.setVisible(false);
        search_view.setMenuItem(mOptionsitem);

        return true;
    }

    //按回退键调用这个方法
    @Override
    public void onBackPressed() {

        if (search_view.isSearchOpen()){
            search_view.closeSearch();
        }else {
            super.onBackPressed();
        }
    }
}
