package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textView2 = view.findViewById(R.id.textView4);
        MainActivity mainActivity = ((MainActivity)getActivity());
        String profileName = mainActivity.getProfileName();
        if (profileName != null && profileName.isEmpty()){
            textView2.setText(profileName);
        }
        return view;
    }
}