package com.vipul.bit_hotels.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.utils.Utils;
import com.vipul.bit_hotels.adapter.FeaturedEventsAdapter;
import com.vipul.bit_hotels.model.LocationItem;

import java.util.LinkedList;

import uk.co.ribot.easyadapter.EasyRecyclerAdapter;

public class HotelSrpActivity extends BaseActivity {
    private ImageView ivHeroImage;
    private TextView tvLocation;
    private int imageResource;
    private String title;
    private LinkedList<LocationItem> locationsList;
    private EasyRecyclerAdapter<LocationItem> locationsAdapter;
    private RelativeLayout filtersLayout, headerLayout;
    private FloatingActionButton fabFilters;
    private boolean hidden = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_srp);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupEnterAnimation();
        }

        fabFilters = (FloatingActionButton) findViewById(R.id.fab_filters);
        filtersLayout = (RelativeLayout) findViewById(R.id.filters_layout);
        headerLayout = (RelativeLayout) findViewById(R.id.header_layout);
        ivHeroImage = (ImageView) findViewById(R.id.iv_hero_image);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        imageResource = getIntent().getIntExtra("image", R.drawable.img_city_1);
        title = getIntent().getStringExtra("title");

//        Picasso.with(this)
//                .load(imageResource)
//                .into(ivHeroImage);
        ivHeroImage.setImageResource(imageResource);
        tvLocation.setText(title);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initUi();
            }
        }, 500);
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

    private void initUi() {
        initializeToolbar();

        RecyclerView recyclerViewLocations = (RecyclerView) findViewById(R.id.recycler_view_locations);
        recyclerViewLocations.setHasFixedSize(true);
        recyclerViewLocations.setNestedScrollingEnabled(false);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(
                this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewLocations.setLayoutManager(mLayoutManager);

        locationsList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            LocationItem locationItem = new LocationItem();
            locationsList.add(locationItem);
        }

        locationsAdapter = new EasyRecyclerAdapter<>(this, FeaturedEventsAdapter.class, locationsList);
        recyclerViewLocations.setAdapter(locationsAdapter);

        final ImageView ivImage3 = (ImageView) findViewById(R.id.iv_image_3);
        ivImage3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Bundle bundle = null;

                Pair<View, String> p1 = Pair.create((View) ivImage3, ivImage3.getTransitionName());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(HotelSrpActivity.this, p1);
                bundle = options.toBundle();
                Intent i = new Intent(HotelSrpActivity.this, GalleryActivity.class);
                i.putExtra("image", R.drawable.img_city_10);
                startActivity(i, bundle);
            }
        });

        fabFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabRevealAnimation();
            }
        });

        headerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotelSrpActivity.this, HotelDetailActivity.class));
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

    @Override
    public void onBackPressed() {
        if (hidden) {
            super.onBackPressed();
        } else {
            fabRevealAnimation();
        }
    }

    private void fabRevealAnimation() {
        int cx = fabFilters.getLeft() + 84;
        int cy = fabFilters.getBottom() - 84;
        int radius = Math.max(filtersLayout.getWidth(), filtersLayout.getHeight());
        if (hidden) {
            Animator anim = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                anim = android.view.ViewAnimationUtils.createCircularReveal(filtersLayout, cx, cy, 0, radius);
            }
            Utils.animationOut(fabFilters, R.anim.scale_down, 0, true, HotelSrpActivity.this);
            filtersLayout.setVisibility(View.VISIBLE);
            anim.start();
            hidden = false;
        } else {
            Animator anim = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                anim = android.view.ViewAnimationUtils.createCircularReveal(filtersLayout, cx, cy, radius, 0);
            }
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    Utils.animationIn(fabFilters, R.anim.scale_up, 0, HotelSrpActivity.this);
                    filtersLayout.setVisibility(View.INVISIBLE);
                    hidden = true;
                }
            });
            anim.start();
        }
    }
}
