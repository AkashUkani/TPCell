package com.example.akashvukani.trainingplacementcell;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText enroll;
    private EditText pass;

    final String url="http://192.168.43.98:8000/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView logintext=(TextView)findViewById(R.id.logintext1);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"Allura-Regular.otf");
        logintext.setTypeface(custom_font);

        loginButton=(Button)findViewById(R.id.LoginButton);
        loginButton.setBackgroundResource(R.drawable.button_design_for_login_page);

        final SharedPreferences sharedPreferences=getSharedPreferences("forLogin",MODE_PRIVATE);

        enroll=(EditText)findViewById(R.id.enrollLogin);
        pass=(EditText)findViewById(R.id.passwordLogin);
        pass.setTypeface(Typeface.DEFAULT);
        pass.setTransformationMethod(new PasswordTransformationMethod());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  ProgressDialog pDialog = new ProgressDialog();
                pDialog.setMessage("Loading products. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(false);
                pDialog.show();
                pDialog.cancel();
                */
                loginButton.setBackgroundResource(R.drawable.button_design_for_login_page_1);
                loginButton.setText("Please Wait....");
                final String Enroll=enroll.getText().toString();
                final String Pass=pass.getText().toString();
                /*SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("enrollShared",Enroll);
                editor.commit();
                onLogin();*/

                JSONObject jsonBody=new JSONObject();
                try {
                    jsonBody.put("enroll",Enroll);
                    jsonBody.put("pass",Pass);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                String check="";
                                try {
                                    check=response.getString("success");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                if(check.equals("1")){
                                    SharedPreferences.Editor editor=sharedPreferences.edit();
                                    editor.putString("enrollShared",Enroll);
                                    String n = null;
                                    String d2d = null;
                                    try {
                                        n=response.getString("part");
                                        d2d = response.getString("d2d");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    if(n.equals("3")){
                                        editor.putString("data3","1");
                                        try {
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
                                        editor.putString("data2","1");
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

                                                editor.putString("d2d","1");
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
                                        editor.putString("data1","1");
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

                                    editor.commit();

                                    onLogin();
                                }
                                else{
                                    loginButton.setBackgroundResource(R.drawable.button_design_for_login_page);
                                    loginButton.setText("LOGIN");
                                    enroll.setError("Enrollment and Password don't match. Make sure you enter right password.");
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                RequestQueue requestQueue= Volley.newRequestQueue(getApplication());
                requestQueue.add(jsonObjectRequest);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.next) {
            Toast.makeText(getApplicationContext(),"Hello 1",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onLogin(){
        loginButton.setText("LOGIN");
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
