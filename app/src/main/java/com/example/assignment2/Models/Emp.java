package com.example.assignment2.Models;

public class Emp {

    private int empNumber;
    private String empName;
    private String job;
    private int managerId;
    private String date;
    private int sal;
    private int comm;
    private int deptNumber;

    public Emp(){ }

    public Emp(int empNumber, String empName, String job, int managerId, String date, int sal, int comm, int deptNumber) {
        this.empNumber = empNumber;
        this.empName = empName;
        this.job = job;
        this.managerId = managerId;
        this.date = date;
        this.sal = sal;
        this.comm = comm;
        this.deptNumber = deptNumber;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(int deptNumber) {
        this.deptNumber = deptNumber;
    }
}
