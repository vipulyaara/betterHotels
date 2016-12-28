package com.vipul.bit_hotels.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vipul.bit_hotels.model.LocationItem;
import com.vipul.bit_hotels.R;

import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

@LayoutId(R.layout.item_featured_event)
public class FeaturedEventsAdapter extends ItemViewHolder<LocationItem> implements View.OnClickListener {
    @ViewId(R.id.tv_title)
    private TextView tvTitle;
    @ViewId(R.id.tv_subtitle)
    private TextView tvSubtitle;
    @ViewId(R.id.iv_location)
    private ImageView ivLocation;
    @ViewId(R.id.location_layout)
    private RelativeLayout locationLayout;

    private String[] titlesArray = {"Hungarian Museum", "National Library", "San Fransisco", "New Delhi", "Paris"};
    private String[] subtitlesArray = {"Heart of England Tourism", "The City Of Dreams", "Heart of The Bay", "Heart of England Tourism", "Heart of England Tourism"};
    private int[] drawables = {R.drawable.img_building_1,
            R.drawable.img_building_2, R.drawable.img_city_8, R.drawable.img_city_6, R.drawable.img_city_7};

    private LocationItem locationItem;

    public FeaturedEventsAdapter(View view) {
        super(view);
    }

    @Override
    public void onSetValues(LocationItem locationItem, final PositionInfo positionInfo) {
        this.locationItem = locationItem;
        tvTitle.setText(titlesArray[positionInfo.getPosition()]);
        tvSubtitle.setText(subtitlesArray[positionInfo.getPosition()]);
        ivLocation.setImageResource(drawables[positionInfo.getPosition()]);

//        if (positionInfo.getPosition() == 0) {
//            Utils.loadGifImageWithIon(ivLocation, "sky");
//        }

//        locationLayout.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onClick(View view) {
//                Bundle bundle = null;
//
//                Pair<View, String> p1 = Pair.create((View) ivLocation, ivLocation.getTransitionName());
////                Pair<View, String> p2 = Pair.create((View) tvTitle, tvTitle.getTransitionName());
//                ActivityOptionsCompat options = ActivityOptionsCompat.
//                        makeSceneTransitionAnimation(((Activity) getContext()), p1);
//                bundle = options.toBundle();
//                Intent i = new Intent(getContext(), HotelSrpActivity.class);
//                i.putExtra("image", drawables[positionInfo.getPosition()]);
//                i.putExtra("title", titlesArray[positionInfo.getPosition()]);
//                getContext().startActivity(i, bundle);
//            }
//        });
    }

    @Override
    public void onClick(View clickedView) {
        switch (clickedView.getId()) {
        }
    }

}