package com.example.headsupsqlitesaveonly

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context):SQLiteOpenHelper(context,"celebrities",null,1){
    val sqLiteDatabase:SQLiteDatabase=writableDatabase
    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0!=null){
            p0.execSQL("create table celebrities(name text, taboo1 text,taboo2 text,taboo3 text) ")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun saveData(name:String,taboo1:String, taboo2:String, taboo3:String): Long {
        val cv=ContentValues()
        cv.put("name",name)
        cv.put("taboo1",taboo1)
        cv.put("taboo2",taboo2)
        cv.put("taboo3",taboo3)

        return sqLiteDatabase.insert("celebrities",null,cv)

    }
}