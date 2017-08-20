package com.example.ashutoshpc.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
SeekBar seekBar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        seekBar= (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(500);
        seekBar.setOnSeekBarChangeListener(n
    }
}
