package com.example.alex.berich.ui.main;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import model.Purchase;
import com.example.alex.berich.R;
import com.parse.GetCallback;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 12/18/2015.
 */
public class MonthFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>  {




    //List<Day> dayItemLis;
    public double totalMoneyCount;
    private ListView listView;

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


        listView = (ListView) getView().findViewById(R.id.crime_recycler_view);








    }
    int dpToPixel(int dp)
    {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float fpixels = metrics.density * dp;
        int pixels = (int) (metrics.density * dp + 0.5f);
        return pixels;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}


