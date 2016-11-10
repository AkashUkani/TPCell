package com.example.akashvukani.trainingplacementcell;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Personal_Info_Fragment extends Fragment {


    private EditText FirstName;
    private EditText LastName;
    private EditText MiddleName;
    private EditText BirthDate;
    private EditText Email;
    private EditText Contact_No;
    private EditText House_No;
    private EditText Street_Name;
    private EditText City;
    private EditText State;
    private EditText Pin_Code;
    private EditText Cast;
    private EditText Area;
    private EditText Landmark;
    private Button submit;
    private ProgressBar progress;

    final String url=config.url+"/personal";

    public Personal_Info_Fragment() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("forLogin", Context.MODE_PRIVATE);
        final String enrollment=sharedPreferences.getString("enrollShared","");

        FirstName = (EditText) getActivity().findViewById(R.id.data_entry_first_name);
        LastName = (EditText) getActivity().findViewById(R.id.data_entry_last_name);
        MiddleName = (EditText) getActivity().findViewById(R.id.data_entry_middle_name);
        BirthDate = (EditText) getActivity().findViewById(R.id.data_entry_birth_date);
        Email = (EditText) getActivity().findViewById(R.id.data_entry_email);
        Contact_No = (EditText) getActivity().findViewById(R.id.data_entry_contact_no);
        House_No = (EditText) getActivity().findViewById(R.id.data_entry_house_no);
        Street_Name = (EditText) getActivity().findViewById(R.id.data_entry_street_name);
        City = (EditText) getActivity().findViewById(R.id.data_entry_city);
        State = (EditText) getActivity().findViewById(R.id.data_entry_state);
        Pin_Code = (EditText) getActivity().findViewById(R.id.data_entry_pin_code);
        Cast = (EditText) getActivity().findViewById(R.id.data_entry_cast);
        Area = (EditText) getActivity().findViewById(R.id.data_entry_area);
        Landmark = (EditText) getActivity().findViewById(R.id.data_entry_landmark);
        progress = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        submit=(Button)getActivity().findViewById(R.id.submit_person_info);

        final String data=sharedPreferences.getString("data1","");

        if(data.equals("1")){
            final String firstname = sharedPreferences.getString("first_name","");
            FirstName.setText(firstname);
            FirstName.setEnabled(false);
            final String lastname = sharedPreferences.getString("last_name","");
            LastName.setText(lastname);
            LastName.setEnabled(false);
            final String middlename = sharedPreferences.getString("middle_name","");
            MiddleName.setText(middlename);
            MiddleName.setEnabled(false);
            final String birthdate = sharedPreferences.getString("birth_date","");
            BirthDate.setText(birthdate);
            BirthDate.setEnabled(false);
            final String email = sharedPreferences.getString("email","");
            Email.setText(email);
            Email.setEnabled(false);
            final String cast = sharedPreferences.getString("cast","");
            Cast.setText(cast);
            Cast.setEnabled(false);

            final String contact_no = sharedPreferences.getString("contact_no","");
            Contact_No.setText(contact_no);
            Contact_No.setEnabled(false);
            final String house_no = sharedPreferences.getString("house_no","");
            House_No.setText(house_no);
            House_No.setEnabled(false);
            final String street_no = sharedPreferences.getString("street_name","");
            Street_Name.setText(street_no);
            Street_Name.setEnabled(false);
            final String landmark = sharedPreferences.getString("landmark","");
            Landmark.setEnabled(false);
            Landmark.setText(landmark);
            final String area = sharedPreferences.getString("area","");
            Area.setText(area);
            Area.setEnabled(false);

            final String city = sharedPreferences.getString("city","");
            City.setText(city);
            City.setEnabled(false);
            final String pin_code = sharedPreferences.getString("pin_code","");
            Pin_Code.setText(pin_code);
            Pin_Code.setEnabled(false);
            final String state = sharedPreferences.getString("state","");
            State.setText(state);
            State.setEnabled(false);

            submit.setEnabled(false);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setBackgroundResource(R.drawable.button_design2);
                progress.setVisibility(View.VISIBLE);
                submit.setText("");
                final String firstname = FirstName.getText().toString();
                final String lastname = LastName.getText().toString();
                final String middlename = MiddleName.getText().toString();
                final String birthdate = BirthDate.getText().toString();
                final String email = BirthDate.getText().toString();
                final String cast = Cast.getText().toString();

                final String contact_no = Contact_No.getText().toString();
                final String house_no = House_No.getText().toString();
                final String street_name = Street_Name.getText().toString();
                final String landmark = Landmark.getText().toString();
                final String area = Area.getText().toString();

                final String city = City.getText().toString();
                final String pin_code = State.getText().toString();
                final String state = Pin_Code.getText().toString();

                if(TextUtils.isEmpty(firstname)){
                    FirstName.setError("Please Enter your First Name");
                }else if(TextUtils.isEmpty(middlename)){
                    MiddleName.setError("Please Enter your Middle Name");
                }else if(TextUtils.isEmpty(lastname)){
                    LastName.setError("Please Enter your Last Name");
                }else if(TextUtils.isEmpty(birthdate)){
                    BirthDate.setError("Please Enter your Birth Date");
                }else if(TextUtils.isEmpty(email)){
                    Email.setError("Please Enter your Email");
                }else if(TextUtils.isEmpty(contact_no)){
                    Contact_No.setError("Please Enter your Contact no");;
                }else if(cast.equals(cast)){
                    Cast.setError("Please Enter your cast");
                }else if(TextUtils.isEmpty(contact_no)){
                    House_No.setError("Please Enter your Contact no");;
                }else if(TextUtils.isEmpty(house_no)){
                    Street_Name.setError("Please Enter your House no");
                }else if(TextUtils.isEmpty(street_name)){
                    Area.setError("Please Enter Street Name");
                }else if(TextUtils.isEmpty(city)){
                    City.setError("Please Enter your City");;
                }else if(TextUtils.isEmpty(pin_code)){
                    Pin_Code.setError("Please Enter Pin Code");;
                }else if(TextUtils.isEmpty(state)){
                    State.setError("Please Enter your Contact no");;
                }else {
                    JSONObject jsonbody = new JSONObject();
                    JSONObject jsonbody1 = new JSONObject();
                    JSONObject jsonbody2 = new JSONObject();
                    try {
                        jsonbody1.put("enrollment", enrollment);
                        jsonbody1.put("first_name", firstname);
                        jsonbody1.put("last_name", lastname);
                        jsonbody1.put("middle_name", middlename);
                        jsonbody1.put("birth_date", birthdate);
                        jsonbody1.put("email", email);
                        jsonbody1.put("contact_no", contact_no);
                        jsonbody1.put("cast", cast);
                        jsonbody.put("personal",jsonbody1);

                        jsonbody2.put("house_no", house_no);
                        jsonbody2.put("street_name", street_name);
                        jsonbody2.put("landmark", landmark);
                        jsonbody2.put("area", area);
                        jsonbody2.put("city", city);
                        jsonbody2.put("pin_code", pin_code);
                        jsonbody2.put("state", state);
                        jsonbody.put("address",jsonbody2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonbody,

                            new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        String s = response.getString("answer");
                                        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                                        if(s.equals("1")) {
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString("first_name", firstname);
                                            editor.putString("last_name", lastname);
                                            editor.putString("middle_name", middlename);
                                            editor.putString("birth_date", birthdate);
                                            editor.putString("email", email);
                                            editor.putString("cast", cast);
                                            editor.putString("contact_no", contact_no);
                                            editor.putString("house_no", house_no);
                                            editor.putString("street_name", street_name);
                                            editor.putString("landmark", landmark);
                                            editor.putString("area", area);
                                            editor.putString("city", city);
                                            editor.putString("pin_code", pin_code);
                                            editor.putString("state", state);
                                            editor.putString("data1", "1");
                                            progress.setVisibility(View.GONE);

                                            editor.commit();
                                        } else {
                                            Toast.makeText(getContext(), s, Toast.LENGTH_LONG ).show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
                                }
                            });
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(jsonObjectRequest);
                }
                submit.setBackgroundResource(R.drawable.button_design1);
                submit.setText("SUBMIT");
            }
        });
    }
}