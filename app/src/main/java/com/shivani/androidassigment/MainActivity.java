package com.shivani.androidassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_KEY  = "MESSAGE_KEY";

    private EditText mMessageEt;
    private Button mSubmitBtn;

    private EditText mUrlEt;
    private Button mUrlSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEt = findViewById(R.id.message_et);
        mSubmitBtn = findViewById(R.id.submit_btn);
        mUrlEt = findViewById(R.id.url_et);
        mUrlSubmitBtn = findViewById(R.id.url_submit_btn);


        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mMessageEt.getText())){
                    Toast.makeText(MainActivity.this, "Field should not be empty.", Toast.LENGTH_SHORT).show();
                }else {
                    openDetailActivity(mMessageEt.getText().toString());
                }
            }
        });

        mUrlSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mUrlEt.getText())){
                    Toast.makeText(MainActivity.this, "Url should not be empty.", Toast.LENGTH_SHORT).show();
                }else {
                    openBrowser(mUrlEt.getText().toString());
                }
            }
        });
    }

    private void openDetailActivity(String  message){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(MESSAGE_KEY, message);
        startActivity(intent);
    }

    private void openBrowser(String  url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
