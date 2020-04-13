package com.saigopal.organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button addNew;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager_subscription);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        addNew = findViewById(R.id.addNewSubscription);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Report.class);
                startActivity(intent);
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

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openDrawer,
                R.string.openDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mn = getMenuInflater();
        mn.inflate(R.menu.main_menu,menu);
        return (true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.location:
                Intent intent = new Intent(MainActivity.this,Report.class);
                startActivity(intent);
                Toast.makeText(this, "Location Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.notification:
                Toast.makeText(this, "Notification Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:

                return true;
        }
        return (true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.products:
                Toast.makeText(this, "Products Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.order:
                Toast.makeText(this, "Orders Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subscription:
                Toast.makeText(this, "Subscription Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.report:
                Intent intent = new Intent(MainActivity.this,Report.class);
                startActivity(intent);
                break;
            case R.id.profile:
                Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(this, "logout Clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture)
    {

    }
}
