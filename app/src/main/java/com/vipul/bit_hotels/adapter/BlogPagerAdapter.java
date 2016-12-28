package com.vipul.bit_hotels.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vipul.bit_hotels.fragment.BlogItemFragment;
import com.vipul.bit_hotels.fragment.GalleryImageFragment;

public class BlogPagerAdapter extends FragmentStatePagerAdapter {

    public BlogPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                return BlogItemFragment.newInstance(position);
        }
    }
}