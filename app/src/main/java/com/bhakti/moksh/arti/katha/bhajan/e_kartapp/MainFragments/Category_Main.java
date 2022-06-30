package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.MainFragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.bhakti.moksh.arti.katha.bhajan.Utils.Services;
import com.bhakti.moksh.arti.katha.bhajan.Utils.Utils;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Adapters.ViewPagerAdapter;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.CategoryList.CategoryListModel;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Category_Main extends Fragment {


    private static final String TAG = "Category_Main";
    View view;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ArrayList<String> categoryid;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_category__main, container, false);

        //ui
        viewPager2 = view.findViewById(R.id.viewPager2);
        tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("please wait....");
        categoryid = new ArrayList<>();


        getCategoryList();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


        return view;
    }


    public void getCategoryList() {

        showProgressDialog();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Utils.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Services service = retrofit.create(Services.class);
        Call<CategoryListModel> categorycall = service.GetDropDownTitle();
        categorycall.enqueue(new Callback<CategoryListModel>() {
            @Override
            public void onResponse(Call<CategoryListModel> call, Response<CategoryListModel> response) {
                if (response.isSuccessful()) {

                    progressDialog.dismiss();
                    for (int i = 0; i < response.body().getData().size(); i++) {


                        tabLayout.addTab(tabLayout.newTab().setText(response.body().getData().get(i).getName()));
                        categoryid.add(response.body().getData().get(i).getId());

                    }
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    ViewPagerAdapter sa = new ViewPagerAdapter(fm, getLifecycle(), categoryid);
                    viewPager2.setAdapter(sa);

                    Log.d(TAG, "onResponse: " + categoryid);


                } else {

                    Toast.makeText(getActivity(), "Response Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CategoryListModel> call, Throwable t) {

                hideProgressDialog();
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });

    }

    public void showProgressDialog() {

        progressDialog.show();

    }

    public void hideProgressDialog() {

        progressDialog.dismiss();
    }
}