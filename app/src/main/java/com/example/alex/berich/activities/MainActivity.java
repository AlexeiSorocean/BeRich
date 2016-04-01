package com.example.alex.berich.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;


import com.example.alex.berich.R;

import com.example.alex.berich.fragments.MonthFragment;
import com.example.alex.berich.ui.login.LoginActivity;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int NUM_PAGES = 3;

    private ViewPager mPager;

    private PagerAdapter mPagerAdapter;

    private String selectedMonth;

    private TextView currentMonth;
    private TextView nextMonth;
    private TextView prevMonth;

    boolean onButtonClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else {
            Log.i(TAG, currentUser.getUsername());
        }


        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(1, false);
        //mPager.setOnPageChangeListener(new CircularViewPagerHandler(mPager));

        currentMonth = (TextView) findViewById(R.id.currentMonth);
        nextMonth = (TextView) findViewById(R.id.nextMonth);
        prevMonth = (TextView) findViewById(R.id.prevMonth);
        currentMonth.setOnClickListener(this);
        nextMonth.setOnClickListener(this);
        prevMonth.setOnClickListener(this);

        currentMonth.setText("01/2016");
        prevMonth.setText("12/2015");
        nextMonth.setText("02/2016");
        selectButton(R.id.currentMonth);

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
            case R.id.nextMonth: {
                nextMonth.setTextColor(Color.BLACK);
                prevMonth.setTextColor(Color.GRAY);
                currentMonth.setTextColor(Color.GRAY);
            }
            break;
            case R.id.prevMonth: {
                prevMonth.setTextColor(Color.BLACK);
                nextMonth.setTextColor(Color.GRAY);
                currentMonth.setTextColor(Color.GRAY);
            }
            break;
            case R.id.currentMonth: {
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
                mPager.setCurrentItem(0);
            }
            break;
            case R.id.currentMonth: {
                mPager.setCurrentItem(1);
            }
            break;
            case R.id.nextMonth: {
                mPager.setCurrentItem(2);
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
