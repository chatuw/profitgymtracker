package com.pthl.DAO;

import android.content.Context;

public class DAOCalorie extends DAOBase{
    // Contacts table name
    public static final String TABLE_NAME = "Food";

    public static final String F_ID = "food_id";
    public static final String F_NAME = "food_name";
    public static final String DATE = "date";
    public static final String F_Manufacture = "food_manufacture_name";

    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + F_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " DATE, " + F_NAME + " TEXT , " + F_Manufacture+ " TEXT);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";


    public DAOCalorie(Context context) {
        super(context);
    }



}
