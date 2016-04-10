package com.example.alex.berich.data;

import com.example.alex.berich.data.local.DatabaseHelper;

/**
 * Created by Alex on 4/10/2016.
 */
public class DataManager {
    private DatabaseHelper databaseHelper;

    DataManager(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

}
