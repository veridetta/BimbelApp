package com.inc.vr.corps.bimbelapp.ui.islogin;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.inc.vr.corps.bimbelapp.R;
import com.inc.vr.corps.bimbelapp.ui.nologin.LoginActivity;
import com.inc.vr.corps.bimbelapp.ui.nologin.RegisterActivity;

public class CounterFragment extends Fragment {
    TextView tvCounter,btnPlus;
    TextView btnMin, btnReset;
    SharedPreferences sharedPreferences;
    Integer counter=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_counter, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        getSharedPreference();
        initListener();

    }

    void initView(){
        tvCounter = getView().findViewById(R.id.tv_counter);
        btnMin = getView().findViewById(R.id.btn_min);
        btnPlus = getView().findViewById(R.id.btn_plus);
        btnReset = getView().findViewById(R.id.btn_reset);
        counter = Integer.parseInt(tvCounter.getText().toString());
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvCounter.setText(String.valueOf(counter));
                sharedPreferences.edit().putInt("counter", counter).apply();
                Toast.makeText(getContext(), "Counter: " + counter, Toast.LENGTH_SHORT).show();
            }

        });
    }
    void getSharedPreference(){
         sharedPreferences = getActivity().getSharedPreferences("counter", MODE_PRIVATE);
         counter = sharedPreferences.getInt("counter", 0);
         tvCounter.setText(String.valueOf(counter));
    }
    void initListener() {
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = Integer.parseInt(tvCounter.getText().toString());
                counter--;
                tvCounter.setText(String.valueOf(counter));
                sharedPreferences.edit().putInt("counter", counter).apply();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                tvCounter.setText("0");
                sharedPreferences.edit().putInt("counter", 0).apply();
            }
        });
    }
}