package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.SubFragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhakti.moksh.arti.katha.bhajan.Utils.SavedPrefManager;
import com.bhakti.moksh.arti.katha.bhajan.Utils.Services;
import com.bhakti.moksh.arti.katha.bhajan.Utils.Utils;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Adapters.ProductAdapters;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.Products.Doc;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.Products.Products;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FruitsFragments extends Fragment {


    private static final String TAG = "AllFragment";
    View view;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    GridLayoutManager layoutManager;
    String categeryid;
    int pagevalue = 1;
    int limitvalue = 12;
    String shortbyvalue = "asc";
    String searchByvalue = "";
    String shopidvalue = "";
    int allpages;
    private RecyclerView recyclerView;

    private ProductAdapters adapter;
    private ArrayList<Doc> ProductArraylist;
    private ShimmerFrameLayout shimmerFrameLayout;
    private boolean loading = true;

    public FruitsFragments(String categeryid) {

        this.categeryid = categeryid;
        Log.d(TAG, "FruitsFragments:" + categeryid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fruits, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        shimmerFrameLayout = view.findViewById(R.id.shimmerLayout);
        shimmerFrameLayout.startShimmer();


        ProductArraylist = new ArrayList<>();
        adapter = new ProductAdapters(ProductArraylist, getActivity());
        layoutManager = new GridLayoutManager(getActivity(), 3, RecyclerView.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        getData(String.valueOf(pagevalue), String.valueOf(limitvalue), shortbyvalue, searchByvalue, shopidvalue, categeryid, "Basic" + " " + SavedPrefManager.getStringPreferences(getActivity(), "authtoken"));


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();


                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                            Log.d("...", "Last Item Wow !");
                            // Do pagination.. i.e. fetch new data

                            pagevalue++;

                            final Dialog dialog = new Dialog(getActivity());
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                            dialog.setCancelable(false);
                            dialog.setContentView(R.layout.post_loader);
                            dialog.show();
                            final Handler handler = new Handler();
                            final Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                    if (dialog.isShowing()) {
                                        dialog.dismiss();
                                        loadmorepost(String.valueOf(pagevalue), String.valueOf(limitvalue), shortbyvalue, searchByvalue, shopidvalue, categeryid, "Basic" + " " + SavedPrefManager.getStringPreferences(getActivity(), "authtoken"));
                                    }
                                }
                            };

                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    handler.removeCallbacks(runnable);
                                }
                            });

                            handler.postDelayed(runnable, 1500);


                        }
                    }
                }
            }
        });


        return view;
    }

    public void getData(String page, String limit, String shortby, String searchby, String shopid, String categoryid, String authkey) {


        Log.d(TAG, "getData:page " + page);
        Log.d(TAG, "getData:limit " + limit);
        Log.d(TAG, "getData:shortby " + shortby);
        Log.d(TAG, "getData:searchby " + searchby);
        Log.d(TAG, "getData:shopid " + shopid);
        Log.d(TAG, "getData:categoryid " + categoryid);


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

        Services service = retrofit.create(Services.class);

        Call<Products> userCall = service.getProduct(page, limit, shortby, searchby, shopid, categoryid, authkey);
        userCall.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, retrofit2.Response<Products> response) {

                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);

                if (response.isSuccessful()) {


                    if (response.body().getCode() == 200) {

                        allpages = response.body().getData().getPages();
                        Log.d(TAG, "onResponseProduct: " + response.body());
                        for (int i = 0; i < response.body().getData().getDocs().size(); i++) {


                            ProductArraylist.add(response.body().getData().getDocs().get(i));
                            //  Log.d(TAG, "onResponse: "+response.body().getData().getDocs().get(i));

                        }
                        adapter.notifyDataSetChanged();
                        recyclerView.setVisibility(View.VISIBLE);
                    } else {

                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }


                } else {

                    Log.d(TAG, "onResponse: " + "response error");
                    Toast.makeText(getActivity(), "response error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {


                Log.d(TAG, "onResponse: " + t.getMessage());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }


    public void loadmorepost(String page, String limit, String shortby, String searchby, String shopid, String categoryid, String authkey) {

        loading = true;

        if (pagevalue > allpages) {

            Toast.makeText(getActivity(), "No more data", Toast.LENGTH_LONG).show();
        } else {


            Log.d(TAG, "getData:page " + page);
            Log.d(TAG, "getData:limit " + limit);
            Log.d(TAG, "getData:shortby " + shortby);
            Log.d(TAG, "getData:searchby " + searchby);
            Log.d(TAG, "getData:shopid " + shopid);
            Log.d(TAG, "getData:categoryid " + categoryid);


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

            Services service = retrofit.create(Services.class);

            Call<Products> userCall = service.getProduct(page, limit, shortby, searchby, shopid, categoryid, authkey);
            userCall.enqueue(new Callback<Products>() {
                @Override
                public void onResponse(Call<Products> call, retrofit2.Response<Products> response) {

                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);

                    if (response.isSuccessful()) {


                        if (response.body().getCode() == 200) {

                            allpages = response.body().getData().getPages();
                            Log.d(TAG, "onResponseProduct: " + response.body());
                            for (int i = 0; i < response.body().getData().getDocs().size(); i++) {


                                ProductArraylist.add(response.body().getData().getDocs().get(i));
                                //  Log.d(TAG, "onResponse: "+response.body().getData().getDocs().get(i));

                            }

                            adapter.notifyDataSetChanged();
                            recyclerView.setVisibility(View.VISIBLE);
                        } else {

                            Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }


                    } else {

                        Log.d(TAG, "onResponse: " + "response error");
                        Toast.makeText(getActivity(), "response error", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Products> call, Throwable t) {


                    Log.d(TAG, "onResponse: " + t.getMessage());
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }

    }

}