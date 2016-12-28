package com.vipul.bit_hotels.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vipul.bit_hotels.fragment.GalleryImageFragment;

import java.util.ArrayList;
import java.util.List;

public class GalleryPagerAdapter extends FragmentStatePagerAdapter {

    public GalleryPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                return GalleryImageFragment.newInstance(position);
        }
    }
}