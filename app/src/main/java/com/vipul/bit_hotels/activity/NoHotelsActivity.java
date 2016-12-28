package com.vipul.bit_hotels.activity;

import android.annotation.TargetApi;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.transition.TransitionManager;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vipul.bit_hotels.R;

public class NoHotelsActivity extends BaseActivity {
    private ImageView ivHeroImage;
    private TextView tvLocation;
    private int imageResource;
    private String title;
    private RelativeLayout progressLayout;
    private LinearLayout noHotelsFoundLayout, noTripRootlayout;
    private TextView tvButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_hotels);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupEnterAnimation();
        }

        tvButton = (TextView) findViewById(R.id.tv_no_trip);
        progressLayout = (RelativeLayout) findViewById(R.id.progress_layout);
        noHotelsFoundLayout = (LinearLayout) findViewById(R.id.no_hotels_found_layout);
        noTripRootlayout = (LinearLayout) findViewById(R.id.no_trip_root_layout);
        noHotelsFoundLayout.setVisibility(View.GONE);
        tvButton.setVisibility(View.GONE);

        ivHeroImage = (ImageView) findViewById(R.id.iv_hero_image);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        imageResource = getIntent().getIntExtra("image", R.drawable.img_city_1);
        title = getIntent().getStringExtra("title");

        ivHeroImage.setImageResource(imageResource);
        tvLocation.setText(title);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initUi();
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(noTripRootlayout);
                progressLayout.setVisibility(View.GONE);
                noHotelsFoundLayout.setVisibility(View.VISIBLE);
                tvButton.setVisibility(View.VISIBLE);
            }
        }, 2000);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupEnterAnimation() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.change_bounds_with_arc);
        transition.setDuration(300);
        getWindow().setSharedElementEnterTransition(transition);
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }


    @TargetApi(Build.VERSION_CODES.M)
    private void initUi() {
        initializeToolbar();

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
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("");
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
