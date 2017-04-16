package com.jp.fristandroidapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jp.fristandroidapp.R;
import com.jp.fristandroidapp.adapter.MyFragmentPagerAdapter;
import com.jp.fristandroidapp.childfragment.PagerFragment1;
import com.jp.fristandroidapp.childfragment.PagerFragment2;
import com.jp.fristandroidapp.childfragment.PagerFragment3;
import com.jp.fristandroidapp.childfragment.PagerFragment4;
import com.jp.fristandroidapp.childfragment.PagerFragment5;
import com.jp.fristandroidapp.childfragment.PagerFragment6;
import com.jp.fristandroidapp.childfragment.PagerFragment7;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    SwipeRefreshLayout mSwipeRefreshLayout;
    private TabLayout tabs;
    private ViewPager vp_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        tabs= (TabLayout) view.findViewById(R.id.tabs);
        vp_view= (ViewPager) view.findViewById(R.id.vp_view);
        mSwipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.refreshlayout);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        addtablayout();

    }

    private void addtablayout() {
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("购物");
        titles.add("明星");
        titles.add("视频");
        titles.add("健康");
        titles.add("动漫");
        titles.add("搞笑");
        for(int i=0;i<titles.size();i++){
            tabs.addTab(tabs.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragmentlist=new ArrayList<>();
        fragmentlist.add(PagerFragment1.newInstance());
        fragmentlist.add(PagerFragment2.newInstance());
        fragmentlist.add(PagerFragment3.newInstance());
        fragmentlist.add(PagerFragment4.newInstance());
        fragmentlist.add(PagerFragment5.newInstance());
        fragmentlist.add(PagerFragment6.newInstance());
        fragmentlist.add(PagerFragment7.newInstance());
        MyFragmentPagerAdapter adapter= new MyFragmentPagerAdapter(getFragmentManager(),getContext(),titles,fragmentlist);
        vp_view.setAdapter(adapter);
        tabs.setupWithViewPager(vp_view);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);

            }
        }, 5000);
    }
}
