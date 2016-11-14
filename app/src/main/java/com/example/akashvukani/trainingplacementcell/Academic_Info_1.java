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
import android.widget.ProgressBar;
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
    public EditText d2d_sem1,d2d_sem2,d2d_sem3,d2d_sem4,d2d_sem5,d2d_sem6,d2d_year,d2d_cpi;

    public Button submit;
    private ProgressBar progress;

    final String url=config.url+"/academics1";

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
                    marks_12.setText("");
                    passing_year_12.setEnabled(false);
                    passing_year_12.setText("");
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
        d2d_cpi = (EditText)getActivity().findViewById(R.id.data_entry_d2d_cpi);
        d2d_year = (EditText)getActivity().findViewById(R.id.data_entry_diploma_year);
        progress = (ProgressBar) getActivity().findViewById(R.id.progressBar);

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
                String d2dcpi = sharedPreferences.getString("d2d_cpi","");
                d2d_cpi.setText(d2dcpi);
                d2d_cpi.setEnabled(false);
                String d2dyear = sharedPreferences.getString("d2d_year","");
                d2d_year.setText(d2dyear);
                d2d_year.setEnabled(false);
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
                    d2d_cpi.setEnabled(true);
                    d2d_year.setEnabled(true);
                }
                else{
                    d2d_sem1.setEnabled(false);
                    d2d_sem2.setEnabled(false);
                    d2d_sem3.setEnabled(false);
                    d2d_sem4.setEnabled(false);
                    d2d_sem5.setEnabled(false);
                    d2d_sem6.setEnabled(false);
                    d2d_cpi.setEnabled(false);
                    d2d_year.setEnabled(false);
                    d2d_sem1.setText("");
                    d2d_sem2.setText("");
                    d2d_sem3.setText("");
                    d2d_sem4.setText("");
                    d2d_sem5.setText("");
                    d2d_sem6.setText("");
                    d2d_cpi.setText("");
                    d2d_year.setText("");
                }
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setBackgroundResource(R.drawable.button_design2);
                progress.setVisibility(View.VISIBLE);
                submit.setText("");
                final String ten_marks = marks_10.getText().toString();
                final String ten_year = passing_year_10.getText().toString();
                final String twelve_marks ;
                final String twelve_year;
                String twelve = "0";
                if(check_12.isChecked()){
                    twelve="1";
                    twelve_marks = marks_12.getText().toString();
                    twelve_year = passing_year_12.getText().toString();
                }else {
                    twelve_marks = null;
                    twelve_year = null;
                }
                final String d2d;
                final String d2dsem1;
                final String d2dsem2;
                final String d2dsem3;
                final String d2dsem4;
                final String d2dsem5;
                final String d2dsem6;
                final String d2dyear;
                final String d2dcpi;
                if(check_d2d.isChecked()){
                    d2d="1";
                    d2dsem1 = d2d_sem1.getText().toString();
                    d2dsem2 = d2d_sem2.getText().toString();
                    d2dsem3 = d2d_sem3.getText().toString();
                    d2dsem4 = d2d_sem4.getText().toString();
                    d2dsem5 = d2d_sem5.getText().toString();
                    d2dsem6 = d2d_sem6.getText().toString();
                    d2dcpi = d2d_cpi.getText().toString();
                    d2dyear = d2d_year.getText().toString();
                }else{
                    d2d = "0";
                    d2dsem1 = null;
                    d2dsem2 = null;
                    d2dsem3 = null;
                    d2dsem4 = null;
                    d2dsem5 = null;
                    d2dsem6 = null;
                    d2dcpi = null;
                    d2dyear = null;
                }
                int flag=0;
                if(ten_marks.equals("")) {
                    flag=1;
                    marks_10.setError("Please Enter marks of 10 standard");
                } else if(ten_year.equals("")) {
                    flag=1;
                    passing_year_10.setError("Please Enter passing year of 10 standard");
                } else if(twelve_marks.equals("") && twelve.equals("1")) {
                    flag=1;
                    marks_12.setError("Please Enter marks of 12 standard");
                } else if(twelve_year.equals("") && twelve.equals("1")) {
                    flag=1;
                    passing_year_12.setError("Please Enter passing year of 12 standard");
                }
                else if(d2d.equals("1") && d2dsem1.equals("")) {
                    flag=1;
                    d2d_sem1.setError("Please Enter SPI of Diploma Sem 1");
                } else if(d2d.equals("1") && d2dsem2.equals("")){
                    flag=1;
                    d2d_sem2.setError("Please Enter SPI of Diploma Sem 2");
                } else if(d2d.equals("1") && d2dsem3.equals("")){
                    flag=1;
                    d2d_sem3.setError("Please Enter SPI of Diploma Sem 3");
                } else if(d2d.equals("1") && d2dsem4.equals("")){
                    flag=1;
                    d2d_sem4.setError("Please Enter SPI of Diploma Sem 4");
                } else if(d2d.equals("1") && d2dsem5.equals("")){
                    flag=1;
                    d2d_sem5.setError("Please Enter SPI of Diploma Sem 5");
                } else if(d2d.equals("1") && d2dsem6.equals("")){
                    flag=1;
                    d2d_sem6.setError("Please Enter SPI of Diploma Sem 6");
                }
                else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        String enroll = sharedPreferences.getString("enrollShared","");
                        jsonObject.put("enrollment",enroll);
                        jsonObject.put("10_marks", ten_marks);
                        jsonObject.put("10_year", ten_year);
                        jsonObject.put("12_marks", twelve_marks);
                        jsonObject.put("12_year", twelve_year);
                        jsonObject.put("d2d",d2d);
                        if(d2d.equals("1")){
                            jsonObject.put("d2d_sem1",d2dsem1);
                            jsonObject.put("d2d_sem2",d2dsem2);
                            jsonObject.put("d2d_sem3",d2dsem3);
                            jsonObject.put("d2d_sem4",d2dsem4);
                            jsonObject.put("d2d_sem5",d2dsem5);
                            jsonObject.put("d2d_sem6",d2dsem6);
                            jsonObject.put("d2d_cpi",d2dcpi);
                            jsonObject.put("d2d_year",d2dyear);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    submit.setText("SUBMIT");
                                    String s = null;
                                    try {
                                        s =  response.getString("answer");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(getActivity(),"Successfully Done "+s,Toast.LENGTH_LONG).show();
                                    progress.setVisibility(View.GONE);
                                    submit.setText("SUBMIT");
                                    submit.setBackgroundResource(R.drawable.button_design1);
                                    if(s.equals("1") && d2d.equals("0")){
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("10_marks",ten_marks);
                                        editor.putString("10_year",ten_year);
                                        editor.putString("12_marks",twelve_marks);
                                        editor.putString("12_year",twelve_year);
                                        editor.putString("data2","1");
                                        editor.commit();
                                    } else if(s.equals("1") && d2d.equals("1")){
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("10_marks",ten_marks);
                                        editor.putString("10_year",ten_year);
                                        editor.putString("12_marks",twelve_marks);
                                        editor.putString("12_year",twelve_year);
                                        editor.putString("d2d_sem1",d2dsem1);
                                        editor.putString("d2d_sem2",d2dsem2);
                                        editor.putString("d2d_sem3",d2dsem3);
                                        editor.putString("d2d_sem4",d2dsem4);
                                        editor.putString("d2d_sem5",d2dsem5);
                                        editor.putString("d2d_sem6",d2dsem6);
                                        editor.putString("d2d_cpi",d2dcpi);
                                        editor.putString("d2d_year",d2dyear);
                                        editor.putString("data2","1");
                                        editor.commit();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();
                                    progress.setVisibility(View.GONE);
                                    submit.setText("SUBMIT");
                                    submit.setBackgroundResource(R.drawable.button_design1);
                                }
                            });
                    RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
                    requestQueue.add(jsonObjectRequest);
                }
                if(flag==1){
                    progress.setVisibility(View.GONE);
                    submit.setText("SUBMIT");
                    submit.setBackgroundResource(R.drawable.button_design1);
                }
            }
        });
    }
}
