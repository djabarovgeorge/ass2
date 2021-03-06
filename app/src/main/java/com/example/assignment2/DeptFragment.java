package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment2.Models.DeptModel;
import com.example.assignment2.Models.EmpModel;


public class DeptFragment extends Fragment {

    private int numberOfEmp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dept, container, false);

        // get text view
        TextView textView = view.findViewById(R.id.fragment_emp_number);

        numberOfEmp = EmpModel.instance.getNumberOfEmpFromDepWithSalary();

        textView.setText(String.valueOf(numberOfEmp));

        return view;
    }

}