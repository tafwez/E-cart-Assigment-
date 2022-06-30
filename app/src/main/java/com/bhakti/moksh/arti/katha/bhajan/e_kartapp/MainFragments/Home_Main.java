package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.MainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.R;

public class Home_Main extends Fragment {



    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home__main, container, false);


        return view;
    }
}