package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment2.Models.EmpModel;

public class CommFragment extends Fragment {

    private int numberOfEmp;
    private String numberOfEmpWithComm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comm, container, false);


        // get text view
        TextView textView = view.findViewById(R.id.depp_comm_20);

        numberOfEmp = EmpModel.instance.getNumberOfEmpFromDepWithComm();

        textView.setText(String.valueOf(numberOfEmp));

        return view;
    }
}