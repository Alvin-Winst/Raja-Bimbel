package com.example.lntfinalproject_a_alvinraywinston;

import static java.lang.Integer.parseInt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ThirdFragment_2 extends Fragment {
    EditText et_sisi;
    EditText et_tinggi;
    EditText et_hasil;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_sisi = view.findViewById(R.id.sisiPiramida);
        et_tinggi = view.findViewById(R.id.tinggiPiramida);
        et_hasil = view.findViewById(R.id.hasilPiramida);
        et_sisi.setOnFocusChangeListener((view1, b) -> {
            if (!b && !TextUtils.isEmpty(et_sisi.getText())){
                int sisi, tinggi;
                if(TextUtils.isEmpty((et_tinggi.getText()))){
                    tinggi = 0;
                }
                else {
                    tinggi = parseInt(et_tinggi.getText().toString());
                }
                sisi = parseInt(et_sisi.getText().toString());
                et_hasil.setText(sisi*sisi*tinggi/3);
            }
        });
        et_tinggi.setOnFocusChangeListener((view1, b) -> {
            if(!b && !TextUtils.isEmpty(et_tinggi.getText())){
                int sisi, tinggi;
                if(TextUtils.isEmpty((et_sisi.getText()))){
                    sisi = 0;
                }
                else {
                    sisi = parseInt(et_sisi.getText().toString());
                }
                tinggi = parseInt(et_tinggi.getText().toString());
                et_hasil.setText(sisi*sisi*tinggi/3);
            }
        });
    }
}