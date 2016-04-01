package com.example.alex.berich.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.berich.Day;
import com.example.alex.berich.ParseMonthItem;
import com.example.alex.berich.Purchase;
import com.example.alex.berich.R;
import com.example.alex.berich.adapters.DaysAdapter;
import com.parse.GetCallback;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
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


    List<Day> dayItemLis;
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
        Day dayItem = new Day();

        //((MainActivity)getActivity()).selectButton(selectButtonFromFragment(getArguments().getInt("Position")));

        dayItem.dayOfTheMonth = getArguments().getInt("Position");
        dayItem.dayOfTheWeek = "Wednesday";
        dayItem.monthAndYear = "November 2015";
        dayItem.spent = 100;

        dayItemLis = new ArrayList<Day>();
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
        Purchase purchase = new Purchase();
        purchase.title = "brinza";
        purchase.category = "cumparaturi";
        purchase.price = 100;
        dayItem.purchasesList = new ArrayList<Purchase>();
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
            day1.put("purchases", purchases);
            days.put(day1);
            days.put(day2);
            month.put("days", days);
            ParseMonthItem parseMonthItem = new ParseMonthItem(month.toString());
            parseMonthItem.setObjectId("1/2016");
            parseMonthItem.setOwner(ParseUser.getCurrentUser());
            parseMonthItem.saveInBackground(new SaveCallback() {
                @Override
                public void done(com.parse.ParseException e) {
                    if (e == null) {
                        Log.d(TAG, "succes");
                        ParseQuery<ParseMonthItem> query = ParseQuery.getQuery(ParseMonthItem.class);
// Specify the object id
                        query.getInBackground("1/2016", new GetCallback<ParseMonthItem>() {
                            @Override
                            public void done(ParseMonthItem object, com.parse.ParseException e) {
                                if (e == null) {
                                    Log.d(TAG, object.toString());
                                    // Access data using the `get` methods for the object
//                        String body = item.getBody();
//                        // Access special values that are built-in to each object
//                        String objectId = item.getObjectId();
//                        Date updatedAt = item.getUpdatedAt();
//                        Date createdAt = item.getCreatedAt();
                                    // Do whatever you want with the data...
                                    //Toast.makeText(TodoItemsActivity.this, body, Toast.LENGTH_SHORT).show();
                                } else {
                                    // something went wrong
                                }
                            }
                        });

                    } else {

                    }

                }
            });


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


