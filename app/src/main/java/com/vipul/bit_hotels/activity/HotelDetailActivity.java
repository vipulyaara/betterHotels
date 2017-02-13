package com.vipul.bit_hotels.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.adapter.FeaturedEventsAdapter;
import com.vipul.bit_hotels.fragment.GalleryFragment;
import com.vipul.bit_hotels.model.LocationItem;

import java.util.LinkedList;

import uk.co.ribot.easyadapter.EasyRecyclerAdapter;

public class HotelDetailActivity extends BaseActivity {
    private RelativeLayout galleryLayout;
    private LinkedList<LocationItem> locationsList;
    private EasyRecyclerAdapter<LocationItem> locationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
        galleryLayout = (RelativeLayout) findViewById(R.id.gallery_layout);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.gallery_layout, GalleryFragment.newInstance())
                .commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initUi();
            }
        }, 500);
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
