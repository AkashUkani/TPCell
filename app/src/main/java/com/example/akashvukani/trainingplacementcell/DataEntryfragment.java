package com.example.akashvukani.trainingplacementcell;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DataEntryfragment extends Fragment {

    private ViewPager data_entry_viewpager;
    private TabLayout data_entry_tablayout;
    private String[] tabs={"Personal Info","Academic Info 1","Academic Info 2 "};

    public DataEntryfragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_entry, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        data_entry_viewpager=(ViewPager)getActivity().findViewById(R.id.data_entry_view_pager);
        data_entry_viewpager.setAdapter(new PagerAdapter(getChildFragmentManager(),tabs));

        data_entry_tablayout=(TabLayout)getActivity().findViewById(R.id.data_entry_tablayout);
        data_entry_tablayout.setupWithViewPager(data_entry_viewpager);
    }

    class PagerAdapter extends FragmentPagerAdapter{

        public final String[] tabs;
        public PagerAdapter(FragmentManager fm,String[] tabs) {
            super(fm);
            this.tabs=tabs;
        }

        @Override
        public Fragment getItem(int position) {
            if(tabs[position].equalsIgnoreCase("Personal Info")){
                return new Personal_Info_Fragment();
            }else if(tabs[position].equalsIgnoreCase("Academic Info 1")){
                return new Academic_Info_1();
            }else
                return new Academic_Info_2();
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}