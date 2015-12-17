package com.example.alex.berich.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alex.berich.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    Button loginBtn;
    Button registerBtn;

    @Override
    protected  void onCreate(Bundle onSaveStateInstance){
        super.onCreate(onSaveStateInstance);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.buttonLogin);
        registerBtn = (Button) findViewById(R.id.buttonRegister);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonLogin:
                Intent intentLogin = new Intent(this, MainActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.buttonRegister:
                Intent intentRegister = new Intent(this, RegisterActivity.class);
                startActivity(intentRegister);
                break;


            default:
                break;
        }

    }

}
