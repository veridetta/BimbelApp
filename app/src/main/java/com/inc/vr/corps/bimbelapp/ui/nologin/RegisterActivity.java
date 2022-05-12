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

import com.inc.vr.corps.bimbelapp.R;

public class RegisterActivity extends AppCompatActivity {
    EditText txName, txEmail, txIdBimbel, txPassword, txConfirmPassword;
    Button btnRegister;
    TextView btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        initView();
        btnClick();
    }

    void initView(){
        txName = findViewById(R.id.tx_name);
        txEmail = findViewById(R.id.tx_email);
        txIdBimbel = findViewById(R.id.tx_id_bimbel);
        txPassword = findViewById(R.id.tx_password);
        txConfirmPassword = findViewById(R.id.tx_confirm);

        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
    }

    void btnClick() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to login
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get value
                String name = txName.getText().toString();
                String email = txEmail.getText().toString();
                String idBimbel = txIdBimbel.getText().toString();
                String password = txPassword.getText().toString();
                String confirmPassword = txConfirmPassword.getText().toString();
                //check if empty
                if (name.isEmpty() || email.isEmpty() || idBimbel.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    //check email validation
                    Toast.makeText(RegisterActivity.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                }else{
                    if (email.matches("^[a-zA-Z0-9_.]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$")) {
                        //check password validation
                            //min password 5
                            if (password.length() >= 5) {
                                //check confirm password
                                if (password.equals(confirmPassword)) {
                                    //min name 5
                                    if (name.length() >= 5) {
                                        //save variable to sharedpreferences array
                                        SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = pref.edit();
                                        editor.putString("name", name);
                                        editor.putString("email", email);
                                        editor.putString("idBimbel", idBimbel);
                                        editor.putString("password", password);
                                        editor.commit();
                                        //intent to login
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(RegisterActivity.this, "Nama minimal 5 karakter", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(RegisterActivity.this, "Password tidak sama", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(RegisterActivity.this, "Password minimal 5 karakter", Toast.LENGTH_SHORT).show();
                            }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Email tidak valid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}