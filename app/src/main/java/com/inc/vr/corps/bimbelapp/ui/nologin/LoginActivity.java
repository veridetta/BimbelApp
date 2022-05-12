package com.inc.vr.corps.bimbelapp.ui.nologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inc.vr.corps.bimbelapp.MainActivity;
import com.inc.vr.corps.bimbelapp.R;

public class LoginActivity extends AppCompatActivity {
    EditText txEmail, txPassword;
    Button btnLogin;
    TextView btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        initView();
        btnClick();
    }

    void initView(){
        txEmail = findViewById(R.id.tx_email);
        txPassword = findViewById(R.id.tx_password);

        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

    }


    void btnClick(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to login
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get value
                String email = txEmail.getText().toString();
                String password = txPassword.getText().toString();

                //check empty
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    //check email format
                    if (email.matches("^[a-zA-Z0-9_.]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$")) {
                        //get value from sharedpreferences
                        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
                        String emailPref = sharedPreferences.getString("email", "");
                        String passwordPref = sharedPreferences.getString("password", "");
                        //check value same
                        if(email.equals(emailPref) && password.equals(passwordPref)){
                            //save islogin
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isLogin", true);
                            editor.apply();
                            //intent to main
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "Email dan Password tidak ditemukan", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Email tidak valid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}