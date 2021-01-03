package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.assignment2.Models.DeptModel;

import java.util.ArrayList;
import java.util.List;

public class LocationFragment extends Fragment {

    private ListView _availableNamesDisplayView;
    private View view;
    FragmentActivity _activity;
    List<String> _locations;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_location, container, false);
        _activity = getActivity();

        _availableNamesDisplayView = view.findViewById(R.id.location_fragment_locationlist);
        _locations = DeptModel.instance.getAllLocations();
        updateDisplayList();

        return view;
    }

    public void updateDisplayList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(_activity, android.R.layout.simple_spinner_item, _locations);
        _availableNamesDisplayView.setAdapter(adapter);
    }
}

