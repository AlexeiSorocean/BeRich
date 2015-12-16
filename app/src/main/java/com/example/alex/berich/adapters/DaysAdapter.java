package com.example.alex.berich.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.berich.DayItem;
import com.example.alex.berich.R;

import java.util.Collection;
import java.util.List;

/**
 * Created by alex on 12/8/15.
 */
public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.ItemHolder> {

    private List<DayItem> daysItem;
    private Context mContext;

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        DayItem dayItem = daysItem.get(position);
        holder.dayOfTheMonth .setText(Integer.toString(dayItem.dayOfTheMonth));
        holder.dayOfTheWeek.setText(dayItem.dayOfTheWeek);
        holder.year.setText(dayItem.monthAndYear);
        holder.spent.setText(Float.toString(dayItem.spent));
    }

    @Override
    public int getItemCount() {
        return daysItem.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        public TextView dayOfTheMonth;
        public TextView dayOfTheWeek;
        public TextView year;
        public TextView spent;

        public ItemHolder(View view) {
            super(view);
            dayOfTheMonth = (TextView) view.findViewById(R.id.dayOfTheMonth);
            dayOfTheWeek = (TextView) view.findViewById(R.id.dayOfTheWeek);
            year = (TextView) view.findViewById(R.id.dateMonthYear);
            spent = (TextView) view.findViewById(R.id.spent);


        }
    }

    public DaysAdapter(List<DayItem> dayItemLis, Context context){
        this.daysItem = dayItemLis;
        this.mContext = context;
    }






}
