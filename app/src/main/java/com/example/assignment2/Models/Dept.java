package com.example.assignment2.Models;

public class Dept {

    private int deptNumber;
    private String dName;
    private String loc;

    public Dept(){}

    public Dept(int deptNumber, String dName, String loc) {
        this.deptNumber = deptNumber;
        this.dName = dName;
        this.loc = loc;
    }

    public int getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(int deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
