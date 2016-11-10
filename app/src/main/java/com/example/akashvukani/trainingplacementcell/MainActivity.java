package com.example.akashvukani.trainingplacementcell;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView nameHeader;
    public TextView emailHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SharedPreferences sharedPreferences=getSharedPreferences("forLogin",MODE_PRIVATE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_account) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment,new BlankFragment()).commit();

        } else if (id == R.id.notice_board) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment,new BlankFragment()).commit();
        } else if (id == R.id.data_entry) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment,new DataEntryfragment()).commit();
        } else if (id == R.id.discussion_center) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment,new BlankFragment()).commit();
        } else if (id == R.id.help) {
            getSupportFragmentManager().beginTransaction().replace(R.id.navigation_fragment,new BlankFragment()).commit();
        } else if (id == R.id.logout) {

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Do you really want to LOG OUT ?").setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            final SharedPreferences sharedPreferences=getSharedPreferences("forLogin",MODE_PRIVATE);
                            sharedPreferences.edit().remove("enrollShared").commit();
                            sharedPreferences.edit().remove("first_name").commit();
                            sharedPreferences.edit().remove("last_name").commit();
                            sharedPreferences.edit().remove("middle_name").commit();
                            sharedPreferences.edit().remove("birth_date").commit();
                            sharedPreferences.edit().remove("email").commit();
                            sharedPreferences.edit().remove("cast").commit();
                            sharedPreferences.edit().remove("contact_no").commit();
                            sharedPreferences.edit().remove("house_no").commit();
                            sharedPreferences.edit().remove("street_name").commit();
                            sharedPreferences.edit().remove("landmark").commit();
                            sharedPreferences.edit().remove("area").commit();
                            sharedPreferences.edit().remove("city").commit();
                            sharedPreferences.edit().remove("pin_code").commit();
                            sharedPreferences.edit().remove("state").commit();
                            sharedPreferences.edit().remove("data1").commit();

                            sharedPreferences.edit().remove("10_marks").commit();
                            sharedPreferences.edit().remove("10_year").commit();
                            sharedPreferences.edit().remove("12_marks").commit();
                            sharedPreferences.edit().remove("12_year").commit();
                            sharedPreferences.edit().remove("data2").commit();
                            sharedPreferences.edit().remove("d2d_sem1").commit();
                            sharedPreferences.edit().remove("d2d_sem2").commit();
                            sharedPreferences.edit().remove("d2d_sem3").commit();
                            sharedPreferences.edit().remove("d2d_sem4").commit();
                            sharedPreferences.edit().remove("d2d_sem5").commit();
                            sharedPreferences.edit().remove("d2d_sem6").commit();

                            sharedPreferences.edit().remove("data3").commit();
                            sharedPreferences.edit().remove("degree_sem1").commit();
                            sharedPreferences.edit().remove("degree_sem2").commit();
                            sharedPreferences.edit().remove("degree_sem3").commit();
                            sharedPreferences.edit().remove("degree_sem4").commit();
                            sharedPreferences.edit().remove("degree_sem5").commit();
                            sharedPreferences.edit().remove("degree_sem6").commit();
                            sharedPreferences.edit().remove("degree_sem7").commit();
                            sharedPreferences.edit().remove("degree_sem8").commit();

                            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            builder.show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
