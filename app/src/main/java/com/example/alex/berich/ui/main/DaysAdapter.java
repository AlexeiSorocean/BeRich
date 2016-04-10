package com.example.alex.berich.ui.main;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.alex.berich.R;

import java.util.List;

/**
 * Created by alex on 12/8/15.
 */
public class DaysAdapter extends CursorAdapter {


    private Context context;

    public DaysAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.context = context;
    }


    @Override
    public void bindView(View convertView, final Context context, final Cursor cursor) {
        final ViewHolder holder = (ViewHolder) convertView.getTag();
//        holder.dayOfTheMonth .setText(Integer.toString(dayItem.dayOfTheMonth));
//        holder.dayOfTheWeek.setText(dayItem.dayOfTheWeek);
//        holder.year.setText(dayItem.monthAndYear);
//        holder.spent.setText(Float.toString(dayItem.spent));
//
//
//
////        LinearLayout relativeLayout = (LinearLayout) getView().findViewById(R.id.layoutContainer);
//
//
//        for (int i = 0; i < 0; i++) {
//
//            LayoutInflater inflater =
//                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            LinearLayout purshaseLinearLayout = (LinearLayout) inflater.inflate(R.layout.purchase_item, null);
//
//            TextView category = (TextView) purshaseLinearLayout.findViewById(R.id.category);
//            category.setText(dayItem.purchasesList.get(i).category);
//            TextView title = (TextView) purshaseLinearLayout.findViewById(R.id.title);
//            title.setText(dayItem.purchasesList.get(i).category);
//            TextView price = (TextView) purshaseLinearLayout.findViewById(R.id.price);
//            price.setText(Double.toString(dayItem.purchasesList.get(i).price));
//
//            holder.layoutContainer.addView(purshaseLinearLayout);
//
//        }
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View convertView = ((Activity)context).getLayoutInflater().inflate(R.layout.days_adapter_item, parent, false);
        ViewHolder holder = new ViewHolder(convertView);
        convertView.setTag(holder);
        return convertView;
    }


    public class ViewHolder {

        public TextView dayOfTheMonth;
        public TextView dayOfTheWeek;
        public TextView year;
        public TextView spent;
        public LinearLayout layoutContainer;

        public ViewHolder(View view) {
            dayOfTheMonth = (TextView) view.findViewById(R.id.dayOfTheMonth);
            dayOfTheWeek = (TextView) view.findViewById(R.id.dayOfTheWeek);
            year = (TextView) view.findViewById(R.id.dateMonthYear);
            spent = (TextView) view.findViewById(R.id.spent);
            layoutContainer = (LinearLayout) view.findViewById(R.id.purchasesLayoutContainer);

        }
    }


}
