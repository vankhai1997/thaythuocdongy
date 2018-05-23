package com.example.administrator.thaythuoc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.administrator.thaythuoc.R;

public class ActivityStart extends AppCompatActivity {
    private ProgressBar pro;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        pro = findViewById(R.id.progess);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

                pro.setProgress((int) (l/1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ActivityStart.this, MainActivity.class);
                startActivity(intent);
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        return;
    }
}
