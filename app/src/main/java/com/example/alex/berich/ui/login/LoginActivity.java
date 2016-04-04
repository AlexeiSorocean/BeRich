package com.example.alex.berich.ui.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alex.berich.R;
import com.example.alex.berich.activities.MainActivity;
import com.example.alex.berich.ui.singup.SignUpActivity;
import com.example.alex.berich.injection.component.ActivityComponent;
import com.example.alex.berich.ui.base.BaseActivity;


import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginMvpView{

        protected EditText username;
        protected EditText password;
        protected Button loginButton;
        protected TextView signUpTextView;

        private ActivityComponent activityComponent;

        @Inject
        LoginPresenter loginPresenter;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            getActivityComponent().inject(this);

            signUpTextView = (TextView)findViewById(R.id.signUpText);
            signUpTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            });

            username = (EditText)findViewById(R.id.usernameField);
            password = (EditText)findViewById(R.id.passwordField);
            loginButton = (Button)findViewById(R.id.loginButton);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginPresenter.checkUserImput(username.getText().toString(), password.getText().toString());
                }
            });
        }

    @Override
    public void showFiledValidationFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage(R.string.login_error_message)
                .setTitle(R.string.login_error_title)
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showLoginFailed(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage(message)
                .setTitle(R.string.login_error_title)
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


}