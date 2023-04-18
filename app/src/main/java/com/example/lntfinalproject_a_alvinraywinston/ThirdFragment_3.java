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

public class ThirdFragment_3 extends Fragment {
    EditText et_radius;
    EditText et_tinggi;
    EditText et_hasil;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_radius = view.findViewById(R.id.jariTabung);
        et_tinggi = view.findViewById(R.id.tinggiTabung);
        et_hasil = view.findViewById(R.id.hasilTabung);
        et_radius.setOnFocusChangeListener((view1, b) -> {
            if (!b && !TextUtils.isEmpty(et_radius.getText())){
                int radius, tinggi;
                if(TextUtils.isEmpty((et_tinggi.getText()))){
                    tinggi = 0;
                }
                else {
                    tinggi = parseInt(et_tinggi.getText().toString());
                }
                radius = parseInt(et_radius.getText().toString());
                et_hasil.setText((int) (3.14*radius*radius*tinggi));
            }
        });
        et_tinggi.setOnFocusChangeListener((view1, b) -> {
            if(!b && !TextUtils.isEmpty(et_tinggi.getText())){
                int radius, tinggi;
                if(TextUtils.isEmpty((et_radius.getText()))){
                    radius = 0;
                }
                else {
                    radius = parseInt(et_radius.getText().toString());
                }
                tinggi = parseInt(et_tinggi.getText().toString());
                et_hasil.setText((int) (3.14*radius*radius*tinggi));
            }
        });
    }
}