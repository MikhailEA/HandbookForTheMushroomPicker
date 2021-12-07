package com.android.handbookforthemushroompicker;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private TextView text_content;
    private Typeface face1;
    private ImageView iContent;
    private int category = 0;
    private int position = 0;
    private int [] mushrooms_array ={R.string.mushrooms1, R.string.mushrooms2,
            R.string.mushrooms3, R.string.mushrooms4, R.string.mushrooms5,
            R.string.mushrooms6, R.string.mushrooms7, R.string.mushrooms8,
            R.string.mushrooms9, R.string.mushrooms10, R.string.mushrooms11};
    private int [] edible_mushrooms_array ={R.string.edible_mushrooms1, R.string.edible_mushrooms2,
            R.string.edible_mushrooms3, R.string.edible_mushrooms4, R.string.edible_mushrooms5,
            R.string.edible_mushrooms, R.string.edible_mushrooms7, R.string.edible_mushrooms8,};
    private int [] image_mushrooms_array ={R.drawable.white_mushroom, R.drawable.boletus, R.drawable.lump, R.drawable.boletus};
    private String [] title_mushrooms_array ={"Белый гриб","Подосиновик","Лисичка","Подберезовик","Опенок","Масленок","Зонтик",};

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        reciveIntent();
    }

    private void init() {
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);
        face1 = Typeface.createFromAsset(this.getAssets(), "fonts/JosefinSans-Medium.ttf");
        text_content.setTypeface(face1);
        actionBar = getSupportActionBar();
    }


    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null) {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (category) {
            case 0:
                iContent.setImageResource(image_mushrooms_array[position]);
                text_content.setText(mushrooms_array[position]);
                break;
            case 1:
                text_content.setText(edible_mushrooms_array[position]);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

        }
    }
}
