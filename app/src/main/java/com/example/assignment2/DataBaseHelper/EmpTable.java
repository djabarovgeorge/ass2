package com.example.assignment2.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.assignment2.Models.Dept;
import com.example.assignment2.Models.Emp;

import java.util.ArrayList;
import java.util.List;

public class EmpTable extends SQLiteOpenHelper {


    private static final String EMP_TABLE = "EMP_TABLE";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_EMPNO = "EMPNO";
    private static final String COLUMN_ENAME = "ENAME";
    private static final String COLUMN_JOB = "JOB";
    private static final String COLUMN_MGR = "MGR";
    private static final String COLUMN_DATE = "DATE";
    private static final String COLUMN_SAL = "SAL";
    private static final String COLUMN_COMM = "COMM";
    private static final String COLUMN_DEPTNO = "DEPTNO";

    private static final String _createTableStatment = "CREATE TABLE " + EMP_TABLE + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_EMPNO + " INTEGER, "
            + COLUMN_ENAME + " TEXT, "
            + COLUMN_JOB + " TEXT, "
            + COLUMN_MGR + " INTEGER, "
            + COLUMN_DATE + " TEXT, "
            + COLUMN_SAL + " INTEGER, "
            + COLUMN_COMM + " INTEGER, "
            + COLUMN_DEPTNO + " INTEGER)";



    public EmpTable(@Nullable Context context) {
        super(context, "emp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(_createTableStatment);
    }

    public boolean clearTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ EMP_TABLE);
        db.close();
        return true;
    }


    public boolean addEmp (Emp emp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_EMPNO, emp.getEmpNumber());
        cv.put(COLUMN_ENAME, emp.getEmpName());
        cv.put(COLUMN_JOB, emp.getJob());
        cv.put(COLUMN_MGR, emp.getManagerId());
        cv.put(COLUMN_DATE, emp.getDate());
        cv.put(COLUMN_SAL, emp.getSal());
        cv.put(COLUMN_COMM, emp.getComm());
        cv.put(COLUMN_DEPTNO, emp.getDeptNumber());

        long insert = db.insert(EMP_TABLE, null, cv);
        db.close();
        return insert != -1;
    }



    public List<Emp> getAllEmp() {
        List<Emp> empList = new ArrayList<>();
        String queryString = "SELECT * FROM "+ EMP_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {

                int cursorEmpNumber = cursor.getInt(1);
                String cursorEmpName = cursor.getString(2);
                String cursorJob = cursor.getString(3);
                int cursorManagerId = cursor.getInt(4);
                String cursorDate = cursor.getString(5);
                int cursorSal = cursor.getInt(6);
                int cursorComm = cursor.getInt(7);
                int cursorDeptNumber = cursor.getInt(8);



                Emp empItem = new Emp(cursorEmpNumber, cursorEmpName, cursorJob, cursorManagerId, cursorDate, cursorSal, cursorComm, cursorDeptNumber);
                empList.add(empItem);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return empList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ EMP_TABLE);
        onCreate(db);
    }

    public int getNumberOfEmpFromDepWithSalary()
    {
        String queryString = "SELECT COUNT("+ COLUMN_SAL + ") FROM "+ EMP_TABLE +" WHERE "+ COLUMN_DEPTNO + "=30 AND "+ COLUMN_SAL +" > 0";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        int sum=0;

        if(cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                sum = cursor.getInt(0);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return sum;
    }

    public int getNumberOfEmpFromDepWithComm()
    {
        String queryString = "SELECT COUNT("+ COLUMN_COMM + ") FROM "+ EMP_TABLE +" WHERE "+ COLUMN_DEPTNO + "=20 AND "+ COLUMN_COMM +" > 0";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        int sum=0;

        if(cursor.moveToFirst())
        {
            while (!cursor.isAfterLast()) {
                sum = cursor.getInt(0);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return sum;
    }
}





