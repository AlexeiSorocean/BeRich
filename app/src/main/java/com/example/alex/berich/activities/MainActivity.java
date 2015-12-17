package com.example.alex.berich.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alex.berich.DayItem;
import com.example.alex.berich.R;
import com.example.alex.berich.adapters.DaysAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    public double totalMoneyCount;
    private RecyclerView mCrimeRecyclerView;

    List<DayItem> dayItemLis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DayItem dayItem = new DayItem();
        dayItem.dayOfTheMonth = 23;
        dayItem.dayOfTheWeek = "Wednesday";
        dayItem.monthAndYear = "November 2015";
        dayItem.spent = 100;

        dayItemLis = new ArrayList<DayItem>();

        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);

        DaysAdapter daysAdapter = new DaysAdapter(dayItemLis, this);

        mCrimeRecyclerView = (RecyclerView) findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCrimeRecyclerView.setAdapter(daysAdapter);
    }
}
