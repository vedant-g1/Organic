package com.saigopal.organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Report extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
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
                Intent intent = new Intent(Report.this,MainActivity.class);
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
