package com.example.alex.berich.utils;

import java.util.Date;

/**
 * Created by Alex on 4/6/2016.
 */
public class DateManager {

    Date date;

    String dayOfTheWeek;
    String stringMonth;
    String intMonth;
    String year;
    String day;

    DateManager(Date date) {
        this.date = date;
    }

    public String getDayOfTheWeek() {
        return (String) android.text.format.DateFormat.format("EEEE", date);
    }

    public String getStringMonth() {
        return(String) android.text.format.DateFormat.format("MMM", date);
    }

    public String getIntMonth() {
        return (String) android.text.format.DateFormat.format("MM", date);
    }

    public String getYear() {
        return (String) android.text.format.DateFormat.format("yyyy", date);
    }

    public String getDay() {
        return (String) android.text.format.DateFormat.format("dd", date);
    }


}
