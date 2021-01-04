package com.example.assignment2.Models;

import android.content.Context;

import com.example.assignment2.DataBaseHelper.DeptTable;
import com.example.assignment2.DataBaseHelper.EmpTable;

import java.util.ArrayList;
import java.util.List;

public class EmpModel {

    public final static EmpModel instance = new EmpModel();
    private List<Emp> challengesList = new ArrayList<>();
    private EmpTable empTable;

    public void initDatabase(Context context){
        empTable = new EmpTable(context);
    }
    private EmpModel(){ };

    public List<Emp> getEmpList() {return empTable.getAllEmp();}

    public Emp getEmpByNumber(int empNum) {
        List<Emp> empList = getEmpList();
        for (Emp emp: empList) {
            if(emp.getEmpNumber() == empNum)
                return emp;
        }
        return null;
    }

    public void addEmp(Emp emp){
        empTable.addEmp(emp);
    }
    public boolean clearTable(){
        return empTable.clearTable();
    }

    public int getNumberOfEmpFromDepWithSalary()
    {
        return empTable.getNumberOfEmpFromDepWithSalary();
    }

    public int getNumberOfEmpFromDepWithComm()
    {
        return empTable.getNumberOfEmpFromDepWithComm();
    }
}