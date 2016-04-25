package com.talha.projects.bitmaptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar skRed;
     SeekBar skGreen;
    SeekBar skBlue;


    RgbView myView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skRed=(SeekBar) findViewById(R.id.redBar);
         skGreen=(SeekBar) findViewById(R.id.greenBar);
        skBlue=(SeekBar) findViewById(R.id.blueBar);
        myView = (RgbView) findViewById(R.id.customView);

        final RgbView myView = (RgbView) findViewById(R.id.customView);

        // This is sample color combination replace with your seekbar values

        Button colorChange=(Button) findViewById(R.id.button);

        colorChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                myView.setDrawingCacheEnabled(true);

                myView.buildDrawingCache();


                // bm is your required bitmap
                Bitmap bm = myView.getDrawingCache();

                Toast.makeText(MainActivity.this,"Bitmap Ready",Toast.LENGTH_LONG).show();

            }
        });


        skRed.setOnSeekBarChangeListener(changeListener);
        skGreen.setOnSeekBarChangeListener(changeListener);
        skBlue.setOnSeekBarChangeListener(changeListener);
    }

    SeekBar.OnSeekBarChangeListener changeListener=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            myView.setColor(skRed.getProgress(),skGreen.getProgress(),skBlue.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };


}
