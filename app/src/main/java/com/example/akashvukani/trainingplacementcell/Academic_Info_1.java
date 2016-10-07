package com.example.akashvukani.trainingplacementcell;

import android.content.Context;
import android.net.Uri;
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
        submit= (Button)getActivity().findViewById(R.id.submit_academic_info_1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
