package com.example.akashvukani.trainingplacementcell;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

    final String url1="http://192.168.43.98:8000/login";
    final String url2="http://192.168.43.98:8000/login";

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

        message = (TextView) getActivity().findViewById(R.id.messageForDegreeInfo2);

        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("forLogin",Context.MODE_PRIVATE);

        String enroll_user=sharedPreferences.getString("enrollShared","");
        JSONObject jsonBody=new JSONObject();
        try {
            jsonBody.put("enroll",enroll_user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url1, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String check="";
                        try {
                            check=response.getString("success");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(check.equalsIgnoreCase("Degree")){
                            message.setText("You are Degree Student. Right ? if not than please filled again Academic info 1");
                            degree_sem1.setEnabled(true);
                            degree_sem2.setEnabled(true);
                            degree_sem3.setEnabled(true);
                            degree_sem4.setEnabled(true);
                            degree_sem5.setEnabled(true);
                            degree_sem6.setEnabled(true);
                            degree_sem7.setEnabled(true);
                            degree_sem8.setEnabled(true);
                        }
                        else if(check.equalsIgnoreCase("D2D")){
                            message.setText("You have done Diploma. Right ? if not than please filled again Academic info 1");
                            degree_sem1.setHint("It's not for you");
                            degree_sem2.setHint("It's not for you");
                            degree_sem1.setEnabled(false);
                            degree_sem2.setEnabled(false);
                            degree_sem3.setEnabled(true);
                            degree_sem4.setEnabled(true);
                            degree_sem5.setEnabled(true);
                            degree_sem6.setEnabled(true);
                            degree_sem7.setEnabled(true);
                            degree_sem8.setEnabled(true);
                        }
                        else{
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
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonObjectRequest);

        submit = (Button) getActivity().findViewById(R.id.submit_academic_info_2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setBackgroundResource(R.drawable.button_design2);





                submit.setBackgroundResource(R.drawable.button_design1);
            }
        });
    }
}