package com.vipul.bit_hotels.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vipul.bit_hotels.R;

/**
 * Created by vipulkumar on 17/10/16.
 */

public class GalleryImageFragment extends Fragment {
    private View rootView;
    private int position;
    private ImageView ivImage;
    private int[] drawables = {R.drawable.img_city_34, R.drawable.img_building_1, R.drawable.img_city_9,
            R.drawable.img_city_10, R.drawable.img_city_8, R.drawable.img_city_11, R.drawable.img_city_22,
            R.drawable.img_city_13, R.drawable.img_city_14, R.drawable.img_city_21};

    public static GalleryImageFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        GalleryImageFragment fragment = new GalleryImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.item_gallary, container, false);
        position = getArguments().getInt("position");
        ivImage = (ImageView) rootView.findViewById(R.id.iv_image);
        ivImage.setImageResource(drawables[position]);

        return rootView;
    }
}
