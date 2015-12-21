package com.example.alex.berich;

/**
 * Created by Alex on 12/21/2015.
 */
public class MonthDbSchema {
    public static final class MonthTable{
        public static final String NAME = "months";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String OUTFLOW = "outflow";
            public static final String INFLOW = "inflow";
            public static final String DAYS = "days";
        }
    }
}
