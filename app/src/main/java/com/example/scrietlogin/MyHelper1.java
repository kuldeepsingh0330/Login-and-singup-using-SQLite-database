package com.example.scrietlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper1 extends SQLiteOpenHelper {

    private static final String dbname = "User_registration";
    private static final int version = 1;

    public MyHelper1(@Nullable Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table student_record (id integer primary key autoincrement , Username text , Email text " +
                ", Password text) ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student_record");
        onCreate(db);

    }

    public boolean insertdata(String username, String email, String password) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Username", username);
        values.put("Email", email);
        values.put("Password", password);
        long r = db.insert("student_record", null, values);
        if (r == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkusername(String username) {

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from student_record where Username=?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;

        } else {
            return false;
        }

    }

    public boolean checkusernameandpassword(String username , String password){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from student_record where Username=? and Password=? "
                , new String[]{username , password});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}
