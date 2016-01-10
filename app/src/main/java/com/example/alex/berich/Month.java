package com.example.alex.berich;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by alex on 1/10/16.
 */
public class Month {

    static Month mInstance;
    Context mContext;
    String selectedMonth;
    String currentMonth;

    private Month(){}

    Month(Context context) {
        mContext = context.getApplicationContext();
    }

     static public Month getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new Month(ctx);
        } else {
            mInstance.setContext(ctx);
        }

        return mInstance;
    }

    void setContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public String getCurentMonth() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
        Date date = new Date();
        selectedMonth = dateFormat.format(date);
        return selectedMonth;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setPrevMonth() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
        Date date = getCurrentDatePlusMonth(-1);
        selectedMonth = dateFormat.format(date);
    }

    public void setNextMonth() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
        Date date = getCurrentDatePlusMonth(1);
        selectedMonth = dateFormat.format(date);

    }

    boolean isSelectedMonthCurrMonth() {
        return selectedMonth.equals(currentMonth);
    }

    public static Date getCurrentDatePlusMonth(int month)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, month);
        Date newDate = calendar.getTime();
        return newDate;
    }

}
