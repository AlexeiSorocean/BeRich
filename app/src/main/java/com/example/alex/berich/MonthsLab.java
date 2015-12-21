package com.example.alex.berich;

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

}
