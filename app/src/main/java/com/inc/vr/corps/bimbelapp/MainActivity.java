package com.inc.vr.corps.bimbelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.inc.vr.corps.bimbelapp.ui.islogin.AreaFragment;
import com.inc.vr.corps.bimbelapp.ui.islogin.CounterFragment;
import com.inc.vr.corps.bimbelapp.ui.islogin.VolumeFragment;
import com.inc.vr.corps.bimbelapp.ui.nologin.LoginActivity;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView navigationView;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar();

        navigationView = findViewById(R.id.navigation);
        //navigationview onitemselectedlistener
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        // When we open the application first
        // time the fragment should be shown to the user
        // in this case it is home fragment
        CounterFragment fragment = new CounterFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, "");
        fragmentTransaction.commit();
    }

    void setActionBar(){
        sharedPreferences();
        actionBar = getSupportActionBar();
        actionBar.setTitle(name);
    }

    void sharedPreferences(){
        //getsharedpreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Boolean isLogin = sharedPreferences.getBoolean("isLogin", false);
        if (isLogin){
            name = sharedPreferences.getString("name", "");
        }else{
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.nav_counter:
                    CounterFragment fragment = new CounterFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content, fragment, "");
                    fragmentTransaction.commit();
                    return true;

                case R.id.nav_area_calc:
                    AreaFragment fragment1 = new AreaFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.content, fragment1);
                    fragmentTransaction1.commit();
                    return true;

                case R.id.nav_volume_calc:
                    VolumeFragment fragment2 = new VolumeFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.content, fragment2, "");
                    fragmentTransaction2.commit();
                    return true;

            }
            return false;
        }
    };
}