package com.example.alex.berich.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
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

    private static final String TAG = "MonthFragment";

    private static final String MONTH_TITLE = "MONTH_TITLE";
    private static final String INFLOW = "INFLOW";
    private static final String OUTFLOW = "OUTFLOW";
    private static final String MONHT_TOTAL = "TOTAL";


    private static final String PURCHASE_CATEGORY = "PURCHASE_CATEGORY";
    private static final String PURCHASE_TITLE = "PURCHASE_TITLE";
    private static final String PURCHASE_PRICE = "PURCHASE_PRICE";
    private static final String PURCHASE_COUNT = "PURCHASE_COUNT";
    private static final String PURCHASE = "PURCHASE";

    private static final String DAYS = "DAYS";
    private static final String DAYS_COUNT = "DAYS_COUNT";

    private static final String DAY_TOTAL = "DAY_TOTAL";
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
        JSONObject day1;
        JSONObject day2;
        JSONObject day3;


        JSONArray purchases;
        JSONObject purchase1;
        JSONObject purchase2;
        JSONObject purchase3;
        JSONObject purchase4;


        try {
            month = new JSONObject();
            month.put(INFLOW, Integer.toString(500));
            month.put(OUTFLOW, Double.toString(1.810));
            month.put(DAYS_COUNT, Integer.toString(5));


            days = new JSONArray();
            day1 = new JSONObject();
            day1.put(DAY_TOTAL, -140);
            day1.put(MONTH_TITLE, "November 2015");
            day1.put(DAY_TITLE, "Wednesday");
            day1.put(PURCHASE_COUNT, 2);

            day2 = new JSONObject();
            day2.put(DAY_TOTAL, -140);
            day2.put(MONTH_TITLE, "November 2015");
            day2.put(DAY_TITLE, "Friday");
            day2.put(PURCHASE_COUNT, 2);


            purchase1 = new JSONObject();
            purchase1.put(PURCHASE_CATEGORY, "Pocupki");
            purchase1.put(PURCHASE_TITLE, "Maliguta");
            purchase1.put(PURCHASE_PRICE, 100);


            purchase2 = new JSONObject();
            purchase2.put(PURCHASE_CATEGORY, "Pocupki");
            purchase2.put(PURCHASE_TITLE, "Platindi");
            purchase2.put(PURCHASE_PRICE, 40);


            purchases = new JSONArray();


            purchases.put(purchase1);
            purchases.put(purchase2);

            days.put(day1);
            days.put(day2);
            day1.put("purchases", purchases);
            month.put("days", days);
            Log.d(TAG, month.toString());


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


