package com.saigopal.organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Button addNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager_subscription);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        addNew = findViewById(R.id.addNewSubscription);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add new subscription", Toast.LENGTH_SHORT).show();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout.setupWithViewPager(viewPager);

        Far_manage_existing manage_existing = new Far_manage_existing();
        Far_pending_requests pending_requests = new Far_pending_requests();



        SubcriptionViewPager viewPagerAdapter = new SubcriptionViewPager(getSupportFragmentManager(),0);

        viewPagerAdapter.addfragement(pending_requests,"Pending Requests");
        viewPagerAdapter.addfragement(manage_existing,"Manage Existing");


        viewPager.setAdapter(viewPagerAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mn = getMenuInflater();
        mn.inflate(R.menu.main_menu,menu);
        return (true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.location:
                Toast.makeText(this, "Location Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.notification:
                Toast.makeText(this, "Notification Clicked", Toast.LENGTH_SHORT).show();
                return  (true);
        }
        return (true);
    }

}
