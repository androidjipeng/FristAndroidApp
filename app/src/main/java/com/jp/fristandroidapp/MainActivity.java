package com.jp.fristandroidapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.jp.fristandroidapp.fragment.HomeFragment;
import com.jp.fristandroidapp.fragment.StationFragment;
import com.jp.fristandroidapp.fragment.TheamFragment;
import com.jp.fristandroidapp.fragment.WeekNewsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fl_fragment)
    public FrameLayout fl_fragment;

    @OnClick(R.id.rb_station)
    public void station()
    {
        stationFragment();
    }

    @OnClick(R.id.rb_home)
    public void home()
    {
        homeFragment();
    }

    @OnClick(R.id.rb_theam)
    public void theam()
    {
        theamFragment();
    }

    @OnClick(R.id.rb_weekNews)
    public void weekNews()
    {
        weeknewsFragment();
    }

    private void stationFragment() {
        if (null != transaction) {
            transaction = manager.openTransaction();
        }
        if (stationfrag==null)
        {
            stationfrag=StationFragment.newInstance();
            transaction.add(R.id.fl_fragment,stationfrag);
        }

        showfrag(stationfrag,transaction);
    }

    private void homeFragment() {
        if (null != transaction) {
            transaction = manager.openTransaction();
        }
        if (homefrag==null)
        {
            homefrag=HomeFragment.newInstance();
            transaction.add(R.id.fl_fragment,homefrag);
        }

        showfrag(homefrag,transaction);
    }

    private void theamFragment() {
        if (null != transaction) {
            transaction = manager.openTransaction();
        }
        if (theamfrag==null)
        {
            theamfrag=TheamFragment.newInstance();
            transaction.add(R.id.fl_fragment,theamfrag);
        }

        showfrag(theamfrag,transaction);
    }

    private void weeknewsFragment() {
        if (null != transaction) {
            transaction = manager.openTransaction();
        }
        if (weeknewsfrag==null)
        {
            weeknewsfrag=WeekNewsFragment.newInstance();
            transaction.add(R.id.fl_fragment,weeknewsfrag);
        }
        showfrag(weeknewsfrag,transaction);
    }

    private void showfrag(Fragment fragment,FragmentTransaction transaction) {
        if (!transaction.equals(fragment))
        {
            transaction.commit();
        }
        if (homefrag!= null){
            transaction.hide(homefrag);
        }
        if (stationfrag!= null){
            transaction.hide(stationfrag);
        }
        if (theamfrag!= null){
            transaction.hide(theamfrag);
        }
        if (weeknewsfrag!= null){
            transaction.hide(weeknewsfrag);
        }
        transaction.show(fragment);


    }

    private FragmentManager manager=null;
    private FragmentTransaction transaction = null;
    private HomeFragment homefrag=null;
    private StationFragment stationfrag=null;
    private TheamFragment theamfrag=null;
    private WeekNewsFragment weeknewsfrag=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLayout();
        initFragment();
    }

    private void initFragment() {
        if (manager == null) {
            manager = getSupportFragmentManager();
        }
        transaction = manager.beginTransaction();
        homeFragment();
    }

    private void initLayout() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
