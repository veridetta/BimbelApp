package com.inc.vr.corps.bimbelapp.ui.islogin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.inc.vr.corps.bimbelapp.R;

public class VolumeFragment extends Fragment {
    EditText sisiKubus, alasSegitiga, tinggiSegitiga, tinggiPir, jariLingkar, tinggiTabung;
    EditText volKubus, volPir, vTab;
    Button hKub, hPir, hTab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_volume, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    void initView(){
        sisiKubus = getView().findViewById(R.id.sisi_kotak);
        alasSegitiga = getView().findViewById(R.id.alas_segitiga);
        tinggiSegitiga = getView().findViewById(R.id.tinggi_segitiga);
        tinggiPir = getView().findViewById(R.id.tinggi_Pyramid);
        jariLingkar = getView().findViewById(R.id.jari_lingkaran);
        tinggiTabung = getView().findViewById(R.id.tinggi_tabung);

        volKubus = getView().findViewById(R.id.volume_persegi);
        volPir = getView().findViewById(R.id.volume_segitiga);
        vTab = getView().findViewById(R.id.volume_lingkaran);

        volKubus.setEnabled(false);
        volPir.setEnabled(false);
        vTab.setEnabled(false);

        hKub = getView().findViewById(R.id.btn_hitung_kotak);
        hPir = getView().findViewById(R.id.btn_hitung_segitiga);
        hTab = getView().findViewById(R.id.btn_hitung_lingkaran);

    }

    void initListener() {
        hKub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sisi = Integer.parseInt(sisiKubus.getText().toString());
                int volume = sisi*sisi*sisi;
                volKubus.setText(volume+"");
            }
        });
        hPir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int alas = Integer.parseInt(alasSegitiga.getText().toString());
                int tinggi = Integer.parseInt(tinggiSegitiga.getText().toString());
                int tinggPir = Integer.parseInt(tinggiPir.getText().toString());
                int luas = (alas*tinggi)/2;
                int vol = luas*tinggPir;
                volPir.setText(vol+"");
            }
        });
        hTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jari = Integer.parseInt(jariLingkar.getText().toString());
                int tinggiTab = Integer.parseInt(tinggiTabung.getText().toString());
                int luas = (22/7)*(jari*jari);
                int vol = luas*tinggiTab;
                vTab.setText(vol+"");
            }
        });
    }
}