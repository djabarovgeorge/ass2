package com.example.assignment2.Models;

import android.content.Context;

import com.example.assignment2.DataBaseHelper.DeptTable;

import java.util.ArrayList;
import java.util.List;

public class DeptModel {

    public final static DeptModel instance = new DeptModel();
    private List<Dept> deptList = new ArrayList<>();
    private DeptTable deptTable;

    public void initDatabase(Context context){
        deptTable = new DeptTable(context);
    }
    private DeptModel(){
    };

    public List<Dept> getDeptList() {return deptTable.getAllDept();}

    public Dept getDept(int deptId) {
        List<Dept> deptList = getDeptList();
        for (Dept dept: deptList) {
            if(dept.getDeptNumber() == deptId)
                return dept;
        }
        return null;
    }
    public List<String> getAllLocations() {
        return deptTable.getAllLocations();
    }

    public void addDept(Dept dept){
        deptTable.addDept(dept);
    }
    public boolean clearTable(){
        return deptTable.clearTable();
    }

}


