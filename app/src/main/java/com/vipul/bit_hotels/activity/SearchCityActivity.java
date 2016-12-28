package com.vipul.bit_hotels.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.vipul.bit_hotels.R;

public class SearchCityActivity extends BaseActivity {
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);

        initializeToolbar();

        findViewById(R.id.bottm_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = ((ViewGroup)findViewById(android.R.id.content)).getChildAt(0);
                Snackbar.make(view, "Move up dude!", Snackbar.LENGTH_LONG).show();

//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        value = value + 100;
//                        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0,0, value);
//                        translateAnimation.setFillAfter(true);
//                        findViewById(R.id.linear_layout).startAnimation(translateAnimation);
//                    }
//                }, 000);
            }
        });
    }

    private void initializeToolbar() {
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
