package com.example.akashvukani.trainingplacementcell;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Academic_Info_1 extends Fragment {

    public EditText marks_10,passing_year_10;

    public CheckBox check_12;
    public EditText marks_12,passing_year_12;

    public CheckBox check_d2d;
    public EditText d2d_sem1,d2d_sem2,d2d_sem3,d2d_sem4,d2d_sem5,d2d_sem6;

    public Button submit;

    final String url="http://10.10.10.109:8000/login";

    public Academic_Info_1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_academic__info_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        marks_10 = (EditText)getActivity().findViewById(R.id.data_entry_10th);
        passing_year_10 = (EditText)getActivity().findViewById(R.id.data_entry_10th_year);

        check_12 = (CheckBox)getActivity().findViewById(R.id.data_entry_checkbox_for_12);
        marks_12 = (EditText)getActivity().findViewById(R.id.data_entry_12th);
        passing_year_12 = (EditText)getActivity().findViewById(R.id.data_entry_12th_year);

        check_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked()){
                    marks_12.setEnabled(true);
                    passing_year_12.setEnabled(true);
                }
                else{
                    marks_12.setEnabled(false);
                    passing_year_12.setEnabled(false);
                }
            }
        });

        check_d2d = (CheckBox)getActivity().findViewById(R.id.data_entry_checkbox_for_d2d);
        d2d_sem1 = (EditText)getActivity().findViewById(R.id.data_entry_d2d_sem1);
        d2d_sem2 = (EditText)getActivity().findViewById(R.id.data_entry_d2d_sem2);
        d2d_sem3 = (EditText)getActivity().findViewById(R.id.data_entry_d2d_sem3);
        d2d_sem4 = (EditText)getActivity().findViewById(R.id.data_entry_d2d_sem4);
        d2d_sem5 = (EditText)getActivity().findViewById(R.id.data_entry_d2d_sem5);
        d2d_sem6 = (EditText)getActivity().findViewById(R.id.data_entry_d2d_sem6);

        submit= (Button)getActivity().findViewById(R.id.submit_academic_info_1);

        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("forLogin",Context.MODE_PRIVATE);
        final String data=sharedPreferences.getString("data2","");
        if(data.equals("1")){
            String ten_marks = sharedPreferences.getString("10_marks","");
            marks_10.setText(ten_marks);
            marks_10.setEnabled(false);
            String ten_year = sharedPreferences.getString("10_year","");
            passing_year_10.setText(ten_year);
            passing_year_10.setEnabled(false);
            String twelve_marks = sharedPreferences.getString("12_marks","");
            marks_12.setText(twelve_marks);
            marks_12.setEnabled(false);
            String twelve_year = sharedPreferences.getString("12_year","");
            passing_year_12.setText(twelve_year);
            passing_year_12.setEnabled(false);
            String d2d = sharedPreferences.getString("d2d","");
            if(d2d.equals("1")) {
                check_d2d.setChecked(true);
                String d2dsem1 = sharedPreferences.getString("d2d_sem1","");
                d2d_sem1.setText(d2dsem1);
                d2d_sem1.setEnabled(false);
                String d2dsem2 = sharedPreferences.getString("d2d_sem2","");
                d2d_sem2.setText(d2dsem2);
                d2d_sem2.setEnabled(false);
                String d2dsem3 = sharedPreferences.getString("d2d_sem3","");
                d2d_sem3.setText(d2dsem3);
                d2d_sem3.setEnabled(false);
                String d2dsem4 = sharedPreferences.getString("d2d_sem4","");
                d2d_sem4.setText(d2dsem4);
                d2d_sem4.setEnabled(false);
                String d2dsem5 = sharedPreferences.getString("d2d_sem5","");
                d2d_sem5.setText(d2dsem5);
                d2d_sem5.setEnabled(false);
                String d2dsem6 = sharedPreferences.getString("d2d_sem6","");
                d2d_sem6.setText(d2dsem6);
                d2d_sem6.setEnabled(false);
            }
            submit.setEnabled(false);
        }

        check_d2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked()){
                    d2d_sem1.setEnabled(true);
                    d2d_sem2.setEnabled(true);
                    d2d_sem3.setEnabled(true);
                    d2d_sem4.setEnabled(true);
                    d2d_sem5.setEnabled(true);
                    d2d_sem6.setEnabled(true);
                }
                else{
                    d2d_sem1.setEnabled(false);
                    d2d_sem2.setEnabled(false);
                    d2d_sem3.setEnabled(false);
                    d2d_sem4.setEnabled(false);
                    d2d_sem5.setEnabled(false);
                    d2d_sem6.setEnabled(false);
                }
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setBackgroundResource(R.drawable.button_design2);
                submit.setText("Please Wait....");
                String ten_marks = marks_10.getText().toString();
                String ten_year = passing_year_10.getText().toString();
                String twelve_marks = marks_12.getText().toString();
                String twelve_year = passing_year_12.getText().toString();
                String d2d = null;

                String d2dsem1 = null;
                String d2dsem2 = null;
                String d2dsem3 = null;
                String d2dsem4 = null;
                String d2dsem5 = null;
                String d2dsem6 = null;
                if(check_d2d.isChecked()){
                    d2d="1";
                    d2dsem1 = d2d_sem1.getText().toString();
                    d2dsem2 = d2d_sem2.getText().toString();
                    d2dsem3 = d2d_sem3.getText().toString();
                    d2dsem4 = d2d_sem4.getText().toString();
                    d2dsem5 = d2d_sem5.getText().toString();
                    d2dsem6 = d2d_sem6.getText().toString();
                }

                if(ten_marks.equals("")) {
                    marks_10.setError("Please Enter marks of 10 standard");
                } else if(ten_year.equals("")) {
                    passing_year_10.setError("Please Enter passing year of 10 standard");
                } else if(twelve_marks.equals("")) {
                    marks_12.setError("Please Enter marks of 12 standard");
                } else if(twelve_year.equals("")) {
                    passing_year_12.setError("Please Enter passing year of 12 standard");
                }
                else if(d2d.equals("1") && d2dsem1.equals("")) {
                    d2d_sem1.setError("Please Enter SPI of Diploma Sem 1");
                } else if(d2d.equals("1") && d2dsem2.equals("")){
                    d2d_sem2.setError("Please Enter SPI of Diploma Sem 2");
                } else if(d2d.equals("1") && d2dsem3.equals("")){
                    d2d_sem3.setError("Please Enter SPI of Diploma Sem 3");
                } else if(d2d.equals("1") && d2dsem4.equals("")){
                    d2d_sem4.setError("Please Enter SPI of Diploma Sem 4");
                } else if(d2d.equals("1") && d2dsem5.equals("")){
                    d2d_sem5.setError("Please Enter SPI of Diploma Sem 5");
                } else if(d2d.equals("1") && d2dsem6.equals("")){
                    d2d_sem6.setError("Please Enter SPI of Diploma Sem 6");
                }
                else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("10_marks", ten_marks);
                        jsonObject.put("10_year", ten_year);
                        jsonObject.put("12_marks", twelve_marks);
                        jsonObject.put("12_year", twelve_year);
                        jsonObject.put("d2d",d2d);
                        jsonObject.put("d2d_sem1",d2dsem1);
                        jsonObject.put("d2d_sem2",d2dsem2);
                        jsonObject.put("d2d_sem3",d2dsem3);
                        jsonObject.put("d2d_sem4",d2dsem4);
                        jsonObject.put("d2d_sem5",d2dsem5);
                        jsonObject.put("d2d_sem6",d2dsem6);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    submit.setText("SUBMIT");
                                    Toast.makeText(getActivity(),"Successfully Done",Toast.LENGTH_LONG).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();
                                }
                            });
                    RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
                    requestQueue.add(jsonObjectRequest);
                    submit.setBackgroundResource(R.drawable.button_design1);
                }
            }
        });
    }
}
