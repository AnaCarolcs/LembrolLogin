package com.lembrol.ana.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.lembrol.ana.R;

public class ReminderActivity extends AppCompatActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Lembrol");
        setSupportActionBar(toolbar);
    }
}
