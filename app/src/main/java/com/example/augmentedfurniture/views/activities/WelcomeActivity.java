package com.example.augmentedfurniture.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.augmentedfurniture.R;

public class WelcomeActivity extends AppCompatActivity {

    Long splashTime = 1500L;
    Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        myHandler = new Handler();
        myHandler.postDelayed(this::changeActivity, splashTime);
    }

    private void changeActivity() {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        finish();
    }
}