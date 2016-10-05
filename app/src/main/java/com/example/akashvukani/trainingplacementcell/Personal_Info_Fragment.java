package com.example.akashvukani.trainingplacementcell;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.os.AsyncTaskCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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

    private Button submit;
    final String url="http://10.10.10.109:8000/test";


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

        FirstName=(EditText)getActivity().findViewById(R.id.data_entry_first_name);
        LastName=(EditText)getActivity().findViewById(R.id.data_entry_last_name);
        MiddleName=(EditText)getActivity().findViewById(R.id.data_entry_middle_name);
        BirthDate=(EditText)getActivity().findViewById(R.id.data_entry_birth_date);

        submit=(Button)getActivity().findViewById(R.id.submmit1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstname = FirstName.getText().toString();
                final String lastname = LastName.getText().toString();
                final String middlename = MiddleName.getText().toString();
                final String birthdate = BirthDate.getText().toString();

                JSONObject jsonbody=new JSONObject();
                try {
                    jsonbody.put("firstname",firstname);
                    jsonbody.put("lastname",lastname);
                    jsonbody.put("middlename",middlename);
                    jsonbody.put("birthdate",birthdate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,jsonbody,

                        new Response.Listener<JSONObject>(){

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String s=response.getString("answer");
                                    Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show();
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
                RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
                requestQueue.add(jsonObjectRequest);
            }
        });
    }


}