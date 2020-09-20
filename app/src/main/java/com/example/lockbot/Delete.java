package com.example.lockbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.CheckBox;

public class Delete extends AppCompatActivity {
    private Button moveRecycle;
    private Button restoreRecycle;
    private Button removeFromRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        moveRecycle = (Button) findViewById(R.id.button8);
        restoreRecycle = (Button)findViewById(R.id.button7);
        removeFromRecycle = (Button)findViewById(R.id.button6);

        moveRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        restoreRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        removeFromRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }
}