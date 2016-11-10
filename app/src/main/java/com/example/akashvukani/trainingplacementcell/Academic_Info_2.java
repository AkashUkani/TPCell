package com.example.akashvukani.trainingplacementcell;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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


public class Academic_Info_2 extends Fragment {
    public TextView message;

    public EditText degree_sem1,degree_sem2,degree_sem3,degree_sem4,degree_sem5,degree_sem6,degree_sem7,degree_sem8;
    public Button submit;

    final String url=config.url+"/academics2";

    public Academic_Info_2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_academic__info_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        degree_sem1 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem1);
        degree_sem2 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem2);
        degree_sem3 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem3);
        degree_sem4 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem4);
        degree_sem5 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem5);
        degree_sem6 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem6);
        degree_sem7 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem7);
        degree_sem8 = (EditText) getActivity().findViewById(R.id.data_entry_degree_sem8);

        submit = (Button) getActivity().findViewById(R.id.submit_academic_info_2);

        message = (TextView) getActivity().findViewById(R.id.messageForDegreeInfo2);

        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("forLogin",Context.MODE_PRIVATE);

        String data=sharedPreferences.getString("data3","0");
        final String d2d = sharedPreferences.getString("d2d","");
        String data_of_2 = sharedPreferences.getString("data2","0");
        if(data.equals("1")){
            message.setText("You have already filled this data");
            String degreesem3 = sharedPreferences.getString("degree_sem3","");
            degree_sem3.setText(degreesem3);
            degree_sem3.setEnabled(false);
            String degreesem4 = sharedPreferences.getString("degree_sem4","");
            degree_sem4.setText(degreesem4);
            degree_sem4.setEnabled(false);
            String degreesem5 = sharedPreferences.getString("degree_sem5","");
            degree_sem5.setText(degreesem5);
            degree_sem5.setEnabled(false);
            String degreesem6 = sharedPreferences.getString("degree_sem6","");
            degree_sem6.setText(degreesem6);
            degree_sem6.setEnabled(false);
            String degreesem7 = sharedPreferences.getString("degree_sem7","");
            degree_sem7.setText(degreesem7);
            degree_sem7.setEnabled(false);
            String degreesem8 = sharedPreferences.getString("degree_sem8","");
            degree_sem8.setText(degreesem8);
            degree_sem8.setEnabled(false);
            if(d2d.equals("1")){
                degree_sem1.setEnabled(false);
                degree_sem2.setEnabled(false);
            }
            else{
                String degreesem1 = sharedPreferences.getString("degree_sem1","");
                degree_sem1.setText(degreesem1);
                degree_sem1.setEnabled(false);
                String degreesem2 = sharedPreferences.getString("degree_sem2","");
                degree_sem2.setText(degreesem2);
                degree_sem2.setEnabled(false);
            }
            submit.setEnabled(false);
        }else if(d2d.equals("0")) {
            message.setText("You are Degree Student. Right ? if not than please contact Your TPC to get it right");
            degree_sem1.setEnabled(true);
            degree_sem2.setEnabled(true);
            degree_sem3.setEnabled(true);
            degree_sem4.setEnabled(true);
            degree_sem5.setEnabled(true);
            degree_sem6.setEnabled(true);
            degree_sem7.setEnabled(true);
            degree_sem8.setEnabled(true);
        }else if(d2d.equals("1")){
            message.setText("You have done Diploma. Right ? if not than please contact your TPC to get it right");
            degree_sem1.setHint("It's Degree sem 1 marks, thus It's not for you");
            degree_sem2.setHint("It's Degree sem 2 marks, thus It's not for you");
            degree_sem1.setEnabled(false);
            degree_sem2.setEnabled(false);
            degree_sem3.setEnabled(true);
            degree_sem4.setEnabled(true);
            degree_sem5.setEnabled(true);
            degree_sem6.setEnabled(true);
            degree_sem7.setEnabled(true);
            degree_sem8.setEnabled(true);
        } else if(data_of_2.equals("0")){
            message.setText("You haven't yet filled Academic Info1. So first fill data of section 1 than you will be allowed to fill this section");
            degree_sem1.setEnabled(false);
            degree_sem2.setEnabled(false);
            degree_sem3.setEnabled(false);
            degree_sem4.setEnabled(false);
            degree_sem5.setEnabled(false);
            degree_sem6.setEnabled(false);
            degree_sem7.setEnabled(false);
            degree_sem8.setEnabled(false);
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setBackgroundResource(R.drawable.button_design2);
                submit.setText("Please Wait....");
                final String degreesem1 = degree_sem1.getText().toString();
                final String degreesem2 = degree_sem2.getText().toString();
                final String degreesem3 = degree_sem3.getText().toString();
                final String degreesem4 = degree_sem4.getText().toString();
                final String degreesem5 = degree_sem5.getText().toString();
                final String degreesem6 = degree_sem6.getText().toString();
                final String degreesem7 = degree_sem7.getText().toString();
                final String degreesem8 = degree_sem8.getText().toString();
                if(degreesem3.equals("")){
                    degree_sem3.setError("Please Enter SPI of sem 3");
                }else if(degreesem4.equals("")){
                    degree_sem4.setError("Please Enter SPI of sem 4");
                }else if(degreesem5.equals("")){
                    degree_sem5.setError("Please Enter SPI of sem 5");
                }else if(degreesem6.equals("")){
                    degree_sem6.setError("Please Enter SPI of sem 6");
                }else if(degreesem7.equals("")){
                    degree_sem7.setError("Please Enter SPI of sem 7");
                }else if(degreesem8.equals("")){
                    degree_sem8.setError("Please Enter SPI of sem 8");
                }else if(d2d.equals("0") && degreesem1.equals("")){
                    degree_sem1.setError("Please Enter SPI of sem1");
                }else if(d2d.equals("0") && degreesem2.equals("")){
                    degree_sem2.setError("Please Enter SPI of sem2");
                }else {

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("degree_sem3", degreesem3);
                        jsonObject.put("degree_sem4", degreesem4);
                        jsonObject.put("degree_sem5", degreesem5);
                        jsonObject.put("degree_sem6", degreesem6);
                        jsonObject.put("degree_sem7", degreesem7);
                        jsonObject.put("degree_sem8", degreesem8);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (d2d.equals("0")) {
                        try {
                            jsonObject.put("degree_sem1", degreesem1);
                            jsonObject.put("degree_sem2", degreesem2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    submit.setText("SUBMIT");
                                    String s = null;
                                    try {
                                        s =response.getString("answer");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(getActivity(), "Successfully Done "+s, Toast.LENGTH_LONG).show();
                                    if(s.equals("1") && d2d.equals("0")){
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("data3", "1");
                                        editor.putString("degree_sem3",degreesem3);
                                        editor.putString("degree_sem4",degreesem4);
                                        editor.putString("degree_sem5",degreesem5);
                                        editor.putString("degree_sem6",degreesem6);
                                        editor.putString("degree_sem7",degreesem7);
                                        editor.putString("degree_sem8",degreesem8);
                                        editor.commit();
                                    }else if(s.equals("1") && d2d.equals("0")){
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("data3", "1");
                                        editor.putString("degree_sem1",degreesem1);
                                        editor.putString("degree_sem2",degreesem2);
                                        editor.putString("degree_sem3",degreesem3);
                                        editor.putString("degree_sem4",degreesem4);
                                        editor.putString("degree_sem5",degreesem5);
                                        editor.putString("degree_sem6",degreesem6);
                                        editor.putString("degree_sem7",degreesem7);
                                        editor.putString("degree_sem8",degreesem8);
                                        editor.commit();
                                    }
                                    submit.setEnabled(false);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                                }
                            });
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(jsonObjectRequest);
                    submit.setBackgroundResource(R.drawable.button_design1);
                }
            }
        });
    }
}