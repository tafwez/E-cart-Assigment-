package com.bhakti.moksh.arti.katha.bhajan.e_kartapp.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.MainFragments.Category_Main;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.MainFragments.Home_Main;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.MainFragments.UserDetails_Main;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.MainFragments.Vendors_Main;
import com.bhakti.moksh.arti.katha.bhajan.e_kartapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton fab;
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new Home_Main();
                    break;
                case R.id.category:
                    selectedFragment = new Category_Main();
                    break;
                case R.id.vendor:
                    selectedFragment = new Vendors_Main();
                    break;
                case R.id.user:
                    selectedFragment = new UserDetails_Main();
                    break;
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, selectedFragment)
                    .commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);


        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Home_Main()).commit();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "work on progress", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search:
                Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_LONG).show();
                return true;
            case R.id.favourite:
                Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_LONG).show();
                return true;
            case R.id.cart:
                Toast.makeText(getApplicationContext(), "Work in progress", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}