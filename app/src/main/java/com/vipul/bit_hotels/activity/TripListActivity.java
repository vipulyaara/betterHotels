package com.vipul.bit_hotels.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vipul.bit_hotels.R;

public class TripListActivity extends BaseActivity {
    ImageView ivNoTrip;
    TextView tvButton;
    ViewGroup trip1Layout;
    ImageView ivHero1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_list);
        initializeToolbar();

        ivHero1 = (ImageView) findViewById(R.id.iv_hero_1);
        trip1Layout = (ViewGroup) findViewById(R.id.trip_1_layout);
        trip1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair<View, String> p1 = Pair.create((View) ivHero1, ivHero1.getTransitionName());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((TripListActivity.this), p1);
                Bundle bundle = options.toBundle();
                Intent i = new Intent(TripListActivity.this, TripDetailActivity.class);
                startActivity(i, bundle);
            }
        });
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
