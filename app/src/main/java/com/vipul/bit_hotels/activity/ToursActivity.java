package com.vipul.bit_hotels.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vipul.bit_hotels.R;

public class ToursActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);

        initializeToolbar();
    }

    private void initializeToolbar() {
    }
}
