package com.example.scrietlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.scrietlogin.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


    ActivityMainBinding binding;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView pro, pay, con, att, ses, qui;
    private long pressedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp = getSharedPreferences("Data", MODE_PRIVATE);
        editor = sp.edit();

        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener((this));
        navigationView.setCheckedItem(R.id.dash);

        pro = findViewById(R.id.cardprofile);
        pay = findViewById(R.id.cardpayment);
        con = findViewById(R.id.cardcontent);
        att = findViewById(R.id.cardattendance);
        ses = findViewById(R.id.cardsessional);
        qui = findViewById(R.id.cardquiz);

        pro.setOnClickListener(this);
        pay.setOnClickListener(this);
        con.setOnClickListener(this);
        att.setOnClickListener(this);
        ses.setOnClickListener(this);
        qui.setOnClickListener(this);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.login));

    }


    private void logout() {

        editor.clear();
        editor.apply();
        startActivity(new Intent(MainActivity.this, login.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.cardprofile:
                i = new Intent(this, profile.class);
                startActivity(i);
                break;
            case R.id.cardpayment:
                i = new Intent(this, payment.class);
                startActivity(i);
                break;
            case R.id.cardcontent:
                i = new Intent(this, content.class);
                startActivity(i);
                break;
            case R.id.cardattendance:
                i = new Intent(this, attendance.class);
                startActivity(i);
                break;
            case R.id.cardsessional:
                i = new Intent(this, sessional.class);
                startActivity(i);
                break;
            case R.id.cardquiz:
                i = new Intent(this, quiz.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.dash:
                break;
            case R.id.prof:
                Intent pro = new Intent(MainActivity.this, profile.class);
                startActivity(pro);
                break;
            case R.id.paym:
                Intent pay = new Intent(MainActivity.this, payment.class);
                startActivity(pay);
                break;
            case R.id.cont:
                Intent con = new Intent(MainActivity.this, content.class);
                startActivity(con);
                break;
            case R.id.atte:
                Intent att = new Intent(MainActivity.this, attendance.class);
                startActivity(att);
                break;
            case R.id.sess:
                Intent ses = new Intent(MainActivity.this, sessional.class);
                startActivity(ses);
                break;
            case R.id.qu:
                Intent qui = new Intent(MainActivity.this, quiz.class);
                startActivity(qui);
                break;
            case R.id.share:
                Toast.makeText(getBaseContext(), "Available soon", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

}