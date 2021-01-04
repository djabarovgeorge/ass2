package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.assignment2.Models.DeptModel;

import java.util.ArrayList;
import java.util.List;

public class LocationFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private ListView _availableNamesDisplayView;
    private View view;
    FragmentActivity _activity;
    List<String> _locations;
    private Spinner _locationSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_location, container, false);
        _activity = getActivity();

        _locations = DeptModel.instance.getAllLocations();

        _locationSpinner = view.findViewById(R.id.location_fragment_spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, _locations);
        // attaching data adapter to spinner
        _locationSpinner.setAdapter(dataAdapter);
        _locationSpinner.setOnItemSelectedListener(this);


        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}


