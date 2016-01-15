package com.example.alex.berich;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alex on 12/8/15.
 */
public class DayItem {
    public Date date;

    public ArrayList<Purchase> purchasesList;
    public int dayOfTheMonth;
    public String dayOfTheWeek;
    public String monthAndYear;
    public float spent;

    public static class Purchase{
        public String category;
        public String title;
        public double price;
    }
}
