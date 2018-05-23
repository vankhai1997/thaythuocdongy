package com.example.administrator.thaythuoc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.administrator.thaythuoc.R;
public class MainActivity  extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initsView();
    }

    private void initsView() {
       findViewById(R.id.btn_chat_bot).setOnClickListener(this);
        findViewById(R.id.btn_dong_y).setOnClickListener(this);
        findViewById(R.id.btn_che_do_an).setOnClickListener(this);
        findViewById(R.id.btn_bmi).setOnClickListener(this);
        findViewById(R.id.btn_hoi_chung_benh).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_dong_y:
                Intent iDongY= new Intent(MainActivity.this,DongyActivity.class);
                startActivity(iDongY);
        }

    }
}
