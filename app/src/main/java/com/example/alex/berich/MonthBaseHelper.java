package com.example.alex.berich;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.alex.berich.MonthDbSchema;
/**
 * Created by Alex on 12/21/2015.
 */
public class MonthBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "monthBase.db";

    public MonthBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + MonthDbSchema.MonthTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        MonthDbSchema.MonthTable.Cols.UUID + ", " +
                        MonthDbSchema.MonthTable.Cols.TITLE + ", " +
                        MonthDbSchema.MonthTable.Cols.INFLOW + ", " +
                        MonthDbSchema.MonthTable.Cols.OUTFLOW + ", " +
                        MonthDbSchema.MonthTable.Cols.DAYS_NUMBER + ", " +
                        MonthDbSchema.MonthTable.Cols.DAYS +
                        ")"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}



