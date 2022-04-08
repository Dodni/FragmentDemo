package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class ProfilFragment extends Fragment {

    private ImageView profileImageView;
    private EditText profileNameEditText;
    private Button saveButton;
    private Button cancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        profileImageView = view.findViewById(R.id.profileImageView);
        profileNameEditText = view.findViewById(R.id.profileNameEditTextText);
        saveButton = view.findViewById(R.id.saveButton);
        cancelButton = view.findViewById(R.id.cancelButton);

        // ha már volt beállított profilnév, akkor ez jelenjen meg.
        profileNameEditText.setText(((MainActivity)getActivity()).getProfileName());

        // mégse gomb
        cancelButton.setOnClickListener(v -> {
            ((MainActivity)getActivity()).navigateToHome();
        });

        // mentés gomb
        saveButton.setOnClickListener(v -> {
             String profileName = profileNameEditText.getText().toString();
            ((MainActivity)getActivity()).saveAndNavigateToHome(profileName);
        });

        return view;
    }
}