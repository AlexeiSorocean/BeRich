package com.example.alex.berich;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Alex on 12/21/2015.
 */
public class MonthsLab {

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private  MonthsLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new MonthBaseHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getContentValues(Month month) {
        ContentValues values = new ContentValues();
//        values.put(MonthDbSchema.MonthTable.Cols.UUID, month.getUuid().toString());
//        values.put(MonthDbSchema.MonthTable.Cols.TITLE, month.getTitle());
//        values.put(MonthDbSchema.MonthTable.Cols.INFLOW, month.getInflow());
//        values.put(MonthDbSchema.MonthTable.Cols.OUTFLOW, month.getOutflow());
//        values.put(MonthDbSchema.MonthTable.Cols.DAYS_NUMBER, month.getDaysNumber());
//        values.put(MonthDbSchema.MonthTable.Cols.DAYS, month.getDays());
        return values;
    }

    public void addMonth(Month month){
        ContentValues values = getContentValues(month);

        mDatabase.insert(MonthDbSchema.MonthTable.NAME, null, values);
    }


}
