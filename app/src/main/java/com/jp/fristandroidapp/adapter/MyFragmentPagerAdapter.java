package com.jp.fristandroidapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jipeng on 2017/3/22.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
    private FragmentManager fm;
    private Context context;
    private List<String> titles;
    private List<Fragment> fragmentlist;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context, List<String> titles, List<Fragment> fragmentlist) {
        super(fm);
        this.fm = fm;
        this.context = context;
        this.titles = titles;
        this.fragmentlist = fragmentlist;
    }




    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
