package com.android.handbookforthemushroompicker;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.mushrooms_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.mushrooms);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.id_mushrooms)
        {
            toolbar.setTitle(R.string.mushrooms);

            array = getResources().getStringArray(R.array.mushrooms_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();

            Toast.makeText(this, "button_pressed", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.id_edible_mushrooms) {

            toolbar.setTitle(R.string.edible_mushrooms);

            array = getResources().getStringArray(R.array.edible_mushrooms_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();

        } else if (id == R.id.id_poisonous_mushrooms) {

            toolbar.setTitle(R.string.poisonous_mushrooms);

            array = getResources().getStringArray(R.array.poisonous_mushrooms_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();

        } else if (id == R.id.id_mushrooms_are_edible) {

            toolbar.setTitle(R.string.mushrooms_are_edible);

            array = getResources().getStringArray(R.array.mushrooms_are_edible_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();

        } else if (id == R.id.id_mushroom_stories) {

            toolbar.setTitle(R.string.mushroom_stories);

            array = getResources().getStringArray(R.array.mushroom_stories_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();

        } else if (id == R.id.id_video) {

            toolbar.setTitle(R.string.video);

            array = getResources().getStringArray(R.array.video_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();

        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}