package com.example.alex.berich.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alex.berich.DayItem;
import com.example.alex.berich.R;
import com.example.alex.berich.activities.MainActivity;
import com.example.alex.berich.adapters.DaysAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 12/18/2015.
 */
public class MonthFragment extends Fragment {

    List<DayItem> dayItemLis;
    public double totalMoneyCount;
    private RecyclerView mCrimeRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.month_fragment_layout, container, false);


        return rootView;
    }

    static public MonthFragment getInstance(int position) {
        MonthFragment frament = new MonthFragment();
        Bundle args = new Bundle();
        args.putInt("Position", position);
        frament.setArguments(args);
        return frament;
    }
    public int selectButtonFromFragment(int position) {
        int buttonToChosee = 0;
        switch (position) {
            case 0:
                buttonToChosee = R.id.prevMonth;
                break;
            case 1:
                buttonToChosee = R.id.currentMonth;

                break;
            case 2:
                buttonToChosee = R.id.nextMonth;
                break;
        };
        return buttonToChosee;
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstanseState) {
        super.onActivityCreated(onSavedInstanseState);
        DayItem dayItem = new DayItem();

        ((MainActivity)getActivity()).selectButton(selectButtonFromFragment(getArguments().getInt("Position")));

        dayItem.dayOfTheMonth = getArguments().getInt("Position");
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
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);
        dayItemLis.add(dayItem);

        DaysAdapter daysAdapter = new DaysAdapter(dayItemLis, getActivity());

        mCrimeRecyclerView = (RecyclerView) getView().findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCrimeRecyclerView.setAdapter(daysAdapter);
    }



}
