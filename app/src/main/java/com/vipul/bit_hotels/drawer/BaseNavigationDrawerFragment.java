package com.vipul.bit_hotels.drawer;

/**
 * Copyright (c) 2015. Catch It Private Limited, India
 * Created by Vipul Kumar on 4/15/2015.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

public abstract class BaseNavigationDrawerFragment extends Fragment {

    // Remember the position of the selected item.
    private final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    // Per the design guidelines, you should show the com.readies.readies.drawer on launch until the
    // user manually expands it. This shared preference tracks this.
    protected final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    // A pointer to the current callbacks instance (the Activity).
    private NavigationDrawerCallbacks mCallbacks;

    // Handler to wait for the com.readies.readies.drawer to close before new fragment is drawn
    private final Handler mDrawerHandler = new Handler();

    // Helper component that ties the action bar to the navigation com.readies.readies.drawer.
    public ActionBarDrawerToggle mDrawerToggle;

    public DrawerLayout mDrawerLayout;
    protected RelativeLayout navigationDrawerLayout;
    protected ListView mDrawerListView;
    public View mFragmentContainerView;

    public int mCurrentSelectedPosition = 1;
    protected boolean mFromSavedInstanceState;
    protected boolean mUserLearnedDrawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Read in the flag indicating whether or not the user has demonstrated
        // awareness of the com.readies.readies.drawer
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState
                    .getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        // Select either the default item (1) (com.readies.readies.drawer header is on position 0) or the last selected item.
        selectItem(mCurrentSelectedPosition, true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of
        // actions in the action bar.
        setHasOptionsMenu(true);
    }

    @SuppressLint("InflateParams")
    @Override
    public abstract View onCreateView(LayoutInflater inflater, ViewGroup container,
                                      Bundle savedInstanceState);

    public boolean isDrawerOpen() {
        return mDrawerLayout != null
                && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    public void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    public void openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    // public abstract void setUp(int fragmentId, DrawerLayout drawerLayout);

    public void selectItem(final int position, boolean isFromDrawer) {
        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked(position, true);
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            // If the method is called on com.readies.readies.drawer item click, wait until com.readies.readies.drawer is closed to call new fragment
            // This ensures that com.readies.readies.drawer is closed smoothly
            if (isFromDrawer) {
                mDrawerHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mCallbacks.onNavigationDrawerItemSelected(position);
                    }
                }, 300);
            } else
                mCallbacks.onNavigationDrawerItemSelected(position);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            // Log Fabric exception
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the com.readies.readies.drawer toggle component.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    // Callbacks interface that all activities using this fragment must implement
    public interface NavigationDrawerCallbacks {
        // Called when an item in the navigation com.readies.readies.drawer is selected.
        void onNavigationDrawerItemSelected(int position);
    }
}
