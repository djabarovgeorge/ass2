package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignment2.DataBaseHelper.DeptTable;
import com.example.assignment2.Models.Dept;
import com.example.assignment2.Models.DeptModel;
import com.example.assignment2.Models.Emp;
import com.example.assignment2.Models.EmpModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DeptModel.instance.initDatabase(this);
        initDeptDataBase();
        EmpModel.instance.initDatabase(this);
        initEmpDataBase();
    }

    private void initDeptDataBase() {
        DeptModel.instance.clearTable();
        DeptModel.instance.addDept(new Dept(10,"ACCOUNTING","NEW YORK"));
        DeptModel.instance.addDept(new Dept(20,"RESEARCH","DALLAS"));
        DeptModel.instance.addDept(new Dept(30,"SALES","CHICAGO"));
        DeptModel.instance.addDept(new Dept(40,"OPERATIONS","BOSTON"));
    }
    private void initEmpDataBase() {
        EmpModel.instance.clearTable();
        EmpModel.instance.addEmp(new Emp(7369,"SMITH","CLERK",7902,"17/12/1980",800,0,20 ));
        EmpModel.instance.addEmp(new Emp(7499,"ALLEN","SALESMAN",7698,"20/02/1981",1600,300,30));
    }
}