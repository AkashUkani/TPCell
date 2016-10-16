package com.example.akashvukani.trainingplacementcell;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_TIME_OUT=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        String url="http://198.12.43.32/splash";

        final SharedPreferences sharedPreferences=getSharedPreferences("forLogin",MODE_PRIVATE);

        String username=sharedPreferences.getString("enrollShared","");
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        //editor.putString("enrollShared",Enroll);
                if(!(username.equals(""))) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("enroll",username);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    String n = null;
                                    try {
                                        n=response.getString("part");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                    String d2d = null;
                                    try {
                                        d2d = response.getString("d2d");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    if(n.equals("3")){
                                        editor.putString("part",n);
                                        try {

                                            //editor.putString("degree_sem3",);
                                            final String degree_sem3 = response.getString("degree_sem3");
                                            final String degree_sem4 = response.getString("degree_sem4");
                                            final String degree_sem5 = response.getString("degree_sem5");
                                            final String degree_sem6 = response.getString("degree_sem6");
                                            final String degree_sem7 = response.getString("degree_sem7");
                                            final String degree_sem8 = response.getString("degree_sem8");
                                            editor.putString("degree_sem3",degree_sem3);
                                            editor.putString("degree_sem4",degree_sem4);
                                            editor.putString("degree_sem5",degree_sem5);
                                            editor.putString("degree_sem6",degree_sem6);
                                            editor.putString("degree_sem7",degree_sem7);
                                            editor.putString("degree_sem8",degree_sem8);

                                            if(d2d.equals("0")){
                                                final String degree_sem1 = response.getString("degree_sem1");
                                                final String degree_sem2 = response.getString("degree_sem1");
                                                editor.putString("degree_sem1",degree_sem1);
                                                editor.putString("degree_sem2",degree_sem2);
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        n="2";
                                    }
                                    if(n.equals("2")){
                                        try {
                                            final String ten_marks = response.getString("10_marks");
                                            final String ten_year = response.getString("10_year");
                                            final String twelve_marks = response.getString("12_marks");
                                            final String twelve_year = response.getString("12_year");
                                            editor.putString("10_marks",ten_marks);
                                            editor.putString("10_year",ten_year);
                                            editor.putString("12_marks",twelve_marks);
                                            editor.putString("12_year",twelve_year);

                                            if(d2d.equals("1")){
                                                final String d2d_sem1 = response.getString("d2d_sem1");
                                                final String d2d_sem2 = response.getString("d2d_sem2");
                                                final String d2d_sem3 = response.getString("d2d_sem3");
                                                final String d2d_sem4 = response.getString("d2d_sem4");
                                                final String d2d_sem5 = response.getString("d2d_sem5");
                                                final String d2d_sem6 = response.getString("d2d_sem6");

                                                editor.putString("d2d_sem1",d2d_sem1);
                                                editor.putString("d2d_sem2",d2d_sem2);
                                                editor.putString("d2d_sem3",d2d_sem3);
                                                editor.putString("d2d_sem4",d2d_sem4);
                                                editor.putString("d2d_sem5",d2d_sem5);
                                                editor.putString("d2d_sem6",d2d_sem6);
                                            }

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        n="1";
                                    }
                                    if(n.equals("1")){
                                        try {
                                            JSONObject personal = response.getJSONObject("personal");

                                            final String firstname = personal.getString("first_name");
                                            final String lastname = personal.getString("last_name");;
                                            final String middlename = personal.getString("middle_name");;
                                            final String birthdate = personal.getString("birth_date");;
                                            final String email = personal.getString("email");;
                                            final String cast = personal.getString("cast");;
                                            final String contact_no = personal.getString("contact_no");;

                                            JSONObject address = response.getJSONObject("address");

                                            final String house_no = address.getString("house_no");;
                                            final String street_no = address.getString("street_no");;
                                            final String landmark = address.getString("landmark");;
                                            final String area = address.getString("area");;
                                            final String city = address.getString("city");;
                                            final String pin_code = address.getString("pin_code");;
                                            final String state = address.getString("state");

                                            editor.putString("first_name",firstname);
                                            editor.putString("last_name",lastname);
                                            editor.putString("middle_name",middlename);
                                            editor.putString("birth_date",birthdate);
                                            editor.putString("email",email);
                                            editor.putString("cast",cast);
                                            editor.putString("cotact_no",contact_no);
                                            editor.putString("house_no",house_no);
                                            editor.putString("street_no",street_no);
                                            editor.putString("landmark",landmark);
                                            editor.putString("area",area);
                                            editor.putString("city",city);
                                            editor.putString("pin_code",pin_code);
                                            editor.putString("state",state);

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            });
                    RequestQueue requestQueue= Volley.newRequestQueue(getApplication());
                    requestQueue.add(jsonObjectRequest);

                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, SPLASH_TIME_OUT);
                }


    }
}