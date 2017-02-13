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

public class TripDetailActivity extends BaseActivity {
    private RelativeLayout galleryLayout;
    private LinkedList<LocationItem> locationsList;
    private EasyRecyclerAdapter<LocationItem> locationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

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
