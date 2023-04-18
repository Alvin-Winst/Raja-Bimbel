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

public class SecondFragment_2 extends Fragment {
    EditText et_alas;
    EditText et_tinggi;
    EditText et_hasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_alas = view.findViewById(R.id.alasSegitiga);
        et_tinggi = view.findViewById(R.id.tinggiSegitiga);
        et_hasil = view.findViewById(R.id.hasilSegitiga);

        et_alas.setOnFocusChangeListener((view1, b) -> {
            if (!b && !TextUtils.isEmpty(et_alas.getText())){
                int alas, tinggi;
                if(TextUtils.isEmpty((et_tinggi.getText()))){
                    tinggi = 0;
                }
                else {
                    tinggi = parseInt(et_tinggi.getText().toString());
                }
                alas = parseInt(et_alas.getText().toString());
                et_hasil.setText(alas*tinggi/2);
            }
        });
        et_tinggi.setOnFocusChangeListener((view1, b) -> {
            if(!b && !TextUtils.isEmpty(et_tinggi.getText())){
                int alas, tinggi;
                if(TextUtils.isEmpty((et_alas.getText()))){
                    alas = 0;
                }
                else {
                    alas = parseInt(et_alas.getText().toString());
                }
                tinggi = parseInt(et_tinggi.getText().toString());
                et_hasil.setText(alas*tinggi/2);
            }
        });
    }
}