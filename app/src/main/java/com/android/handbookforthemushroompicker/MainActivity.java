package com.android.handbookforthemushroompicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.android.handbookforthemushroompicker.settings.SettingActivity;
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
    private int category_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.mushrooms_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, TextContentActivity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        toolbar.setTitle(R.string.mushrooms);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.id_mushrooms)
        {
            fillArray(R.string.mushrooms, R.array.mushrooms_array, 0);

        } else if (id == R.id.id_edible_mushrooms) {

            fillArray(R.string.edible_mushrooms, R.array.edible_mushrooms_array, 1);

        } else if (id == R.id.id_poisonous_mushrooms) {

            fillArray(R.string.poisonous_mushrooms, R.array.poisonous_mushrooms_array, 2);

        } else if (id == R.id.id_mushrooms_are_edible) {

            fillArray(R.string.mushrooms_are_edible, R.array.mushrooms_are_edible_array, 3);

        } else if (id == R.id.id_mushroom_stories) {

            fillArray(R.string.mushroom_stories, R.array.mushroom_stories_array, 4);

        } else if (id == R.id.id_video) {

            fillArray(R.string.video, R.array.video_array, 5);

        }

        drawer.closeDrawer(GravityCompat.START);
        return false;

    }

    private void fillArray(int title, int arrayList, int index) {
        toolbar.setTitle(title);
        array = getResources().getStringArray(arrayList);
        adapter.clear();
        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        category_index = index;
    }
}