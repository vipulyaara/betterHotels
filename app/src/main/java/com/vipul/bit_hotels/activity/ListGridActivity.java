package com.vipul.bit_hotels.activity;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vipul.bit_hotels.R;

public class ListGridActivity extends BaseActivity {
    ImageView ivNoTrip;
    TextView tvButton;
    boolean isGridToList;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initializeToolbar();

        ivNoTrip = (ImageView) findViewById(R.id.iv_no_trip);


        final AnimatedVectorDrawableCompat avdListToGrid = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_list_grid);
        final AnimatedVectorDrawableCompat avdGridToList = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_grid_list);


        ivNoTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isGridToList) {
                    ivNoTrip.setImageDrawable(avdListToGrid);
                    avdListToGrid.start();
                    isGridToList = true;
                } else {
                    ivNoTrip.setImageDrawable(avdGridToList);
                    avdGridToList.start();
                    isGridToList = false;
                }
            }
        });

        tvButton = (TextView) findViewById(R.id.tv_no_trip);
        final AnimatedVectorDrawable avd2 = (AnimatedVectorDrawable) tvButton.getBackground();

        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvButton.setText("Loading...");
                avd2.start();
            }
        });

        avd2.registerAnimationCallback(new Animatable2.AnimationCallback() {
            @Override
            public void onAnimationEnd(Drawable drawable) {
                tvButton.setText("Try Again");
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
