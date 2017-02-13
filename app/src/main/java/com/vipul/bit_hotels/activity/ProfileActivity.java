package com.vipul.bit_hotels.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.vipul.bit_hotels.R;

public class ProfileActivity extends BaseActivity {
    ImageView ivWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_follow);

        initializeToolbar();

//        ivWifi = (ImageView) findViewById(R.id.iv_wifi);
//        Utils.loadGifImageWithIon(ivWifi, "wifi");
    }

    private void initializeToolbar() {

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
