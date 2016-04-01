package com.example.alex.berich.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alex.berich.Day;
import com.example.alex.berich.R;

import java.util.List;

/**
 * Created by alex on 12/8/15.
 */
public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.ItemHolder> {

    private List<Day> daysItem;
    private Context mContext;

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater
                .inflate(R.layout.days_adapter_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Day dayItem = daysItem.get(position);
        holder.dayOfTheMonth .setText(Integer.toString(dayItem.dayOfTheMonth));
        holder.dayOfTheWeek.setText(dayItem.dayOfTheWeek);
        holder.year.setText(dayItem.monthAndYear);
        holder.spent.setText(Float.toString(dayItem.spent));



//        LinearLayout relativeLayout = (LinearLayout) getView().findViewById(R.id.layoutContainer);


        for (int i = 0; i < 0; i++) {

            LayoutInflater inflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout purshaseLinearLayout = (LinearLayout) inflater.inflate(R.layout.purchase_item, null);

            TextView category = (TextView) purshaseLinearLayout.findViewById(R.id.category);
            category.setText(dayItem.purchasesList.get(i).category);
            TextView title = (TextView) purshaseLinearLayout.findViewById(R.id.title);
            title.setText(dayItem.purchasesList.get(i).category);
            TextView price = (TextView) purshaseLinearLayout.findViewById(R.id.price);
            price.setText(Double.toString(dayItem.purchasesList.get(i).price));

            holder.layoutContainer.addView(purshaseLinearLayout);

        }
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
        public LinearLayout layoutContainer;

        public ItemHolder(View view) {
            super(view);
            dayOfTheMonth = (TextView) view.findViewById(R.id.dayOfTheMonth);
            dayOfTheWeek = (TextView) view.findViewById(R.id.dayOfTheWeek);
            year = (TextView) view.findViewById(R.id.dateMonthYear);
            spent = (TextView) view.findViewById(R.id.spent);
            layoutContainer = (LinearLayout) view.findViewById(R.id.purchasesLayoutContainer);

        }
    }

    public DaysAdapter(List<Day> dayItemLis, Context context){
        this.daysItem = dayItemLis;
        this.mContext = context;
    }
}
