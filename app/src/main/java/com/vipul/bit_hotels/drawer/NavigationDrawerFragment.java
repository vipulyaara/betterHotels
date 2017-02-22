package com.vipul.bit_hotels.drawer;

/**
 * Copyright (c) 2015. Catch It Private Limited, India
 * Created by Vipul Kumar on 4/15/2015.
 */

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.activity.BlogActivity;
import com.vipul.bit_hotels.activity.BlurredLayoutActivity;
import com.vipul.bit_hotels.activity.HotelVocabActivity;
import com.vipul.bit_hotels.activity.NoTripActivity;
import com.vipul.bit_hotels.activity.ProfileActivity;
import com.vipul.bit_hotels.activity.PublicationActivity;
import com.vipul.bit_hotels.activity.PublicationActivityOld;
import com.vipul.bit_hotels.activity.SearchActivity;
import com.vipul.bit_hotels.activity.TripsListActivity;
import com.vipul.bit_hotels.utils.Utils;

public class NavigationDrawerFragment extends BaseNavigationDrawerFragment {

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        navigationDrawerLayout = (RelativeLayout) inflater.inflate(R.layout.drawer_layout,
                container, false);

        final TextView tripsLayout = (TextView) navigationDrawerLayout.findViewById(R.id.trips_layout);
        tripsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.startActivityWithClipReveal(getActivity(), TripsListActivity.class, tripsLayout);
            }
        });

        final TextView blogsLayout = (TextView) navigationDrawerLayout.findViewById(R.id.blog_layout);
        blogsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.startActivityWithClipReveal(getActivity(), BlogActivity.class, blogsLayout);
            }
        });

        final TextView albumLayout = (TextView) navigationDrawerLayout.findViewById(R.id.tv_album);
        albumLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.startActivityWithClipReveal(getActivity(), NoTripActivity.class, blogsLayout);
            }
        });

        final TextView feedback = (TextView) navigationDrawerLayout.findViewById(R.id.btn_help_feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.startActivityWithClipReveal(getActivity(), HotelVocabActivity.class, blogsLayout);
            }
        });

        final RelativeLayout profileLayout = (RelativeLayout) navigationDrawerLayout.findViewById(R.id.profile_layout);
        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.startActivityWithClipReveal(getActivity(), ProfileActivity.class, profileLayout);
            }
        });

        final LinearLayout searchLayout = (LinearLayout) navigationDrawerLayout.findViewById(R.id.search_layout);
        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.startActivityWithClipReveal(getActivity(), SearchActivity.class, searchLayout);
            }
        });

        final TextView rateLayout = (TextView) navigationDrawerLayout.findViewById(R.id.btn_help_rate_app);
        rateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.startActivityWithClipReveal(getActivity(), PublicationActivityOld.class, rateLayout);
            }
        });
        return navigationDrawerLayout;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), /* host Activity */
                mDrawerLayout, /* DrawerLayout object */
                R.string.navigation_drawer_open, R.string.navigation_drawer_open) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }
                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }
                if (!mUserLearnedDrawer) {
                    // The user manually opened the com.readies.readies.drawer; store this flag to
                    // prevent auto-showing
                    // the navigation com.readies.readies.drawer automatically in the future.
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true)
                            .apply();
                }
                getActivity().supportInvalidateOptionsMenu();
            }
        };
        // If the user hasn't 'learned' about the com.readies.readies.drawer, open it to introduce
        // them to the com.readies.readies.drawer,
        // per the navigation com.readies.readies.drawer design guidelines.
        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }
        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
}