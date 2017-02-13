package com.vipul.bit_hotels.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.utils.Utils;
import com.vipul.bit_hotels.activity.NoHotelsActivity;
import com.vipul.bit_hotels.activity.SearchCityActivity;
import com.vipul.bit_hotels.activity.HotelSrpActivity;
import com.vipul.bit_hotels.model.LocationItem;

import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

@LayoutId(R.layout.item_location)
public class LocationsAdapter extends ItemViewHolder<LocationItem> implements View.OnClickListener {
    @ViewId(R.id.tv_title)
    private TextView tvTitle;
    @ViewId(R.id.tv_subtitle)
    private TextView tvSubtitle;
    @ViewId(R.id.iv_location)
    private ImageView ivLocation;
    @ViewId(R.id.location_layout)
    private RelativeLayout locationLayout;
    @ViewId(R.id.search_layout)
    private RelativeLayout searchLayout;
    @ViewId(R.id.filters_layout)
    private LinearLayout filtersLayout;

    private String[] titlesArray = {"Search", "New Delhi", "Iceland", "New York", "Mumbai", "Venice",
            "Hong kong", "London"};
    private String[] subtitlesArray = {"Search from all cities", "Current city", "22 - 24 Sep • 2 adults",
            "22 - 24 Sep • 2 adults", "22 - 24 Sep • 2 adults", "Featured city", "Featured city", "Featured city"};
    private int[] drawables4 = {R.drawable.img_city_14, R.drawable.img_city_2, R.drawable.img_city_15,
            R.drawable.img_city_18, R.drawable.img_city_13, R.drawable.img_city_9,
            R.drawable.img_city_10, R.drawable.img_city_8};
    private int[] drawables2 = {R.drawable.img_city_37, R.drawable.img_city_27, R.drawable.img_city_33,
            R.drawable.img_city_26, R.drawable.img_city_31, R.drawable.img_city_28,
            R.drawable.img_city_25, R.drawable.img_city_30};
    private int[] drawables = {R.drawable.img_city_37, R.drawable.img_city_31, R.drawable.img_city_33,
            R.drawable.img_city_26, R.drawable.img_city_27, R.drawable.img_city_34,
            R.drawable.img_city_25, R.drawable.img_city_38};
    private int[] drawables3 = {R.drawable.img_wall_1, R.drawable.img_wall_4, R.drawable.img_wall_14,
            R.drawable.img_wall_15, R.drawable.img_wall_12, R.drawable.img_wall_13,
            R.drawable.img_wall_6, R.drawable.img_wall_10};

    private LocationItem locationItem;

    public LocationsAdapter(View view) {
        super(view);
    }

    @Override
    public void onSetValues(LocationItem locationItem, final PositionInfo positionInfo) {
        this.locationItem = locationItem;
        tvTitle.setText(titlesArray[positionInfo.getPosition()]);
        tvSubtitle.setText(subtitlesArray[positionInfo.getPosition()]);

//        Picasso.with(getContext())
//                .load(drawables3[positionInfo.getPosition()])
//                .placeholder(R.drawable.ic_pl)
//                .into(ivLocation);

        ivLocation.setImageResource(drawables4[positionInfo.getPosition()]);

        if (positionInfo.getPosition() == 20) {
            searchLayout.setVisibility(View.VISIBLE);
        } else {
            searchLayout.setVisibility(View.GONE);
        }

//        if (positionInfo.getPosition() % 2 != 0) {
//            filtersLayout.setVisibility(View.VISIBLE);
//        } else {
//            filtersLayout.setVisibility(View.GONE);
//        }

        locationLayout.setOnClickListener
                (new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = null;

                        if (positionInfo.getPosition() == 5) {
                            Pair<View, String> p1 = Pair.create((View) ivLocation, ivLocation.getTransitionName());
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(((Activity) getContext()), p1);
                            bundle = options.toBundle();
                            Intent i = new Intent(getContext(), NoHotelsActivity.class);
                            i.putExtra("image", drawables4[positionInfo.getPosition()]);
                            i.putExtra("title", titlesArray[positionInfo.getPosition()]);
                            getContext().startActivity(i, bundle);
                        } else if (positionInfo.getPosition() == 0) {
                            Utils.startActivityWithClipReveal(getContext(), SearchCityActivity.class, ivLocation);
                        } else {
                            Pair<View, String> p1 = Pair.create((View) ivLocation, ivLocation.getTransitionName());
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(((Activity) getContext()), p1);
                            bundle = options.toBundle();
                            Intent i = new Intent(getContext(), HotelSrpActivity.class);
                            i.putExtra("image", drawables4[positionInfo.getPosition()]);
                            i.putExtra("title", titlesArray[positionInfo.getPosition()]);
                            getContext().startActivity(i, bundle);
                        }
                    }
    }

    );
}

    @Override
    public void onClick(View clickedView) {
        switch (clickedView.getId()) {
        }
    }

}