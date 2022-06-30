package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.SubFragments.AllFragment;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.SubFragments.FruitsFragments;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.SubFragments.MedicalFragments;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.SubFragments.VegetablesFragments;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    ArrayList<String> categoryid = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<String> categoryid) {
        super(fragmentManager, lifecycle);
        this.categoryid = categoryid;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                AllFragment allFragment = new AllFragment(categoryid.get(position));
                return allFragment;
            case 1:
                FruitsFragments fruitsFragments = new FruitsFragments(categoryid.get(position));
                return fruitsFragments;
            case 2:
                VegetablesFragments vegetablesFragments = new VegetablesFragments(categoryid.get(position));
                return vegetablesFragments;
            case 3:
                MedicalFragments medicalFragments = new MedicalFragments(categoryid.get(position));
                return medicalFragments;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
