package com.example.alex.berich.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alex.berich.R;

public class RegisterActivity extends Activity  implements View.OnClickListener {


        Button registerBtn;

        @Override
        protected  void onCreate(Bundle onSaveStateInstance){
            super.onCreate(onSaveStateInstance);
            setContentView(R.layout.activity_register);

            registerBtn = (Button) findViewById(R.id.buttonRegister);
            registerBtn.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonRegister:
                    Intent intentRegister = new Intent(this, MainActivity.class);
                    startActivity(intentRegister);
                    break;
                default:
                    break;
            }
        }
    }

