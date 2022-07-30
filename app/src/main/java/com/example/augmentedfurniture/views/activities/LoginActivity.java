package com.example.augmentedfurniture.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.augmentedfurniture.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    TextView tvNewUserL;
    EditText etUserEmailL, etUserPasswordL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initials();
    }

    private void initials() {
        btnLogin = findViewById(R.id.buttonLogin);
        tvNewUserL = findViewById(R.id.textViewNewUserL);
        etUserEmailL = findViewById(R.id.editTextUserEmailL);
        etUserPasswordL = findViewById(R.id.editTextUserPasswordL);

        intents();
    }

    private void intents() {
        tvNewUserL.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            finish();
        });

        btnLogin.setOnClickListener(view -> {
            checkEmpty();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        });
    }

    private void checkEmpty() {

        if ((etUserEmailL.getText().toString().isEmpty()) && (etUserEmailL.getText().toString().contains("@")) && (etUserEmailL.getText().toString().contains(".com"))) {
            etUserEmailL.requestFocus();
            etUserEmailL.setError("Please enter valid email");
        }

        if ((etUserPasswordL.getText().toString().isEmpty()) && (etUserPasswordL.getText().toString().length() < 6)) {
            etUserPasswordL.requestFocus();
            etUserPasswordL.setError("Please enter valid password");
        }
    }
}