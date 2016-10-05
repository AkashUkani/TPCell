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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Personal_Info_Fragment extends Fragment {


    private EditText enroll;
    private EditText name;
    private Button submit;
    final String url="http://10.10.10.111:8000/test";


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

        enroll=(EditText)getActivity().findViewById(R.id.data_entry_enroll);
        name=(EditText)getActivity().findViewById(R.id.data_entry_name);

        submit=(Button)getActivity().findViewById(R.id.submmit1);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enroll_st,name_st;
                enroll_st=enroll.getText().toString();
                name_st=name.getText().toString();


            }
        });
    }


}