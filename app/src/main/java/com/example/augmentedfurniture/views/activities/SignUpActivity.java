package com.example.augmentedfurniture.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.augmentedfurniture.R;

public class SignUpActivity extends AppCompatActivity {

    Button btnSignUp;
    CheckBox cbTermsConditionsH;
    TextView tvAlreadyUserSU;
    EditText etUserEmailSU, etUserPasswordSU, etUserDOBSU, etUserMobileSU, etUserNameSU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initials();
    }

    private void initials() {
        btnSignUp = findViewById(R.id.buttonSignUp);
        tvAlreadyUserSU = findViewById(R.id.textViewAlreadyUser);
        cbTermsConditionsH = findViewById(R.id.checkBoxTermsConditionsSU);
        etUserNameSU = findViewById(R.id.editTextUserNameSU);
        etUserDOBSU = findViewById(R.id.editTextUserDOBSU);
        etUserMobileSU = findViewById(R.id.editTextUserMobileSU);
        etUserEmailSU = findViewById(R.id.editTextUserEmailSU);
        etUserPasswordSU = findViewById(R.id.editTextUserPasswordSU);

        intents();
    }

    private void intents() {
        tvAlreadyUserSU.setOnClickListener(view -> {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });

        btnSignUp.setOnClickListener(view -> {
            checkEmpty();
            startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
            finish();
        });
    }

    private void checkEmpty() {

        if ((etUserEmailSU.getText().toString().isEmpty()) && (etUserEmailSU.getText().toString().contains("@")) && (etUserEmailSU.getText().toString().contains(".com"))) {
            etUserEmailSU.requestFocus();
            etUserEmailSU.setError("Please enter valid email");
        }

        if ((etUserPasswordSU.getText().toString().isEmpty()) && (etUserPasswordSU.getText().toString().length() < 6)) {
            etUserPasswordSU.requestFocus();
            etUserPasswordSU.setError("Please enter valid password");
        }

        if ((etUserDOBSU.getText().toString().isEmpty()) && (etUserDOBSU.getText().toString().length() < 11)) {
            etUserDOBSU.requestFocus();
            etUserDOBSU.setError("Please enter valid date of birth");
        }

        if ((etUserMobileSU.getText().toString().isEmpty()) && (etUserMobileSU.getText().toString().length() < 10)) {
            etUserMobileSU.requestFocus();
            etUserMobileSU.setError("Please enter valid mobile number");
        }

        if ((etUserNameSU.getText().toString().isEmpty())) {
            etUserNameSU.requestFocus();
            etUserNameSU.setError("Please enter valid name");
        }

        if (!(cbTermsConditionsH.isChecked()))
            Toast.makeText(SignUpActivity.this, "Please agree terms and conditions",
                    Toast.LENGTH_SHORT).show();
    }
}