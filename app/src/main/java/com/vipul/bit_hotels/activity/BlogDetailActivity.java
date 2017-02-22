package com.vipul.bit_hotels.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vipul.bit_hotels.R;

public class BlogDetailActivity extends BaseActivity {
    private ImageView ivHeroImage;
    private TextView tvLocation;
    private int imageResource;
    private String title = "";
    private View viewBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupEnterAnimation();
        }

        viewBg = findViewById(R.id.view_bg);
        viewBg.setVisibility(View.GONE);
        ivHeroImage = (ImageView) findViewById(R.id.iv_image);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        imageResource = getIntent().getIntExtra("image", 0);
        if (getIntent().getStringExtra("text") != null) {
            title = getIntent().getStringExtra("text");
        }
        title = title.equalsIgnoreCase("") ? "Play a fest of colors with Holi" : title;
        tvLocation.setText(title);

        if (imageResource != 0) {
            Picasso.with(BlogDetailActivity.this)
                    .load(imageResource)
                    .into(ivHeroImage);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initUi();
            }
        }, 500);

        runTitleAnimation();

    }

    private void runTitleAnimation() {
        tvLocation.setVisibility(View.INVISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewBg.setVisibility(View.VISIBLE);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(220);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation2.setDuration(220);
                scaleAnimation2.setStartOffset(220);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(scaleAnimation2);
                animationSet.setFillAfter(true);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        tvLocation.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                viewBg.startAnimation(animationSet);
            }
        }, 300);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blog_detail, menu);
        return true;
    }

    private void initUi() {
        initializeToolbar();
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
