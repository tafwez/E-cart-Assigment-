package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bhakti.moksh.arti.katha.bhajan.Utils.SavedPrefManager;
import com.bhakti.moksh.arti.katha.bhajan.Utils.Services;
import com.bhakti.moksh.arti.katha.bhajan.Utils.Utils;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.AuthModels.AuthModels;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Models.UserInfoModel;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashScreen extends AppCompatActivity {

    private static final String TAG = "SplashScreen";

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        layout = findViewById(R.id.layout);
        if (isNetworkConnected()) {
            authUser();
        } else {
            Snackbar snackbar = Snackbar.make(layout, "No Internet Connection", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void authUser() {
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


        UserInfoModel userInfoModel = new UserInfoModel("ShivamNew", "9876574321", 1, 2);


        Call<AuthModels> userCall = service.AuthUser(userInfoModel);
        userCall.enqueue(new Callback<AuthModels>() {
            @Override
            public void onResponse(Call<AuthModels> call, Response<AuthModels> response) {


                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: " + response.body().getData().getTokens().getAccess().getToken());
                    SavedPrefManager.saveStringPreferences(getApplicationContext(), "authtoken", response.body().getData().getTokens().getAccess().getToken());
                    Intent i = new Intent(SplashScreen.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();

                } else {

                    Snackbar.make(layout, "Error in Response", Snackbar.LENGTH_SHORT);
                }


            }

            @Override
            public void onFailure(Call<AuthModels> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });

    }
}