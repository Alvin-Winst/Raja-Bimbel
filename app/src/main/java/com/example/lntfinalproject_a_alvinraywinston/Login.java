package com.example.lntfinalproject_a_alvinraywinston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class Login extends AppCompatActivity {
    EditText emailField, passField;
    Button loginBtn;
    TextView regisLink;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField=findViewById(R.id.email);
        passField=findViewById(R.id.pass);
        loginBtn=findViewById(R.id.btn_login);
        regisLink=findViewById((R.id.link_register));
        mAuth = FirebaseAuth.getInstance();

        regisLink.setOnClickListener(view -> {
            Intent regisIntent = new Intent(Login.this,Register.class);
            startActivity(regisIntent);
        });
        mAuthStateListener = firebaseAuth -> {
            FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
            if (mFirebaseUser!=null){
                Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(Login.this,HomePage.class);
                startActivity(homeIntent);
            }else{
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show();
            }
        };
        loginBtn.setOnClickListener(view -> {
            String email = ((EditText)emailField).getText().toString();
            String pass = ((EditText)passField).getText().toString();
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(Login.this,task -> {
                if(!task.isSuccessful()){
                    Toast.makeText(this, "Email atau Password tidak sesuai", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(Login.this,HomePage.class);
                    startActivity(home);
                }
            });
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
}