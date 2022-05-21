package com.example.scrietlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scrietlogin.databinding.ActivitySignBinding;

public class sign extends AppCompatActivity {

    ActivitySignBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyHelper1 helper1 = new MyHelper1(this);

        binding.signupBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = binding.editusername.getText().toString();
                String em = binding.editemail.getText().toString();
                String pass = binding.editpassword.getText().toString();

                if (uname.equals("") || em.equals("") || pass.equals("")) {
                    Toast.makeText(sign.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {

                    boolean i = helper1.checkusername(uname);
                    if (i == false) {
                        boolean inserd = helper1.insertdata(uname, em, pass);
                        if (inserd == true) {
                            Toast.makeText(sign.this, "Record Saved", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(sign.this, login.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(sign.this, "Failed to saved record", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(sign.this, "Already Exist ", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}