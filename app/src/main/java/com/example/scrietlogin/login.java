package com.example.scrietlogin;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scrietlogin.databinding.ActivityLoginBinding;

public class login extends AppCompatActivity {

    ActivityLoginBinding binding1;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding1 = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding1.getRoot());

        MyHelper1 helper1 = new MyHelper1(this);


        binding1.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, sign.class));
            }
        });

        sp=getSharedPreferences("Data" , MODE_PRIVATE);
        editor=sp.edit();
        boolean login=sp.getBoolean("ISLOGGEDIN" , false);
        if (login==true){
            startActivity(new Intent(login.this,MainActivity.class));
            finish();
        }

        binding1.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = binding1.editusername.getText().toString();
                String pass = binding1.editpassword.getText().toString();

                if (uname.equals("") || pass.equals("")) {
                    Toast.makeText(login.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {

                    boolean checkuserpass = helper1.checkusernameandpassword(uname, pass);
                    if (checkuserpass == true) {
                        if (binding1.checkBox.isChecked()){
                            editor.putString("username" , uname);
                            editor.putString("password" , pass);
                            editor.putBoolean("ISLOGGEDIN" , true);
                            editor.apply();
                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this, MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this, MainActivity.class));
                            finish();
                        }

                    } else {
                        Toast.makeText(login.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }
}