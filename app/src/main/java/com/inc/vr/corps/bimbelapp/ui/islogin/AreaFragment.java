package com.inc.vr.corps.bimbelapp.ui.islogin;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.inc.vr.corps.bimbelapp.R;

public class AreaFragment extends Fragment {
    EditText sisiKotak, alasSegitiga, tinggiSegitiga, jariLingkar;
    EditText luasKotak, luasSegitiga, luasLingkar;
    Button hKotak, hSegitiga, hLingkar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_area, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();

    }

    void initView(){
        sisiKotak = getView().findViewById(R.id.sisi_kotak);
        alasSegitiga = getView().findViewById(R.id.alas_segitiga);
        tinggiSegitiga = getView().findViewById(R.id.tinggi_segitiga);
        jariLingkar = getView().findViewById(R.id.jari_lingkaran);

        luasKotak = getView().findViewById(R.id.luas_persegi);
        luasSegitiga = getView().findViewById(R.id.luas_segitiga);
        luasLingkar = getView().findViewById(R.id.luas_lingkaran);

        hKotak = getView().findViewById(R.id.btn_hitung_kotak);
        hSegitiga = getView().findViewById(R.id.btn_hitung_segitiga);
        hLingkar = getView().findViewById(R.id.btn_hitung_lingkaran);


    }

    void initListener() {
        hKotak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sisi = Integer.parseInt(sisiKotak.getText().toString());
                int luas = sisi*sisi;
                luasKotak.setText(luas+"");
            }
        });
        hSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int alas = Integer.parseInt(alasSegitiga.getText().toString());
                int tinggi = Integer.parseInt(tinggiSegitiga.getText().toString());
                int luas = (alas*tinggi)/2;
                luasSegitiga.setText(luas+"");
            }
        });
        hLingkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jari = Integer.parseInt(jariLingkar.getText().toString());
                int luas = (22/7)*(jari*jari);
                luasLingkar.setText(luas+"");
            }
        });
    }
}