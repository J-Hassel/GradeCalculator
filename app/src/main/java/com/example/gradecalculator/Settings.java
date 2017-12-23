package com.example.gradecalculator;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by jon on 12/22/17.
 */

public class Settings extends AppCompatActivity
{
    FloatingActionButton redButton, yellowButton, greenButton, blueButton, orangeButton, pinkButton, purpleButton, indigoButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        setTitle("Colors");

        redButton = (FloatingActionButton) findViewById(R.id.button_red);
        yellowButton = (FloatingActionButton) findViewById(R.id.button_yellow);
        greenButton = (FloatingActionButton) findViewById(R.id.button_green);
        blueButton = (FloatingActionButton) findViewById(R.id.button_blue);
        orangeButton = (FloatingActionButton) findViewById(R.id.button_orange);
        pinkButton = (FloatingActionButton) findViewById(R.id.button_pink);
        purpleButton = (FloatingActionButton) findViewById(R.id.button_purple);
        indigoButton = (FloatingActionButton) findViewById(R.id.button_indigo);

        redButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

               // MainActivity.changeColor("Red");
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * .8), (int)(height * .3));
    }
}
