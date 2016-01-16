package com.safeeducation.safeeducation;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CrimeStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_stats);
        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView dataCity =(TextView)findViewById(R.id.data1);

        String Full;
        String CityCrime[]= new String[585];
        String City[] = new String[292];
        String Crime[] = new String[292];



        AssetManager am = this.getResources().getAssets();
        try {
            InputStream is = null;
            try {
                is = am.open("data.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader r = new BufferedReader(new InputStreamReader(is));

            for(int i=0;i<292;i++)
            {
                Full = r.readLine();
                CityCrime = (Full.split(","));
                City[i] = CityCrime[0];
                Crime[i] = CityCrime[1];

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<Crime.length;i++)
        {
            if (message.toLowerCase().equals(City[i].toLowerCase()))
            {
                dataCity.setTextSize(40);
                dataCity.setText(Crime[i]);
                break;
            }

        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

    }
