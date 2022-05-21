package com.example.scrietlogin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class quiz extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.login));
    }
}