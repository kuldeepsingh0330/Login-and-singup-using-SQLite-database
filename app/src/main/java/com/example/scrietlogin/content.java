package com.example.scrietlogin;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);


        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.login));
    }
}