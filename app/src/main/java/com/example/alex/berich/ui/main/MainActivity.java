package com.example.alex.berich.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.alex.berich.R;

import com.example.alex.berich.ui.base.BaseActivity;
import com.example.alex.berich.ui.login.LoginActivity;
import com.parse.ParseAnalytics;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainMvpView, View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int NUM_PAGES = 3;

    private ViewPager viewPager;

    private PagerAdapter mPagerAdapter;

    private String selectedMonth;

    private TextView currentMonth;
    private TextView nextMonth;
    private TextView prevMonth;

    @Inject
    MainPresenter mainPresenter;

    boolean onButtonClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        mainPresenter.attachView(this);


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        viewPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setCurrentItem(1, false);

        currentMonth = (TextView) findViewById(R.id.currentMonth);
        nextMonth = (TextView) findViewById(R.id.nextMonth);
        prevMonth = (TextView) findViewById(R.id.prevMonth);

        currentMonth.setOnClickListener(this);
        nextMonth.setOnClickListener(this);
        prevMonth.setOnClickListener(this);


        mainPresenter.onLoginRequired();

        currentMonth.setText("01/2016");
        prevMonth.setText("12/2015");
        nextMonth.setText("02/2016");
        selectButton(R.id.currentMonth);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                selectButton(position);
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

    }

    public void showLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        selectButton(v.getId());
        handleButtonClick(v.getId());
    }

    public void selectButton(int id) {
        switch (id) {
            case 2: {
                nextMonth.setTextColor(Color.BLACK);
                prevMonth.setTextColor(Color.GRAY);
                currentMonth.setTextColor(Color.GRAY);
            }
            break;
            case 0: {
                prevMonth.setTextColor(Color.BLACK);
                nextMonth.setTextColor(Color.GRAY);
                currentMonth.setTextColor(Color.GRAY);
            }
            break;
            case 1: {
                currentMonth.setTextColor(Color.BLACK);
                nextMonth.setTextColor(Color.GRAY);
                prevMonth.setTextColor(Color.GRAY);
            }
            break;
        }
    }

    public void handleButtonClick(int id) {

        switch (id) {

            case R.id.prevMonth: {
                viewPager.setCurrentItem(0);
            }
            break;
            case R.id.currentMonth: {
                viewPager.setCurrentItem(1);
            }
            break;
            case R.id.nextMonth: {
                viewPager.setCurrentItem(2);
            }
            break;
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return  MonthFragment.getInstance(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }


    }
}
