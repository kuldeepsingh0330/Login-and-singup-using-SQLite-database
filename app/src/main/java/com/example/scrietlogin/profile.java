package com.example.scrietlogin;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.login));

    }
}