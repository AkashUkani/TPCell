package com.example.akashvukani.trainingplacementcell;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

    final String url="http://10.10.10.109:8000/test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView logintext=(TextView)findViewById(R.id.logintext1);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"Allura-Regular.otf");
        logintext.setTypeface(custom_font);

        loginButton=(Button)findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        });

        final SharedPreferences sharedPreferences=getSharedPreferences("forLogin",MODE_PRIVATE);

        enroll=(EditText)findViewById(R.id.enrollLogin);
        pass=(EditText)findViewById(R.id.passwordLogin);
        pass.setTypeface(Typeface.DEFAULT);
        pass.setTransformationMethod(new PasswordTransformationMethod());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Enroll=enroll.getText().toString();
                final String Pass=pass.getText().toString();

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("enrollShared",Enroll);
                editor.commit();
                onLogin();
                /*JSONObject jsonBody=new JSONObject();
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
                                    editor.commit();
                                    onLogin();
                                }
                                else{
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
                requestQueue.add(jsonObjectRequest); */

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
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
