package com.vipul.bit_hotels.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.utils.Blur;

public class BlurredLayoutActivity extends BaseActivity {
    ImageView ivNoTrip;
    TextView tvButton;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blurred_layout);
        initializeToolbar();

        ivNoTrip = (ImageView) findViewById(R.id.iv_no_trip);
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap blurTemplate = BitmapFactory.decodeResource(getResources(), R.drawable.img_city_8);
        ivNoTrip.setImageBitmap(Blur.fastblur(this, ((BitmapDrawable) ivNoTrip.getDrawable()).getBitmap(), 25));
    }

    private void initializeToolbar() {
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
