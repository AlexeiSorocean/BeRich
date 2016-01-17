package com.example.alex.berich.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.alex.berich.DayItem;
import com.example.alex.berich.R;
import com.example.alex.berich.activities.MainActivity;
import com.example.alex.berich.adapters.DaysAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 12/18/2015.
 */
public class MonthFragment extends Fragment {

    private static final String INFLOW = "INFLOW";
    private static final String OUTFLOW = "OUTFLOW";
    private static final String TOTAL = "TOTAL";
    private static final String DAY_OF_THE_MONTH = "DAY_OF_THE_MONTH";
    private static final String MONTH_TITLE = "MONTH_TITLE";
    private static final String CATEGORY = "CATEGORY";
    private static final String PURCHASE_TITLE = "PURCHASE_TITLE";
    private static final String PURCHASE_PRICE = "PURCHASE_PRICE";
    private static final String DAY_TOTAL = "DAY_TOTAL";
    private static final String DAY_NAME = "DAY_NAME";
    private static final String DAYS_COUNT = "DAYS_COUNT";
    private static final String DAY_TITLE = "DAY_TITLE";

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


    @Override
    public void onActivityCreated(Bundle onSavedInstanseState) {
        super.onActivityCreated(onSavedInstanseState);
        DayItem dayItem = new DayItem();

        //((MainActivity)getActivity()).selectButton(selectButtonFromFragment(getArguments().getInt("Position")));

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
        DayItem.Purchase purchase = new DayItem.Purchase();
        purchase.title = "brinza";
        purchase.category = "cumparaturi";
        purchase.price = 100;
        dayItem.purchasesList = new ArrayList<DayItem.Purchase>();
        dayItem.purchasesList.add(purchase);
        dayItem.purchasesList.add(purchase);
        dayItem.purchasesList.add(purchase);

        DaysAdapter daysAdapter = new DaysAdapter(dayItemLis, getActivity());


        mCrimeRecyclerView = (RecyclerView) getView().findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCrimeRecyclerView.setAdapter(daysAdapter);

        JSONObject month;
        JSONArray days;
        JSONObject day;
        JSONArray purchases;
        JSONObject purchas;


        try {
            month = new JSONObject();
            month.put(INFLOW, Integer.toString(500));
            month.put(OUTFLOW, Double.toString(1.810));
            month.put(DAYS_COUNT, Integer.toString(5));
            days = new JSONArray();
            day = new JSONObject();
            day.put(DAY_TOTAL, -140);
            month.put("days", days);



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    int dpToPixel(int dp)
    {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float fpixels = metrics.density * dp;
        int pixels = (int) (metrics.density * dp + 0.5f);
        return pixels;
    }
}


