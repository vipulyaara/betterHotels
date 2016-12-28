package com.vipul.bit_hotels.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.adapter.GalleryPagerAdapter;

/**
 * Created by vipulkumar on 17/10/16.
 */

public class GalleryFragment extends Fragment {
    private View rootView;
    private ViewPager viewPagerGallery;
    private TextView tvPosition;

    public static GalleryFragment newInstance() {
        Bundle args = new Bundle();
        GalleryFragment fragment = new GalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        viewPagerGallery = (ViewPager) rootView.findViewById(R.id.view_pager_gallery);
        tvPosition = (TextView) rootView.findViewById(R.id.tv_position);
        GalleryPagerAdapter galleryPagerAdapter = new GalleryPagerAdapter(getChildFragmentManager());
        viewPagerGallery.setAdapter(galleryPagerAdapter);
        viewPagerGallery.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int finalPosition = position + 1;
                tvPosition.setText("" + finalPosition + "/10");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return rootView;
    }
}
