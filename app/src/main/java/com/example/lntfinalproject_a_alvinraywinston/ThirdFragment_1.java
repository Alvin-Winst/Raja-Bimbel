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

public class ThirdFragment_1 extends Fragment {
    EditText et_panjang;
    EditText et_lebar;
    EditText et_tinggi;
    EditText et_hasil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_panjang = view.findViewById(R.id.panjangBalok);
        et_lebar = view.findViewById(R.id.lebarBalok);
        et_tinggi = view.findViewById(R.id.tinggiBalok);
        et_hasil = view.findViewById(R.id.hasilBalok);
        et_panjang.setOnFocusChangeListener((view1, b) -> {
            if(!b && !TextUtils.isEmpty(et_panjang.getText())){
                int panjang, lebar, tinggi;
                if (TextUtils.isEmpty(et_lebar.getText())){
                    lebar = 0;
                }
                else{
                    lebar = parseInt(et_lebar.getText().toString());
                }
                if (TextUtils.isEmpty(et_tinggi.getText())){
                    tinggi = 0;
                }
                else{
                    tinggi = parseInt(et_tinggi.getText().toString());
                }
                panjang = parseInt(et_panjang.getText().toString());
                et_hasil.setText(panjang*lebar*tinggi);
            }
        });

        et_lebar.setOnFocusChangeListener((view1, b) -> {
            if(!b && !TextUtils.isEmpty(et_lebar.getText())){
                int panjang, lebar, tinggi;
                if (TextUtils.isEmpty(et_panjang.getText())){
                    panjang = 0;
                }
                else{
                    panjang = parseInt(et_panjang.getText().toString());
                }
                if (TextUtils.isEmpty(et_tinggi.getText())){
                    tinggi = 0;
                }
                else{
                    tinggi = parseInt(et_tinggi.getText().toString());
                }
                lebar = parseInt(et_lebar.getText().toString());
                et_hasil.setText(panjang*lebar*tinggi);
            }
        });

        et_tinggi.setOnFocusChangeListener((view1, b) -> {
            if(!b && !TextUtils.isEmpty(et_tinggi.getText())){
                int panjang, lebar, tinggi;
                if (TextUtils.isEmpty(et_panjang.getText())){
                    panjang = 0;
                }
                else{
                    panjang = parseInt(et_panjang.getText().toString());
                }
                if (TextUtils.isEmpty(et_lebar.getText())){
                    lebar = 0;
                }
                else{
                    lebar = parseInt(et_lebar.getText().toString());
                }
                tinggi = parseInt(et_tinggi.getText().toString());
                et_hasil.setText(panjang*lebar*tinggi);
            }
        });
    }
}