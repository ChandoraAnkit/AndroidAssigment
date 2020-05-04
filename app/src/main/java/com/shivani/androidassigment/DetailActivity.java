package com.shivani.androidassigment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView mNameTv;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent().hasExtra(MainActivity.MESSAGE_KEY))
            name = getIntent().getStringExtra(MainActivity.MESSAGE_KEY);

        mNameTv = findViewById(R.id.name_tv);
        mNameTv.setText(name);
    }


}
