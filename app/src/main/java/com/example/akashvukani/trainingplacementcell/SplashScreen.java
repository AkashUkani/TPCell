package com.example.akashvukani.trainingplacementcell;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_TIME_OUT=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final SharedPreferences sharedPreferences=getSharedPreferences("forLogin",MODE_PRIVATE);

        final String username=sharedPreferences.getString("enrollShared","");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    if(username.equals("")) {
                        Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
        }, SPLASH_TIME_OUT);

    }
}