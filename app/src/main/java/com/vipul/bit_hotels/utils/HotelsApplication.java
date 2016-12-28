package com.vipul.bit_hotels.utils;

import android.app.Application;
import android.widget.Toast;

import com.vipul.bit_hotels.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by vipulkumar on 17/10/16.
 */

public class HotelsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeCalligraphy();
    }

    private void initializeUi() {
        Toast.makeText(this, "initialize ui", Toast.LENGTH_SHORT).show();
    }

    private void initializeCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/open_sansc_medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

//        Bitter - Serif fonts
//        Dekar.otf - SD fonts, sophisticated
    }
}
