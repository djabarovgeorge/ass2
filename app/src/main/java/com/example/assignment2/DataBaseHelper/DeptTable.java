package com.example.assignment2.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.assignment2.Models.Dept;

import java.util.ArrayList;
import java.util.List;

public class DeptTable extends SQLiteOpenHelper {

    private static final String DEPT_TABLE = "DEPT_TABLE";
    private static final String COLUMN_ID = "COLUMN_ID";
    private static final String COLUMN_DEPTNO = "DEPTNO";
    private static final String COLUMN_DNAME = "COLUMN_DNAME";
    private static final String COLUMN_LOC = "COLUMN_LOC";

    private static final String _createTableStatment = "CREATE TABLE " + DEPT_TABLE + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DEPTNO + " INTEGER, "
            + COLUMN_DNAME + " TEXT, "
            + COLUMN_LOC + " TEXT)";


    public DeptTable(@Nullable Context context) {
        super(context, "dept.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(_createTableStatment);
    }
    public boolean clearTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ DEPT_TABLE);
        db.close();
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean addDept (Dept dept) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DEPTNO, dept.getDeptNumber());
        cv.put(COLUMN_DNAME, dept.getdName());
        cv.put(COLUMN_LOC, dept.getLoc());

        long insert = db.insert(DEPT_TABLE, null, cv);
        return insert != -1;
    }

    public List<Dept> getAllDept() {
        List<Dept> deptList = new ArrayList<>();
        String queryString = "SELECT * FROM "+ DEPT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                int cursorDeptNumber = cursor.getInt(1);
                String cursorDName = cursor.getString(2);
                String cursorLoc = cursor.getString(3);

                Dept deptItem = new Dept(cursorDeptNumber, cursorDName, cursorLoc);
                deptList.add(deptItem);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return deptList;
    }
    public List<String> getAllLocations() {
        List<String> locList = new ArrayList<>();
        String queryString = "SELECT " + COLUMN_LOC + " FROM "+ DEPT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                String cursorLoc = cursor.getString(0);

                locList.add(cursorLoc);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return locList;
    }
}
