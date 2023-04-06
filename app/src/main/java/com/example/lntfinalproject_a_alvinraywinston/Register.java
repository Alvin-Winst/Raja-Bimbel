package com.example.lntfinalproject_a_alvinraywinston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText idField, emailField, namaField, passField,confPassField;
    TextView loginLink;
    Button regisBtn;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idField=findViewById(R.id.id_bimbel);
        emailField=findViewById(R.id.email);
        namaField=findViewById(R.id.nama);
        passField=findViewById(R.id.pass);
        confPassField=findViewById(R.id.conf_pass);
        loginLink=findViewById(R.id.link_login);
        regisBtn=findViewById(R.id.btn_regis);

        loginLink.setOnClickListener(view -> {
            Intent loginIntent = new Intent(Register.this,Login.class);
            startActivity(loginIntent);
        });

        regisBtn.setOnClickListener(view -> {
            if (TextUtils.isEmpty(idField.getText())){
                Toast.makeText(this,"ID required",Toast.LENGTH_SHORT).show();
            }else if (!(emailField.getText().toString().contains("@") && emailField.getText().toString().endsWith(".com"))){
                Toast.makeText(this,"Email harus terdapat '@' dan diakhiri dengan '.com'",Toast.LENGTH_SHORT).show();
            }else if (namaField.getText().toString().length()<5){
                Toast.makeText(this,"Nama minimal 5 huruf",Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(passField.getText())){
                Toast.makeText(this,"Password required",Toast.LENGTH_SHORT).show();
            }else if (confPassField.getText().toString()!=passField.getText().toString()){
                Toast.makeText(this, "Konfirmasi Password tidak sama dengan Password", Toast.LENGTH_SHORT).show();
            }else{
                Context context = getApplicationContext();
                String id = ((EditText)idField).getText().toString();
                String email = ((EditText)emailField).getText().toString();
                String nama = ((EditText)namaField).getText().toString();
                String pass = ((EditText)passField).getText().toString();

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(Register.this,task -> {
                    if (!task.isSuccessful()){
                        Toast.makeText(context, "Gagal registrasi", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(Register.this,Login.class);
                        startActivity(loginIntent);
                    }
                });

            }
        });
    }
}