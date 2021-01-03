package com.example.assignment2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        Button depBtn = view.findViewById(R.id.menu_fragment_dep_btn);
        depBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_deptFragment));

        Button locBtn = view.findViewById(R.id.menu_fragment_location_btn);
        locBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_locationFragment));

        return view;
    }
}